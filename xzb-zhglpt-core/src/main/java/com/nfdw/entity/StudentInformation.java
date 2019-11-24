package com.nfdw.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author JiangXiaYang
 * @create 2019-11-15 13:50
 */
@Table(name = "j_student_information")
@Data
@ToString
public class StudentInformation {


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


    //当天时间
    private Date currentDate;
    //考试时间
    private Date create_start_time;
    //考试名称
    private String examName;
    //科目名称
    private String subjectName;

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getCreate_start_time() {
        return create_start_time;
    }

    public void setCreate_start_time(Date create_start_time) {
        this.create_start_time = create_start_time;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStudent_userid() {
        return student_userid;
    }

    public void setStudent_userid(String student_userid) {
        this.student_userid = student_userid;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCertificate_type() {
        return certificate_type;
    }

    public void setCertificate_type(String certificate_type) {
        this.certificate_type = certificate_type;
    }

    public String getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(String certificate_number) {
        this.certificate_number = certificate_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExaminee_type() {
        return examinee_type;
    }

    public void setExaminee_type(String examinee_type) {
        this.examinee_type = examinee_type;
    }

    public String getExaminee_education() {
        return examinee_education;
    }

    public void setExaminee_education(String examinee_education) {
        this.examinee_education = examinee_education;
    }

    public String getExaminee_province() {
        return examinee_province;
    }

    public void setExaminee_province(String examinee_province) {
        this.examinee_province = examinee_province;
    }

    public String getPolitics_status() {
        return politics_status;
    }

    public void setPolitics_status(String politics_status) {
        this.politics_status = politics_status;
    }

    public String getGraduate_type() {
        return graduate_type;
    }

    public void setGraduate_type(String graduate_type) {
        this.graduate_type = graduate_type;
    }

    public String getGraduate_middle() {
        return graduate_middle;
    }

    public void setGraduate_middle(String graduate_middle) {
        this.graduate_middle = graduate_middle;
    }

    public String getExaminee_number() {
        return examinee_number;
    }

    public void setExaminee_number(String examinee_number) {
        this.examinee_number = examinee_number;
    }

    public String getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(String subject_type) {
        this.subject_type = subject_type;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_relationship() {
        return member_relationship;
    }

    public void setMember_relationship(String member_relationship) {
        this.member_relationship = member_relationship;
    }

    public String getMember_occupation() {
        return member_occupation;
    }

    public void setMember_occupation(String member_occupation) {
        this.member_occupation = member_occupation;
    }

    public String getMember_work() {
        return member_work;
    }

    public void setMember_work(String member_work) {
        this.member_work = member_work;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }
}
