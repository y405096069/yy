package com.nfdw.service.impl;


import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.OnlineExercises;
import com.nfdw.mapper.OnlineExercisesMapper;
import com.nfdw.service.OnlineExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OnlineExercisesServiceImpl extends BaseServiceImpl<OnlineExercises,String> implements OnlineExercisesService {

    @Autowired
    OnlineExercisesMapper onlineExercisesMapper;

    @Override
    public BaseMapper<OnlineExercises, String> getMappser() {
        return onlineExercisesMapper;
    }

    @Override
    public int deleteById(String id) {
        return onlineExercisesMapper.deleteById(id);
    }

    @Override
    public int updateById(OnlineExercises onlineExercises) {
        return onlineExercisesMapper.updateById(onlineExercises);
    }

    @Override
    public OnlineExercises selectGetByPrimaryKey(String id) {
        return onlineExercisesMapper.selectGetByPrimaryKey(id);
    }

    @Override
    public List<OnlineExercises> showMenuJsonList() {
        return null;
    }

    @Override
    public List<OnlineExercises> getAll() {
        return onlineExercisesMapper.getAll();
    }
}
