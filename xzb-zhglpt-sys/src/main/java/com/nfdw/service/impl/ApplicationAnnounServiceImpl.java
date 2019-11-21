package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.ApplicationAnnoun;
import com.nfdw.mapper.ApplicationAnnounMapper;
import com.nfdw.mapper.EnrolmentCharterMapper;
import com.nfdw.service.ApplicationAnnounService;
import com.nfdw.service.EnrolmentCharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationAnnounServiceImpl extends BaseServiceImpl<ApplicationAnnoun,String> implements ApplicationAnnounService {

    @Autowired
    private ApplicationAnnounMapper applicationAnnounMapper;

    @Override
    public BaseMapper<ApplicationAnnoun, String> getMappser() {
        return applicationAnnounMapper;
    }

    @Override
    public int deleteById(String id) {
        return applicationAnnounMapper.deleteById(id);
    }

    @Override
    public int updateById(ApplicationAnnoun applicationAnnoun) {
        return applicationAnnounMapper.updateById(applicationAnnoun);
    }

    @Override
    public ApplicationAnnoun selectGetByPrimaryKey(String id) {
        return applicationAnnounMapper.selectGetByPrimaryKey(id);
    }

    @Override
    public List<ApplicationAnnoun> showMenuJsonList() {

        return null;
    }

    @Override
    public List<ApplicationAnnoun> getAll() {
        return applicationAnnounMapper.getAll();
    }
}
