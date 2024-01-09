package cn.zwz.ky.serviceimpl;

import cn.zwz.ky.mapper.BookTypeMapper;
import cn.zwz.ky.entity.BookType;
import cn.zwz.ky.service.IBookTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 图书类型 服务层接口实现
 whp
 */
@Slf4j
@Service
@Transactional
public class IBookTypeServiceImpl extends ServiceImpl<BookTypeMapper, BookType> implements IBookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;
}
