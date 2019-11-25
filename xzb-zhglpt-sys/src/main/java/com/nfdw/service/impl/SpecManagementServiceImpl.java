package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.SpecCollect;
import com.nfdw.entity.SpecManagement;
import com.nfdw.mapper.SpecManagementMapper;
import com.nfdw.service.SpecManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/18
 * @Description:
 */
@Service
public class SpecManagementServiceImpl extends BaseServiceImpl<SpecManagement,String> implements SpecManagementService {

    @Autowired
    private SpecManagementMapper specManagementMapper;


    @Override
    public BaseMapper<SpecManagement, String> getMappser() {
        return specManagementMapper;
    }

    @Override
    public List<SpecCollect> selectSpecCollect() {
        return specManagementMapper.selectSpecCollect();
    }

    @Override
    public SpecCollect selectIdByName(String id) {
        return specManagementMapper.selectIdByName(id);
    }

    @Override
    public int add(SpecManagement entity) {
        return specManagementMapper.add(entity);
    }

    @Override
    public List<SpecManagement> selectSpecManagement() {
        return specManagementMapper.selectSpecManagement();
    }
}
