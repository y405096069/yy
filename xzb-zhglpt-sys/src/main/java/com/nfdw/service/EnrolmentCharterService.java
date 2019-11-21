package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.EnrolmentCharter;
import com.nfdw.entity.SysPosition;

import java.util.List;

public interface EnrolmentCharterService extends BaseService<EnrolmentCharter,String> {

    EnrolmentCharter selectByPrimaryKey(String id);


    EnrolmentCharter selectByPrimaryKey1(String id);


    int updateById(EnrolmentCharter enrolmentCharter);

    int add(EnrolmentCharter enrolmentCharter);

    List<EnrolmentCharter> getAll();
    List<EnrolmentCharter> showMenuJsonList();

    int deleteById(String id);
}
