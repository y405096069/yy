package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.Notice;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/16
 * @Description:
 */
public interface NoticeService extends BaseService<Notice,String> {
    Notice getNoticeById(String id);

    List<Notice> showMenuJsonList();

    int deleteById(String id);

}
