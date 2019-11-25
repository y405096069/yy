package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.SpecEntity;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description:
 */
public interface SpecEntityService extends BaseService<SpecEntity,String> {

    int add(SpecEntity entity);
}
