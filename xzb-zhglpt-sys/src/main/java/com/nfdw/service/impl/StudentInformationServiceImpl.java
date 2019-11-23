package com.nfdw.service.impl;

import com.nfdw.entity.Examination;
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
    public List<Examination> getListExamination(String create_start_time,String exam,String name,StudentInformation studentInformation, String currentDate) {
        return studentInformationMapper.getListExamination(create_start_time,name,exam,studentInformation,currentDate);
    }
}
