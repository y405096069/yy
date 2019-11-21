package com.nfdw.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "j_student_information")
@ToString
@Data
public class AdmissionTicket {
    //主键ID
    @Id
    @GeneratedValue(generator = "JDBC")
    private String student_id;
    //关联用户ID
    private String student_userid;
    //证件类型
    private String certificate_type;
    //证件号码
    private String certificate_number;
    //学生姓名
    private String name;
    //学生性别
    private String sex;
    //民族
    private String nation;
    //出生日期
    private String birthdate;
    //街道详情
    private String street;
    //收件人
    private String recipient;
    //手机号码
    private String phone;
    //邮政编码
    private String postal_code;
    //电子邮箱
    private String email;
    //考生类型
    private String examinee_type;
    //考生学历
    private String examinee_education;
    //考生省份
    private String examinee_province;
    //政治面貌
    private String politics_status;
    //应往届
    private String graduate_type;
    //毕业中学
    private String graduate_middle;
    //考生号码
    private String examinee_number;
    //文理科1
    private String subject_type;
    //家庭联络员姓名
    private String member_name;
    //家庭联络员关系
    private String member_relationship;
    //家庭联络员职业
    private String member_occupation;
    //家庭联络员工作单位
    private String member_work;
    //家庭联络员手机号码
    private String member_phone;
    //正面照
    private String photograph;



}
