package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.*;

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
    void uplateById(Examination examination);
    List<Infor_collection> selectInforById();

    List<Subject> selectBySubject();

    List<SpecManagement> selectBySpec();

    List<Examination> selectpa();
   //信息采集模板
    List<Infor_collection> selectcollection();

    Infor_collection selectmb(String id);


    SpecManagement selectid(String id);

    //考试场次
    int addkc(Kc kc);
    int addcskm(Cskmqz cskmqz);
    int addfskm(Fskmqz fskmqz);
}
