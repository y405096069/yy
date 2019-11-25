package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.SpecCollectEntity;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description:
 */
public interface SpecCollectEntityService extends BaseService<SpecCollectEntity,String> {

    int add(SpecCollectEntity entity);
}
