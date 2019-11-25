package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.*;
import com.nfdw.mapper.ExaminationMapper;
import com.nfdw.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/12
 * @Description:
 */
@Service
public class ExaminationServiceImpl extends BaseServiceImpl<Examination,String> implements ExaminationService {


    @Autowired
    ExaminationMapper examinationMapper;



    @Override
    public BaseMapper<Examination, String> getMappser() {
        return examinationMapper;
    }

    @Override
    public int addExamination(Examination examination) {

       return examinationMapper.addExamination(examination);
    }

    @Override
    public Examination queryForById(String id) {
        return examinationMapper.queryInfoById(id);
    }

    @Override
    public void deleteById(String id) {
        examinationMapper.deleteById(id);
    }

    @Override
    public void uplateById(Examination examination) {
      examinationMapper.uplateById(examination);
    }

    @Override
    public List<Infor_collection> selectInforById() {
        return examinationMapper.selectInforById();
    }

    @Override
    public List<Subject> selectBySubject() {
        return examinationMapper.selectBySubject();
    }

    @Override
    public List<SpecManagement> selectBySpec() {
        return examinationMapper.selectBySpec();
    }

    @Override
    public List<Examination> selectpa() {
        return examinationMapper.selectpa();
    }

    @Override
    public List<Infor_collection> selectcollection() {
        return examinationMapper.selectcollection();
    }

    @Override
    public Infor_collection selectmb(String id) {
        return examinationMapper.selectmb(id);
    }

    @Override
    public SpecManagement selectid(String id) {
        return examinationMapper.selectid(id);
    }

    @Override
    public int addkc(Kc kc) {
        return examinationMapper.addKc(kc);
    }

    @Override
    public int addcskm(Cskmqz cskmqz) {
        return examinationMapper.addcskm(cskmqz);
    }

    @Override
    public int addfskm(Fskmqz fskmqz) {
        return examinationMapper.addfskm(fskmqz);
    }


}
