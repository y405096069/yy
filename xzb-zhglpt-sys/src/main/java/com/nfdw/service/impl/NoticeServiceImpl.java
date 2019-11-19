package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.Notice;
import com.nfdw.mapper.NoticeMapper;
import com.nfdw.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/16
 * @Description:
 */
@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice,String> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public BaseMapper<Notice, String> getMappser() {
        return noticeMapper;
    }


    @Override
    public Notice getNoticeById(String id) {
        return null;
    }

    @Override
    public List<Notice> showMenuJsonList() {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return noticeMapper.deleteById(id);
    }
}
