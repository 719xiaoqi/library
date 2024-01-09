package cn.zwz.ky.controller;

import cn.zwz.basics.utils.PageUtil;
import cn.zwz.basics.utils.ResultUtil;
import cn.zwz.basics.baseVo.PageVo;
import cn.zwz.basics.baseVo.Result;
import cn.zwz.data.utils.ZwzNullUtils;
import cn.zwz.ky.entity.Book;
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
@Api(tags = "图书管理接口")
@RequestMapping("/zwz/book")
@Transactional
public class BookController {

    @Autowired
    private IBookService iBookService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条图书")
    public Result<Book> get(@RequestParam String id){
        return new ResultUtil<Book>().setData(iBookService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部图书个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iBookService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部图书")
    public Result<List<Book>> getAll(){
        return new ResultUtil<List<Book>>().setData(iBookService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询图书")
    public Result<IPage<Book>> getByPage(@ModelAttribute Book book ,@ModelAttribute PageVo page){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        if(!ZwzNullUtils.isNull(book.getTitle())) {
            qw.like("title",book.getTitle());
        }
        if(!ZwzNullUtils.isNull(book.getIsbn())) {
            qw.like("isbn",book.getIsbn());
        }
        IPage<Book> data = iBookService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<Book>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改图书")
    public Result<Book> saveOrUpdate(Book book){
        if(iBookService.saveOrUpdate(book)){
            return new ResultUtil<Book>().setData(book);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增图书")
    public Result<Book> insert(Book book){
        iBookService.saveOrUpdate(book);
        return new ResultUtil<Book>().setData(book);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑图书")
    public Result<Book> update(Book book){
        iBookService.saveOrUpdate(book);
        return new ResultUtil<Book>().setData(book);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除图书")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iBookService.removeById(id);
        }
        return ResultUtil.success();
    }
}
