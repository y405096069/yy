package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Notice;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/16
 * @Description: 信息通知
 */
public interface NoticeMapper extends BaseMapper<Notice,String> {
    int deleteById(String id);
}
