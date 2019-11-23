package com.nfdw.mapper;


import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Achievement_Summary;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AchieveMapper extends BaseMapper<Achievement_Summary,String> {

    String[] selectAllHigh_province();

    Achievement_Summary getIdByExam_num(@Param("exe_num") String exe_num); //考生号

    List<Achievement_Summary >selectListByPage2(@Param("exam_id") int exam_id);

}
