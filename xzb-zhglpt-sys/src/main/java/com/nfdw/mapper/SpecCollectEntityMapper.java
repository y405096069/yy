package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.SpecCollectEntity;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description:
 */
public interface SpecCollectEntityMapper extends BaseMapper<SpecCollectEntity,String> {
    int add(SpecCollectEntity entity);
}
