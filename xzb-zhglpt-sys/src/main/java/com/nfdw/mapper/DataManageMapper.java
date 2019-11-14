package com.nfdw.mapper;/**
 * @author caisheng
 * @create 2019-11-13 10:39
 */



import com.nfdw.entity.Student;
import com.nfdw.entity.TheTestInformation;
import com.nfdw.pojo.Condition;

import java.util.List;

/**
 * 信息管理接口
 * @author
 * @create 2019-11-13 10:39
 */
public interface DataManageMapper {

   /*所有学生信息*/
    public List<Student> datadisplay();

   /*单一学生全部信息*/
    public Student Thedetailedinformation(int id);

    /*审核信息*/
    public List<TheTestInformation> Thetestinformationy(int id);

    /*条件查询及分页*/
    public List<Student> selectUseIf(Condition condition);


}
