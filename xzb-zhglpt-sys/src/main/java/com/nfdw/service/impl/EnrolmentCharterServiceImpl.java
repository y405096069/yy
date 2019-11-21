package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.EnrolmentCharter;
import com.nfdw.mapper.EnrolmentCharterMapper;
import com.nfdw.service.EnrolmentCharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnrolmentCharterServiceImpl extends BaseServiceImpl<EnrolmentCharter,String> implements EnrolmentCharterService {

    @Autowired
    private EnrolmentCharterMapper enrolmentCharterMapper;

    @Override
    public BaseMapper<EnrolmentCharter, String> getMappser() {
        return enrolmentCharterMapper;
    }

    @Override
    public EnrolmentCharter selectByPrimaryKey(String id) {
        return enrolmentCharterMapper.selectByPrimaryKey(id);
    }

    @Override
    public EnrolmentCharter selectByPrimaryKey1(String id) {
        return enrolmentCharterMapper.selectByPrimaryKey1(id);
    }


    @Override
    public List<EnrolmentCharter> getAll() {
        return enrolmentCharterMapper.getAll();
    }

    @Override
    public int updateById(EnrolmentCharter enrolmentCharter) {
        return enrolmentCharterMapper.updateById(enrolmentCharter);
    }

    @Override
    public int add(EnrolmentCharter enrolmentCharter) {
        return enrolmentCharterMapper.add(enrolmentCharter);
    }


    @Override
    public int insert(EnrolmentCharter enrolmentCharter) {
        return enrolmentCharterMapper.insert(enrolmentCharter);
    }

    @Override
    public List<EnrolmentCharter> showMenuJsonList() {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return enrolmentCharterMapper.deleteById(id);
    }
}
