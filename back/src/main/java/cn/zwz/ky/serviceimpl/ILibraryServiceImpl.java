package cn.zwz.ky.serviceimpl;

import cn.zwz.ky.mapper.LibraryMapper;
import cn.zwz.ky.entity.Library;
import cn.zwz.ky.service.ILibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 图书馆 服务层接口实现
 whp
 */
@Slf4j
@Service
@Transactional
public class ILibraryServiceImpl extends ServiceImpl<LibraryMapper, Library> implements ILibraryService {

    @Autowired
    private LibraryMapper libraryMapper;
}
