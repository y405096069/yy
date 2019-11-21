package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.OnlineExercises;

import java.util.List;

public interface OnlineExercisesService extends BaseService<OnlineExercises,String> {
    int deleteById(String id);
    int updateById(OnlineExercises applicationAnnoun);
    OnlineExercises selectGetByPrimaryKey(String id);
    List<OnlineExercises> showMenuJsonList();
    List<OnlineExercises> getAll();

}
