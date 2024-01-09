package cn.zwz.ky.serviceimpl;

import cn.zwz.ky.mapper.BookBorrowingMapper;
import cn.zwz.ky.entity.BookBorrowing;
import cn.zwz.ky.service.IBookBorrowingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 图书借阅 服务层接口实现
 whp
 */
@Slf4j
@Service
@Transactional
public class IBookBorrowingServiceImpl extends ServiceImpl<BookBorrowingMapper, BookBorrowing> implements IBookBorrowingService {

    @Autowired
    private BookBorrowingMapper bookBorrowingMapper;
}
