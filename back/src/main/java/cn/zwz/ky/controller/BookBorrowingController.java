package cn.zwz.ky.controller;

import cn.hutool.core.date.DateUtil;
import cn.zwz.basics.utils.PageUtil;
import cn.zwz.basics.utils.ResultUtil;
import cn.zwz.basics.baseVo.PageVo;
import cn.zwz.basics.baseVo.Result;
import cn.zwz.basics.utils.SecurityUtil;
import cn.zwz.data.entity.User;
import cn.zwz.data.service.IUserService;
import cn.zwz.data.utils.ZwzNullUtils;
import cn.zwz.ky.entity.Book;
import cn.zwz.ky.entity.BookBorrowing;
import cn.zwz.ky.service.IBookBorrowingService;
import cn.zwz.ky.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 whp
 */
@Slf4j
@RestController
@Api(tags = "图书借阅管理接口")
@RequestMapping("/zwz/bookBorrowing")
@Transactional
public class BookBorrowingController {

    @Autowired
    private IBookBorrowingService iBookBorrowingService;

    @Autowired
    private IBookService iBookService;

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条图书借阅")
    public Result<BookBorrowing> get(@RequestParam String id){
        return new ResultUtil<BookBorrowing>().setData(iBookBorrowingService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部图书借阅个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iBookBorrowingService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部图书借阅")
    public Result<List<BookBorrowing>> getAll(){
        return new ResultUtil<List<BookBorrowing>>().setData(iBookBorrowingService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询图书借阅")
    public Result<IPage<BookBorrowing>> getByPage(@ModelAttribute BookBorrowing bookBorrowing ,@ModelAttribute PageVo page){
        QueryWrapper<BookBorrowing> qw = new QueryWrapper<>();
        User currUser = securityUtil.getCurrUser();
        QueryWrapper<User> userQw = new QueryWrapper<>();
        userQw.eq("id",currUser.getId());
        userQw.inSql("id","SELECT id FROM a_user WHERE del_flag = 0 AND id IN (SELECT user_id FROM a_user_role WHERE del_flag = 0 AND role_id = '1536606659751841799')");
        if(iUserService.count(userQw) < 1L) {
            qw.eq("user_id",currUser.getId());
        }
        if(!ZwzNullUtils.isNull(bookBorrowing.getBookName())) {
            qw.like("book_name",bookBorrowing.getBookName());
        }
        if(!ZwzNullUtils.isNull(bookBorrowing.getUserName())) {
            qw.like("user_name",bookBorrowing.getUserName());
        }
        IPage<BookBorrowing> data = iBookBorrowingService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<BookBorrowing>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改图书借阅")
    public Result<BookBorrowing> saveOrUpdate(BookBorrowing bookBorrowing){
        if(iBookBorrowingService.saveOrUpdate(bookBorrowing)){
            return new ResultUtil<BookBorrowing>().setData(bookBorrowing);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增图书借阅")
    public Result<BookBorrowing> insert(BookBorrowing bookBorrowing){
        Book book = iBookService.getById(bookBorrowing.getBookId());
        if(book == null) {
            return ResultUtil.error("图书不存在");
        }
        User currUser = securityUtil.getCurrUser();
        bookBorrowing.setBookName(book.getTitle());
        bookBorrowing.setBookIsbn(book.getIsbn());
        bookBorrowing.setUserId(currUser.getId());
        bookBorrowing.setUserName(currUser.getNickname());
        bookBorrowing.setTime1(DateUtil.now());
        bookBorrowing.setStatus("未归还");
        bookBorrowing.setTime2("");
        iBookBorrowingService.saveOrUpdate(bookBorrowing);
        return new ResultUtil<BookBorrowing>().setData(bookBorrowing);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑图书借阅")
    public Result<BookBorrowing> update(BookBorrowing bookBorrowing){
        iBookBorrowingService.saveOrUpdate(bookBorrowing);
        return new ResultUtil<BookBorrowing>().setData(bookBorrowing);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除图书借阅")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iBookBorrowingService.removeById(id);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/re", method = RequestMethod.GET)
    @ApiOperation(value = "归还图书")
    public Result<Object> re(@RequestParam String id){
        BookBorrowing bb = iBookBorrowingService.getById(id);
        if(bb == null) {
            return ResultUtil.error("借阅不存在");
        }
        bb.setStatus("已归还");
        bb.setTime2(DateUtil.now());
        iBookBorrowingService.saveOrUpdate(bb);
        return ResultUtil.success();
    }
}
