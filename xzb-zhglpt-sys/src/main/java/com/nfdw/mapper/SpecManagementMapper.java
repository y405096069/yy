package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.SpecCollect;
import com.nfdw.entity.SpecManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecManagementMapper extends BaseMapper<SpecManagement,String> {

    List<SpecCollect> selectSpecCollect();

    SpecCollect selectIdByName(@Param("collect_id") String id);


    int add(SpecManagement entity);

    List<SpecManagement> selectSpecManagement();

}
