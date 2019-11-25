package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.SpecEntity;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description:
 */
public interface SpecEntityMapper extends BaseMapper<SpecEntity,String> {
    int add(SpecEntity entity);
}
