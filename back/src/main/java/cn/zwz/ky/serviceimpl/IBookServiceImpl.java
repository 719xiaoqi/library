package cn.zwz.ky.serviceimpl;

import cn.zwz.ky.mapper.BookMapper;
import cn.zwz.ky.entity.Book;
import cn.zwz.ky.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 图书 服务层接口实现
 whp
 */
@Slf4j
@Service
@Transactional
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;
}
