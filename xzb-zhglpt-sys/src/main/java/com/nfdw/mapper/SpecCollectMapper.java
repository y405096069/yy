package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.SpecCollect;
import com.nfdw.entity.SysDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecCollectMapper extends BaseMapper<SpecCollect,String> {

    int add(SpecCollect entity);
}
