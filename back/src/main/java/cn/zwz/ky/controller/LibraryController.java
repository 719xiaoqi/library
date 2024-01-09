package cn.zwz.ky.controller;

import cn.zwz.basics.utils.PageUtil;
import cn.zwz.basics.utils.ResultUtil;
import cn.zwz.basics.baseVo.PageVo;
import cn.zwz.basics.baseVo.Result;
import cn.zwz.data.utils.ZwzNullUtils;
import cn.zwz.ky.entity.Library;
import cn.zwz.ky.service.ILibraryService;
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
@Api(tags = "图书馆管理接口")
@RequestMapping("/zwz/library")
@Transactional
public class LibraryController {

    @Autowired
    private ILibraryService iLibraryService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条图书馆")
    public Result<Library> get(@RequestParam String id){
        return new ResultUtil<Library>().setData(iLibraryService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部图书馆个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iLibraryService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部图书馆")
    public Result<List<Library>> getAll(){
        return new ResultUtil<List<Library>>().setData(iLibraryService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询图书馆")
    public Result<IPage<Library>> getByPage(@ModelAttribute Library library ,@ModelAttribute PageVo page){
        QueryWrapper<Library> qw = new QueryWrapper<>();
        if(!ZwzNullUtils.isNull(library.getTitle())) {
            qw.like("title",library.getTitle());
        }
        if(!ZwzNullUtils.isNull(library.getAddress())) {
            qw.like("address",library.getAddress());
        }
        IPage<Library> data = iLibraryService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<Library>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改图书馆")
    public Result<Library> saveOrUpdate(Library library){
        if(iLibraryService.saveOrUpdate(library)){
            return new ResultUtil<Library>().setData(library);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增图书馆")
    public Result<Library> insert(Library library){
        iLibraryService.saveOrUpdate(library);
        return new ResultUtil<Library>().setData(library);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑图书馆")
    public Result<Library> update(Library library){
        iLibraryService.saveOrUpdate(library);
        return new ResultUtil<Library>().setData(library);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除图书馆")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iLibraryService.removeById(id);
        }
        return ResultUtil.success();
    }
}
