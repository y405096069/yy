package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Examination;
import com.nfdw.entity.Infor_collection;
import com.nfdw.entity.SpecManagement;
import com.nfdw.entity.Subject;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/13
 * @Description:
 */
public interface ExaminationMapper extends BaseMapper<Examination,String> {

    Examination queryInfoById(String id);
    int addExamination(Examination examination);
    int uplateById(String id);

    void deleteById(String id);

    List<Infor_collection> selectInforById();

    List<Subject> selectBySubject();

    List<SpecManagement> selectBySpec();


}
