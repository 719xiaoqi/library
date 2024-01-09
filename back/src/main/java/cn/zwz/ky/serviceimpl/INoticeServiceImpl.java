package cn.zwz.ky.serviceimpl;

import cn.zwz.ky.mapper.NoticeMapper;
import cn.zwz.ky.entity.Notice;
import cn.zwz.ky.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公告 服务层接口实现
 whp
 */
@Slf4j
@Service
@Transactional
public class INoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
}
