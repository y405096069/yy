package com.nfdw.service.impl;

import com.nfdw.entity.Examination;
import com.nfdw.entity.StudentExamAudit;
import com.nfdw.entity.StudentInformation;
import com.nfdw.mapper.StudentInformationMapper;
import com.nfdw.service.StudentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInformationServiceImpl implements StudentInformationService {
    @Autowired
    private StudentInformationMapper studentInformationMapper;
    @Override
    public int addStudentInformation(StudentInformation studentInformation) {
        return studentInformationMapper.addStudentInformation(studentInformation);
    }

    @Override
    public StudentInformation getUserIDByStudentInformation(String name) {
        return studentInformationMapper.getUserIDByStudentInformation(name);
    }

    @Override
    public List<Examination> getListExamination(String currentDate,String examinee_province,String subject_type,String examName,String subjectName,String create_start_time) {
        return studentInformationMapper.getListExamination(currentDate,examinee_province,subject_type,examName,subjectName,create_start_time);
    }

    @Override
    public int addStudentExamAudit(StudentExamAudit studentExamAudit) {
        return studentInformationMapper.addStudentExamAudit(studentExamAudit);
    }

    @Override
    public int getStudentInfoConunt(String username) {
        return studentInformationMapper.getStudentInfoConunt(username);
    }
}
