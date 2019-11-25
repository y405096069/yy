package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.SpecCollectEntity;
import com.nfdw.mapper.SpecCollectEntityMapper;
import com.nfdw.service.SpecCollectEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description:
 */
@Service
public class SpecCollectEntityServiceImpl extends BaseServiceImpl<SpecCollectEntity,String> implements SpecCollectEntityService {

    @Autowired
    private SpecCollectEntityMapper specCollectEntityMapper;
    @Override
    public BaseMapper<SpecCollectEntity, String> getMappser() {
        return specCollectEntityMapper;
    }

    @Override
    public int add(SpecCollectEntity entity) {
        return specCollectEntityMapper.add(entity);
    }
}
