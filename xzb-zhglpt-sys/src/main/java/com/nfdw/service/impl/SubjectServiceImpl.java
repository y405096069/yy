package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.SpecManagement;
import com.nfdw.entity.Subject;
import com.nfdw.mapper.SubjectMapper;
import com.nfdw.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/19
 * @Description:
 */
@Service
public class SubjectServiceImpl extends BaseServiceImpl<Subject,String> implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public BaseMapper<Subject, String> getMappser() {
        return subjectMapper;
    }

    @Override
    public List<SpecManagement> selectSpecManagementById() {
        return subjectMapper.selectSpecManagementById();
    }
}
