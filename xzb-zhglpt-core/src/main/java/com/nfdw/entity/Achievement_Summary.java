package com.nfdw.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "achievement_summary")
@Data
public class Achievement_Summary {

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private int id;

    @Column(name = "exam_id")
    private int exam_id;                //考试id

    @Column(name = "id_card")           //身份证
    private String id_card;

    @Column(name = "name")          //姓名
    private String name;

    @Column(name = "gender")        //性别
    private String gender;

    @Column(name = "high_province")       //高考省份
    private String high_province;

    @Column(name = "examinee_num")          //考生号
    private String examinee_num;

    @Column(name = "ticket_num")            //准考证号
    private String ticket_num;

    @Column(name = "wl_subject")            //文理科
    private String wl_subject;

    @Column(name = "professional_code")     //专业代码
    private String professional_code;

    @Column(name = "professional_name")     //专业名称
    private String professional_name;

    @Column(name = "national_rankings")         //全国排名
    private int national_rankings;

    @Column(name = "national_same_name")        //全国同名次
    private String national_same_name;

    @Column(name = "provincial_ranking")        //省排名
    private int provincial_ranking;

    @Column(name = "provincial_same_name")      //省同名次
    private String provincial_same_name;

    @Column(name = "qualified_mark")      //合格标志 Y/N
    private String qualified_mark;

    @Column(name = "qualified_line")      //合格线
    private String qualified_line;

    @Column(name = "first_subjects_total")
    private double first_subjects_total;             //初试科目总分

    @Column(name = "complex_subjects_total")
    private double complex_subjects_total;              //复试科目总分

    @Column(name = "total_score")      //总分
    private double total_score;

    @Column(name = "remarks")      //备注
    private String remarks;



    @Column(name = "first_subjects_id1")      //初试科目1   id
    private int first_subjects_id1;

    @Column(name = "first_subjects_name1")      //初试科目1   名称
    private String first_subjects_name1;

    @Column(name = "first_subjects_achieve1")      //初试科目1   成绩
    private double first_subjects_achieve1;

    @Column(name = "first_subjects_achieve_ex1")      //初试科目1   成绩说明
    private String first_subjects_achieve_ex1;

    @Column(name = "first_subjects_id2")      //初试科目2   id
    private int first_subjects_id2;

    @Column(name = "first_subjects_name2")      //初试科目2   名称
    private String first_subjects_name2;

    @Column(name = "first_subjects_achieve2")      //初试科目2   成绩
    private double first_subjects_achieve2;

    @Column(name = "first_subjects_achieve_ex2")      //初试科目2   成绩说明
    private String first_subjects_achieve_ex2;

    @Column(name = "first_subjects_id3")      //初试科目3   id
    private int first_subjects_id3;

    @Column(name = "first_subjects_name3")      //初试科目3   名称
    private String first_subjects_name3;

    @Column(name = "first_subjects_achieve3")      //初试科目3   成绩
    private double first_subjects_achieve3;

    @Column(name = "first_subjects_achieve_ex3")      //初试科目3   成绩说明
    private String first_subjects_achieve_ex3;

    @Column(name = "first_subjects_id4")      //初试科目4   id
    private int first_subjects_id4;

    @Column(name = "first_subjects_name4")      //初试科目4   名称
    private String first_subjects_name4;

    @Column(name = "first_subjects_achieve4")      //初试科目4   成绩
    private double first_subjects_achieve4;

    @Column(name = "first_subjects_achieve_ex4")      //初试科目4   成绩说明
    private String first_subjects_achieve_ex4;

    @Column(name = "first_subjects_id5")      //初试科目5   id
    private int first_subjects_id5;

    @Column(name = "first_subjects_name5")      //初试科目5   名称
    private String first_subjects_name5;

    @Column(name = "first_subjects_achieve5")      //初试科目5   成绩
    private double first_subjects_achieve5;

    @Column(name = "first_subjects_achieve_ex5")      //初试科目5   成绩说明
    private String first_subjects_achieve_ex5;

    @Column(name = "first_subjects_id6")      //初试科目6   id
    private int first_subjects_id6;

    @Column(name = "first_subjects_name6")      //初试科目6   名称
    private String first_subjects_name6;

    @Column(name = "first_subjects_achieve6")      //初试科目6   成绩
    private double first_subjects_achieve6;

    @Column(name = "first_subjects_achieve_ex6")      //初试科目6   成绩说明
    private String first_subjects_achieve_ex6;



    @Column(name = "complex_subjects_id1")      //复试科目1 id
    private int complex_subjects_id1;

    @Column(name = "complex_subjects_name1")      //名称
    private String complex_subjects_name1;

    @Column(name = "complex_subjects_achieve1")      //成绩
    private double complex_subjects_achieve1;

    @Column(name = "complex_subjects_achieve_ex1")      //成绩说明
    private String complex_subjects_achieve_ex1;

    @Column(name = "complex_subjects_id2")      //复试科目2 id
    private int complex_subjects_id2;

    @Column(name = "complex_subjects_name2")      //名称
    private String complex_subjects_name2;

    @Column(name = "complex_subjects_achieve2")      //成绩
    private double complex_subjects_achieve2;

    @Column(name = "complex_subjects_achieve_ex2")      //成绩说明
    private String complex_subjects_achieve_ex2;

    @Column(name = "complex_subjects_id3")      //复试科目3 id
    private int complex_subjects_id3;

    @Column(name = "complex_subjects_name3")      //名称
    private String complex_subjects_name3;

    @Column(name = "complex_subjects_achieve3")      //成绩
    private double complex_subjects_achieve3;

    @Column(name = "complex_subjects_achieve_ex3")      //成绩说明
    private String complex_subjects_achieve_ex3;

    @Column(name = "complex_subjects_id4")      //复试科目4 id
    private int complex_subjects_id4;

    @Column(name = "complex_subjects_name4")      //名称
    private String complex_subjects_name4;

    @Column(name = "complex_subjects_achieve4")      //成绩
    private double complex_subjects_achieve4;

    @Column(name = "complex_subjects_achieve_ex4")      //成绩说明
    private String complex_subjects_achieve_ex4;

    @Column(name = "complex_subjects_id5")      //复试科目5 id
    private int complex_subjects_id5;

    @Column(name = "complex_subjects_name5")      //名称
    private String complex_subjects_name5;

    @Column(name = "complex_subjects_achieve5")      //成绩
    private double complex_subjects_achieve5;

    @Column(name = "complex_subjects_achieve_ex5")      //成绩说明
    private String complex_subjects_achieve_ex5;

    @Column(name = "complex_subjects_id6")      //复试科目6 id
    private int complex_subjects_id6;

    @Column(name = "complex_subjects_name6")      //名称
    private String complex_subjects_name6;

    @Column(name = "complex_subjects_achieve6")      //成绩
    private double complex_subjects_achieve6;

    @Column(name = "complex_subjects_achieve_ex6")      //成绩说明
    private String complex_subjects_achieve_ex6;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHigh_province() {
        return high_province;
    }

    public void setHigh_province(String high_province) {
        this.high_province = high_province;
    }

    public String getExaminee_num() {
        return examinee_num;
    }

    public void setExaminee_num(String examinee_num) {
        this.examinee_num = examinee_num;
    }

    public String getTicket_num() {
        return ticket_num;
    }

    public void setTicket_num(String ticket_num) {
        this.ticket_num = ticket_num;
    }

    public String getWl_subject() {
        return wl_subject;
    }

    public void setWl_subject(String wl_subject) {
        this.wl_subject = wl_subject;
    }

    public String getProfessional_code() {
        return professional_code;
    }

    public void setProfessional_code(String professional_code) {
        this.professional_code = professional_code;
    }

    public String getProfessional_name() {
        return professional_name;
    }

    public void setProfessional_name(String professional_name) {
        this.professional_name = professional_name;
    }

    public int getNational_rankings() {
        return national_rankings;
    }

    public void setNational_rankings(int national_rankings) {
        this.national_rankings = national_rankings;
    }

    public String getNational_same_name() {
        return national_same_name;
    }

    public void setNational_same_name(String national_same_name) {
        this.national_same_name = national_same_name;
    }

    public int getProvincial_ranking() {
        return provincial_ranking;
    }

    public void setProvincial_ranking(int provincial_ranking) {
        this.provincial_ranking = provincial_ranking;
    }

    public String getProvincial_same_name() {
        return provincial_same_name;
    }

    public void setProvincial_same_name(String provincial_same_name) {
        this.provincial_same_name = provincial_same_name;
    }

    public String getQualified_mark() {
        return qualified_mark;
    }

    public void setQualified_mark(String qualified_mark) {
        this.qualified_mark = qualified_mark;
    }

    public String getQualified_line() {
        return qualified_line;
    }

    public void setQualified_line(String qualified_line) {
        this.qualified_line = qualified_line;
    }

    public double getFirst_subjects_total() {
        return first_subjects_total;
    }

    public void setFirst_subjects_total(double first_subjects_total) {
        this.first_subjects_total = first_subjects_total;
    }

    public double getComplex_subjects_total() {
        return complex_subjects_total;
    }

    public void setComplex_subjects_total(double complex_subjects_total) {
        this.complex_subjects_total = complex_subjects_total;
    }

    public double getTotal_score() {
        return total_score;
    }

    public void setTotal_score(double total_score) {
        this.total_score = total_score;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getFirst_subjects_id1() {
        return first_subjects_id1;
    }

    public void setFirst_subjects_id1(int first_subjects_id1) {
        this.first_subjects_id1 = first_subjects_id1;
    }

    public String getFirst_subjects_name1() {
        return first_subjects_name1;
    }

    public void setFirst_subjects_name1(String first_subjects_name1) {
        this.first_subjects_name1 = first_subjects_name1;
    }

    public double getFirst_subjects_achieve1() {
        return first_subjects_achieve1;
    }

    public void setFirst_subjects_achieve1(double first_subjects_achieve1) {
        this.first_subjects_achieve1 = first_subjects_achieve1;
    }

    public String getFirst_subjects_achieve_ex1() {
        return first_subjects_achieve_ex1;
    }

    public void setFirst_subjects_achieve_ex1(String first_subjects_achieve_ex1) {
        this.first_subjects_achieve_ex1 = first_subjects_achieve_ex1;
    }

    public int getFirst_subjects_id2() {
        return first_subjects_id2;
    }

    public void setFirst_subjects_id2(int first_subjects_id2) {
        this.first_subjects_id2 = first_subjects_id2;
    }

    public String getFirst_subjects_name2() {
        return first_subjects_name2;
    }

    public void setFirst_subjects_name2(String first_subjects_name2) {
        this.first_subjects_name2 = first_subjects_name2;
    }

    public double getFirst_subjects_achieve2() {
        return first_subjects_achieve2;
    }

    public void setFirst_subjects_achieve2(double first_subjects_achieve2) {
        this.first_subjects_achieve2 = first_subjects_achieve2;
    }

    public String getFirst_subjects_achieve_ex2() {
        return first_subjects_achieve_ex2;
    }

    public void setFirst_subjects_achieve_ex2(String first_subjects_achieve_ex2) {
        this.first_subjects_achieve_ex2 = first_subjects_achieve_ex2;
    }

    public int getFirst_subjects_id3() {
        return first_subjects_id3;
    }

    public void setFirst_subjects_id3(int first_subjects_id3) {
        this.first_subjects_id3 = first_subjects_id3;
    }

    public String getFirst_subjects_name3() {
        return first_subjects_name3;
    }

    public void setFirst_subjects_name3(String first_subjects_name3) {
        this.first_subjects_name3 = first_subjects_name3;
    }

    public double getFirst_subjects_achieve3() {
        return first_subjects_achieve3;
    }

    public void setFirst_subjects_achieve3(double first_subjects_achieve3) {
        this.first_subjects_achieve3 = first_subjects_achieve3;
    }

    public String getFirst_subjects_achieve_ex3() {
        return first_subjects_achieve_ex3;
    }

    public void setFirst_subjects_achieve_ex3(String first_subjects_achieve_ex3) {
        this.first_subjects_achieve_ex3 = first_subjects_achieve_ex3;
    }

    public int getFirst_subjects_id4() {
        return first_subjects_id4;
    }

    public void setFirst_subjects_id4(int first_subjects_id4) {
        this.first_subjects_id4 = first_subjects_id4;
    }

    public String getFirst_subjects_name4() {
        return first_subjects_name4;
    }

    public void setFirst_subjects_name4(String first_subjects_name4) {
        this.first_subjects_name4 = first_subjects_name4;
    }

    public double getFirst_subjects_achieve4() {
        return first_subjects_achieve4;
    }

    public void setFirst_subjects_achieve4(double first_subjects_achieve4) {
        this.first_subjects_achieve4 = first_subjects_achieve4;
    }

    public String getFirst_subjects_achieve_ex4() {
        return first_subjects_achieve_ex4;
    }

    public void setFirst_subjects_achieve_ex4(String first_subjects_achieve_ex4) {
        this.first_subjects_achieve_ex4 = first_subjects_achieve_ex4;
    }

    public int getFirst_subjects_id5() {
        return first_subjects_id5;
    }

    public void setFirst_subjects_id5(int first_subjects_id5) {
        this.first_subjects_id5 = first_subjects_id5;
    }

    public String getFirst_subjects_name5() {
        return first_subjects_name5;
    }

    public void setFirst_subjects_name5(String first_subjects_name5) {
        this.first_subjects_name5 = first_subjects_name5;
    }

    public double getFirst_subjects_achieve5() {
        return first_subjects_achieve5;
    }

    public void setFirst_subjects_achieve5(double first_subjects_achieve5) {
        this.first_subjects_achieve5 = first_subjects_achieve5;
    }

    public String getFirst_subjects_achieve_ex5() {
        return first_subjects_achieve_ex5;
    }

    public void setFirst_subjects_achieve_ex5(String first_subjects_achieve_ex5) {
        this.first_subjects_achieve_ex5 = first_subjects_achieve_ex5;
    }

    public int getFirst_subjects_id6() {
        return first_subjects_id6;
    }

    public void setFirst_subjects_id6(int first_subjects_id6) {
        this.first_subjects_id6 = first_subjects_id6;
    }

    public String getFirst_subjects_name6() {
        return first_subjects_name6;
    }

    public void setFirst_subjects_name6(String first_subjects_name6) {
        this.first_subjects_name6 = first_subjects_name6;
    }

    public double getFirst_subjects_achieve6() {
        return first_subjects_achieve6;
    }

    public void setFirst_subjects_achieve6(double first_subjects_achieve6) {
        this.first_subjects_achieve6 = first_subjects_achieve6;
    }

    public String getFirst_subjects_achieve_ex6() {
        return first_subjects_achieve_ex6;
    }

    public void setFirst_subjects_achieve_ex6(String first_subjects_achieve_ex6) {
        this.first_subjects_achieve_ex6 = first_subjects_achieve_ex6;
    }

    public int getComplex_subjects_id1() {
        return complex_subjects_id1;
    }

    public void setComplex_subjects_id1(int complex_subjects_id1) {
        this.complex_subjects_id1 = complex_subjects_id1;
    }

    public String getComplex_subjects_name1() {
        return complex_subjects_name1;
    }

    public void setComplex_subjects_name1(String complex_subjects_name1) {
        this.complex_subjects_name1 = complex_subjects_name1;
    }

    public double getComplex_subjects_achieve1() {
        return complex_subjects_achieve1;
    }

    public void setComplex_subjects_achieve1(double complex_subjects_achieve1) {
        this.complex_subjects_achieve1 = complex_subjects_achieve1;
    }

    public String getComplex_subjects_achieve_ex1() {
        return complex_subjects_achieve_ex1;
    }

    public void setComplex_subjects_achieve_ex1(String complex_subjects_achieve_ex1) {
        this.complex_subjects_achieve_ex1 = complex_subjects_achieve_ex1;
    }

    public int getComplex_subjects_id2() {
        return complex_subjects_id2;
    }

    public void setComplex_subjects_id2(int complex_subjects_id2) {
        this.complex_subjects_id2 = complex_subjects_id2;
    }

    public String getComplex_subjects_name2() {
        return complex_subjects_name2;
    }

    public void setComplex_subjects_name2(String complex_subjects_name2) {
        this.complex_subjects_name2 = complex_subjects_name2;
    }

    public double getComplex_subjects_achieve2() {
        return complex_subjects_achieve2;
    }

    public void setComplex_subjects_achieve2(double complex_subjects_achieve2) {
        this.complex_subjects_achieve2 = complex_subjects_achieve2;
    }

    public String getComplex_subjects_achieve_ex2() {
        return complex_subjects_achieve_ex2;
    }

    public void setComplex_subjects_achieve_ex2(String complex_subjects_achieve_ex2) {
        this.complex_subjects_achieve_ex2 = complex_subjects_achieve_ex2;
    }

    public int getComplex_subjects_id3() {
        return complex_subjects_id3;
    }

    public void setComplex_subjects_id3(int complex_subjects_id3) {
        this.complex_subjects_id3 = complex_subjects_id3;
    }

    public String getComplex_subjects_name3() {
        return complex_subjects_name3;
    }

    public void setComplex_subjects_name3(String complex_subjects_name3) {
        this.complex_subjects_name3 = complex_subjects_name3;
    }

    public double getComplex_subjects_achieve3() {
        return complex_subjects_achieve3;
    }

    public void setComplex_subjects_achieve3(double complex_subjects_achieve3) {
        this.complex_subjects_achieve3 = complex_subjects_achieve3;
    }

    public String getComplex_subjects_achieve_ex3() {
        return complex_subjects_achieve_ex3;
    }

    public void setComplex_subjects_achieve_ex3(String complex_subjects_achieve_ex3) {
        this.complex_subjects_achieve_ex3 = complex_subjects_achieve_ex3;
    }

    public int getComplex_subjects_id4() {
        return complex_subjects_id4;
    }

    public void setComplex_subjects_id4(int complex_subjects_id4) {
        this.complex_subjects_id4 = complex_subjects_id4;
    }

    public String getComplex_subjects_name4() {
        return complex_subjects_name4;
    }

    public void setComplex_subjects_name4(String complex_subjects_name4) {
        this.complex_subjects_name4 = complex_subjects_name4;
    }

    public double getComplex_subjects_achieve4() {
        return complex_subjects_achieve4;
    }

    public void setComplex_subjects_achieve4(double complex_subjects_achieve4) {
        this.complex_subjects_achieve4 = complex_subjects_achieve4;
    }

    public String getComplex_subjects_achieve_ex4() {
        return complex_subjects_achieve_ex4;
    }

    public void setComplex_subjects_achieve_ex4(String complex_subjects_achieve_ex4) {
        this.complex_subjects_achieve_ex4 = complex_subjects_achieve_ex4;
    }

    public int getComplex_subjects_id5() {
        return complex_subjects_id5;
    }

    public void setComplex_subjects_id5(int complex_subjects_id5) {
        this.complex_subjects_id5 = complex_subjects_id5;
    }

    public String getComplex_subjects_name5() {
        return complex_subjects_name5;
    }

    public void setComplex_subjects_name5(String complex_subjects_name5) {
        this.complex_subjects_name5 = complex_subjects_name5;
    }

    public double getComplex_subjects_achieve5() {
        return complex_subjects_achieve5;
    }

    public void setComplex_subjects_achieve5(double complex_subjects_achieve5) {
        this.complex_subjects_achieve5 = complex_subjects_achieve5;
    }

    public String getComplex_subjects_achieve_ex5() {
        return complex_subjects_achieve_ex5;
    }

    public void setComplex_subjects_achieve_ex5(String complex_subjects_achieve_ex5) {
        this.complex_subjects_achieve_ex5 = complex_subjects_achieve_ex5;
    }

    public int getComplex_subjects_id6() {
        return complex_subjects_id6;
    }

    public void setComplex_subjects_id6(int complex_subjects_id6) {
        this.complex_subjects_id6 = complex_subjects_id6;
    }

    public String getComplex_subjects_name6() {
        return complex_subjects_name6;
    }

    public void setComplex_subjects_name6(String complex_subjects_name6) {
        this.complex_subjects_name6 = complex_subjects_name6;
    }

    public double getComplex_subjects_achieve6() {
        return complex_subjects_achieve6;
    }

    public void setComplex_subjects_achieve6(double complex_subjects_achieve6) {
        this.complex_subjects_achieve6 = complex_subjects_achieve6;
    }

    public String getComplex_subjects_achieve_ex6() {
        return complex_subjects_achieve_ex6;
    }

    public void setComplex_subjects_achieve_ex6(String complex_subjects_achieve_ex6) {
        this.complex_subjects_achieve_ex6 = complex_subjects_achieve_ex6;
    }
}
