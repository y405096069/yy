package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.*;
import com.nfdw.mapper.AchieveMapper;
import com.nfdw.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AchieveServiceImpl extends BaseServiceImpl<Achievement_Summary, String> implements AchieveService {

    @Autowired
    AchieveMapper acMapper;

    @Override
    public BaseMapper<Achievement_Summary, String> getMappser() {
        return acMapper;
    }

    @Override
    public String[] selectAllHigh_province() {
        return acMapper.selectAllHigh_province();
    }

    @Override
    public String[] selectAllHigh_provinceByEId(int eid) {
        return acMapper.selectAllHigh_provinceByEId(eid);
    }

    @Override
    public Achievement_Summary getIdByExam_num(String exe_num) {
        return acMapper.getIdByExam_num(exe_num);
    }

    @Override
    public List<Achievement_Summary> selectListByPage2(int exam_id,String qualified_mark) {
        return acMapper.selectListByPage2(exam_id,qualified_mark);
    }

    @Override
    public String selectSpecialty_NameById(int id) {
        return acMapper.selectSpecialty_NameById(id);
    }

    @Override
    public Achievement_Summary getAchieveById_Card(String id_card) {
        return acMapper.getAchieveById_Card(id_card);
    }

    @Override
    public boolean updFirst_GradeByEId(int eid) {
        return acMapper.updFirst_GradeByEId(eid)>0;
    }

    @Override
    public boolean updComplex_GradeByEId(int eid) {
        return acMapper.updComplex_GradeByEId(eid)>0;
    }

    @Override
    public boolean updAchieve_Grade(Achievement_Summary a_sum) {
        return acMapper.updAchieve_Grade(a_sum)>0;
    }

    @Override
    public int selectFirstNational_same_name(int exam_id, String professional_name, String high_province, double first_subjects_total) {
        return acMapper.selectFirstNational_same_name(exam_id,professional_name,high_province,first_subjects_total);
    }

    @Override
    public int selectLastNational_same_name(int exam_id, String professional_name, String high_province, double total_score) {
        return acMapper.selectLastNational_same_name(exam_id,professional_name,high_province,total_score);
    }

    @Override
    public StudentInformation selectStudentByUid(String student_userid) {
        return acMapper.selectStudentByUid(student_userid);
    }

    @Override
    public boolean addAchieve(Achievement_Summary a_sum) {
        return acMapper.addAchieve(a_sum)>0;
    }

    @Override
    public Examination getExamByEid(int exam_id) {
        return acMapper.getExamByEid(exam_id);
    }

    @Override
    public SpecManagement getSpcById(int id) {
        return acMapper.getSpcById(id);
    }

    @Override
    public List<Cskmqz> getByEid(int exam_id) {
        return acMapper.getByEid(exam_id);
    }

    @Override
    public List<Fskmqz> getByEid2(int exam_id) {
        return acMapper.getByEid2(exam_id);
    }
}
