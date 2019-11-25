package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.*;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/13
 * @Description:
 */
public interface ExaminationMapper extends BaseMapper<Examination,String> {

    Examination queryInfoById(String id);
    int addExamination(Examination examination);
    int uplateById(Examination examination);

    void deleteById(String id);

    List<Infor_collection> selectInforById();

    List<Subject> selectBySubject();

    List<SpecManagement> selectBySpec();
    List<Examination> selectpa();

    List<Infor_collection> selectcollection();

    Infor_collection selectmb(String id);

    SpecManagement selectid(String id);
    //考试场次
    int addKc(Kc kc);
   //初考科目权重
   int addcskm(Cskmqz cskmqz);
   //复试科目权重
   int addfskm(Fskmqz fskmqz);
}
