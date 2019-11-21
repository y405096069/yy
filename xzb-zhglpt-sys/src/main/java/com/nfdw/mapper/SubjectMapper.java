package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.SpecManagement;
import com.nfdw.entity.Subject;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/19
 * @Description:
 */
public interface SubjectMapper extends BaseMapper<Subject,String>{
    List<SpecManagement> selectSpecManagementById();
}
