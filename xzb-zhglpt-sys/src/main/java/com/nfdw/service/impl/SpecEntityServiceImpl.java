package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.SpecEntity;
import com.nfdw.mapper.SpecEntityMapper;
import com.nfdw.service.SpecEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description:
 */
@Service
public class SpecEntityServiceImpl extends BaseServiceImpl<SpecEntity,String> implements SpecEntityService {

    @Autowired
    private SpecEntityMapper specEntityMapper;
    @Override
    public BaseMapper<SpecEntity, String> getMappser() {
        return specEntityMapper;
    }

    @Override
    public int add(SpecEntity entity) {
        return specEntityMapper.add(entity);
    }
}
