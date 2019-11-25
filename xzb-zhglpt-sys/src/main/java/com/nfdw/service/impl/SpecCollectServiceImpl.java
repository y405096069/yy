package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.SpecCollect;
import com.nfdw.entity.SysDepartment;
import com.nfdw.mapper.SpecCollectMapper;
import com.nfdw.mapper.SysDepartmentMapper;
import com.nfdw.service.DepartmentService;
import com.nfdw.service.SpecCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecCollectServiceImpl extends BaseServiceImpl<SpecCollect, String> implements SpecCollectService {

    @Autowired
    private SpecCollectMapper specCollectMapper;


    @Override
    public BaseMapper<SpecCollect, String> getMappser() {
        return specCollectMapper;
    }


    @Override
    public int add(SpecCollect entity) {
        return specCollectMapper.add(entity);
    }
}
