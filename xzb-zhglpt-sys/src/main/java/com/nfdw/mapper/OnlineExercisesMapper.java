package com.nfdw.mapper;

import java.util.*;
import com.nfdw.base.BaseMapper;
import com.nfdw.entity.OnlineExercises;

public interface OnlineExercisesMapper extends BaseMapper<OnlineExercises,String> {
    int deleteById(String id);
    int updateById(OnlineExercises onlineExercises);
    OnlineExercises selectGetByPrimaryKey(String id);
    List<OnlineExercises> getAll();

}
