package com.nfdw.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 专业合格统计
 */
@Mapper
public interface ProfessionQualifiedMapper {

    public Integer QualifiedAvg();//合格平均分数
    public Integer QualifiedNumber();//合格人数



}
