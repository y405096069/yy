package com.nfdw.entity;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "examinee_user")
@Data
public class Examinee_User {                //考生信息表

    private int id;

    private String username;

    private String password;

    private String document_type;       //证件类型

    private String document_num;        //证件号码

    private String personname;          //人名

    private String gender;              //性别

    private String nation;              //民族

    private String date_birth;          //出生日期

    private String street_details;      //街道详情

    private String addressee;           //收件人

    private String mob_phone;           //本人手机

    private String postal_code;         //邮政编码

    private String e_mail;              //电子邮件

    private String examinee_type;       //考生类型

    private String examinee_education;  //考生学历

    private String examinee_province;   //考生省份

    private String political_outlook;   //政治面貌

    private String session;             //应往届

    private String graduate_middle_school;//毕业中学

    private String examinee_number;     //考生号

    private String subject;             //文理科

    private String family_name;         //家庭成员姓名

    private String family_relationship; //关系

    private String family_occupation;   //职业

    private String family_work_unit;    //工作单位

    private String family_phone;        //手机号码

    private String positive_photo;      //正面照片

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getDocument_num() {
        return document_num;
    }

    public void setDocument_num(String document_num) {
        this.document_num = document_num;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getStreet_details() {
        return street_details;
    }

    public void setStreet_details(String street_details) {
        this.street_details = street_details;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getMob_phone() {
        return mob_phone;
    }

    public void setMob_phone(String mob_phone) {
        this.mob_phone = mob_phone;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
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

    public String getPolitical_outlook() {
        return political_outlook;
    }

    public void setPolitical_outlook(String political_outlook) {
        this.political_outlook = political_outlook;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getGraduate_middle_school() {
        return graduate_middle_school;
    }

    public void setGraduate_middle_school(String graduate_middle_school) {
        this.graduate_middle_school = graduate_middle_school;
    }

    public String getExaminee_number() {
        return examinee_number;
    }

    public void setExaminee_number(String examinee_number) {
        this.examinee_number = examinee_number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getFamily_relationship() {
        return family_relationship;
    }

    public void setFamily_relationship(String family_relationship) {
        this.family_relationship = family_relationship;
    }

    public String getFamily_occupation() {
        return family_occupation;
    }

    public void setFamily_occupation(String family_occupation) {
        this.family_occupation = family_occupation;
    }

    public String getFamily_work_unit() {
        return family_work_unit;
    }

    public void setFamily_work_unit(String family_work_unit) {
        this.family_work_unit = family_work_unit;
    }

    public String getFamily_phone() {
        return family_phone;
    }

    public void setFamily_phone(String family_phone) {
        this.family_phone = family_phone;
    }

    public String getPositive_photo() {
        return positive_photo;
    }

    public void setPositive_photo(String positive_photo) {
        this.positive_photo = positive_photo;
    }
}
