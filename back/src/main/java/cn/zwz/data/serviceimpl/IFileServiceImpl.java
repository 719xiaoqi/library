package cn.zwz.data.serviceimpl;

import cn.zwz.data.dao.mapper.FileMapper;
import cn.zwz.data.entity.File;
import cn.zwz.data.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 whp
 */
@Service
public class IFileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
