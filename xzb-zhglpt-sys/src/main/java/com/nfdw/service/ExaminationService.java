package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.Examination;
import com.nfdw.entity.Infor_collection;
import com.nfdw.entity.SpecManagement;
import com.nfdw.entity.Subject;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/12
 * @Description:
 */

public interface ExaminationService extends BaseService<Examination,String> {

    //新建考试
    int addExamination(Examination examination);

    //根据ID查询
    Examination queryForById(String id);

    //根据Id删除
    void deleteById(String id);

    //根据id修改
    void uplateById(String id);
    List<Infor_collection> selectInforById();

    List<Subject> selectBySubject();

    List<SpecManagement> selectBySpec();
}
