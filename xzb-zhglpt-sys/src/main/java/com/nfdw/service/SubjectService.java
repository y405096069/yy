package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.SpecManagement;
import com.nfdw.entity.Subject;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/19
 * @Description:
 */
public interface SubjectService extends BaseService<Subject,String> {

    List<SpecManagement> selectSpecManagementById();
}
