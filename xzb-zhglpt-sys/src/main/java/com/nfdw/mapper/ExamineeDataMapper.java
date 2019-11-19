package com.nfdw.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamineeDataMapper {
    //性别
    public Integer man();//男
    public Integer goddess();//女

    //应往届
    public Integer freshGraduate();//应届生
    public Integer formerGraduate();//往届生

    //民族
    public Integer ethnicHan();//汉族
    public Integer nationalMinority();//少数民族

    //文理科
    public Integer science();//理科
    public Integer arts();//文科


}
