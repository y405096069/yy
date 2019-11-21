package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.EnrolmentCharter;

import java.util.List;

public interface EnrolmentCharterMapper extends BaseMapper<EnrolmentCharter,String> {

    int deleteById(String id);
    int updateById(EnrolmentCharter enrolmentCharter);
    int add(EnrolmentCharter enrolmentCharter);
    List<EnrolmentCharter> getAll();
    EnrolmentCharter selectByPrimaryKey1(String id);
}
