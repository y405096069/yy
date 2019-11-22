package com.nfdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/12
 * @Description: 考试管理
 */

@Table(name = "crea_exam")
@Data
public class Examination {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "exam")
    private String exam;//考试名称

    @Column(name = "number_limitation")
    private String number_limitation;//报考人数限制

    @Column(name = "specialty_id")
    private String specialty_id;//兼职专业id

    @Column(name = "specialty_name")
    private String specialty_name;//专业名称

    @Column(name = "province_id")
    private String province_id;//生源地限制 省ID 多个用逗号隔开 <list>

    @Column(name = "gathering_id")
    private String gathering_id;//信息采集模板

    @Column(name = "crade")
    private Integer crade;//入围分数

    @Column(name = "subject_stint")
    private String subject_stint;//科目限制

    /*@Column(name = "first_test")
    private String first_test;//初试分占比

    @Column(name = "total_score")
    private String total_score;//每个科目的总分*/

    @Column(name = "certificate")
    private Integer certificate;//合格证  0- 未开启 1- 开启

    @Column(name = "grade")
    private Integer grade; //成绩查询状态  0 - 关闭  1- 开启

    @Column(name = "grade2")
    private Integer grade2; //复试成绩查询状态  0 - 关闭  1- 开启

    @Column(name = "status")
    private Integer status;//考试状态  0 - 暂存  1- 开启

    @Column(name = "prologue")
    private String prologue;//准考证前序

    @Column(name = "prologue_tem")
    private String prologue_tem;//准考证模板

    @Column(name = "prologue_remarks")
    private String prologue_remarks;//准考证备注

    @Column(name = "version1")
    private String version1;//招生简章

    @Column(name = "prcie")
    private Double prcie;//报名费

    @Column(name = "retestPrcie")
    private Double retestPrcie;//复试报名费

    @Column(name = "retest_type")
    private int retest_type; //复试报名费 0：开 1：关


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date create_time;//创建时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date update_time;//更新时间


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "exam_time")
    private Date exam_time;//报名开始时间


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "end_time")
    private Date end_time;//报名结束时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_start_time")
    private Date create_start_time;//初试考试开始时间 list

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_end_time")
    private Date create_end_time; //初试考试结束时间  list

    @Column(name = "people_num")
    private String people_num;         //考场人数限制      list

    @Column(name = "build")
    private String build;           //考试楼栋          list


    @Column(name = "create_enclosure")
    private String create_enclosure;//附件地址,根据分隔符区分

    @Column(name = "create_disclaimer")
    private String create_disclaimer;//免责声明

    @Column(name = "create_watermark")
    private String create_watermark;//水印

    @Column(name = "remarks")
    private String remarks;//备注

    @Column(name = "types")
    private Integer types;//模板配置  0 - 未配置  1- 已配置

    @Column(name = "current1")
    private Integer current1;//0- 未设定入围分数线  1- 已设定入围分数线

    @Column(name = "college_id")
    private Integer college_id;//学院ID


/*@Column(name = "crade_id")
    private Integer crade_id;//成绩ID

    @Column(name = "total_ratio")
    private String total_ratio;//分比值*/

    @Column(name = "report_setting")
    private String report_setting;//兼报设置 0是 1否

    @Column(name = "huchi")
    private Integer huchi;//互斥设置 0是 1否


    @Column(name = "subject_id")
    private String subject_id;//初试科目ID 多个   list

    @Column(name = "father_id")
    private String father_id;//复试科目ID多个     list


    @Column(name = "check_pay")
    private Integer check_pay;//审核费用 0:交费钱 1：交费后






    //初试科目权重分值
    @Column(name = "subject_q_fen")
    private Integer subject_q_fen;

    //复试科目权重分值
    @Column(name = "father_q_fen")
    private Integer father_q_fen;

    //科目权重占比（初试）（子） list
    @Column(name = "subject_q_fen_child")
    private String subject_q_fen_child;

    //科目权重占比（复试）（子） list
    @Column(name = "father_q_fen_child")
    private String father_q_fen_child;

    //初试科目对应的总分(单个科目满分) list
    @Column(name = "subject_k_d_zong")
    private String subject_k_d_zong;

    //复试科目对应的总分(单个科目满分) list
    @Column(name = "father_k_d_zong")
    private String father_k_d_zong;


    public Integer getId() {
        return id;
    }





    public void setId(Integer id) {
        this.id = id;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getNumber_limitation() {
        return number_limitation;
    }

    public void setNumber_limitation(String number_limitation) {
        this.number_limitation = number_limitation;
    }

    public String getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(String specialty_id) {
        this.specialty_id = specialty_id;
    }

    public String getSpecialty_name() {
        return specialty_name;
    }

    public void setSpecialty_name(String specialty_name) {
        this.specialty_name = specialty_name;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getGathering_id() {
        return gathering_id;
    }

    public void setGathering_id(String gathering_id) {
        this.gathering_id = gathering_id;
    }

    public Integer getCrade() {
        return crade;
    }

    public void setCrade(Integer crade) {
        this.crade = crade;
    }

    public String getSubject_stint() {
        return subject_stint;
    }

    public void setSubject_stint(String subject_stint) {
        this.subject_stint = subject_stint;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade2() {
        return grade2;
    }

    public void setGrade2(Integer grade2) {
        this.grade2 = grade2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrologue() {
        return prologue;
    }

    public void setPrologue(String prologue) {
        this.prologue = prologue;
    }

    public String getPrologue_tem() {
        return prologue_tem;
    }

    public void setPrologue_tem(String prologue_tem) {
        this.prologue_tem = prologue_tem;
    }

    public String getPrologue_remarks() {
        return prologue_remarks;
    }

    public void setPrologue_remarks(String prologue_remarks) {
        this.prologue_remarks = prologue_remarks;
    }

    public String getVersion1() {
        return version1;
    }

    public void setVersion1(String version1) {
        this.version1 = version1;
    }

    public Double getPrcie() {
        return prcie;
    }

    public void setPrcie(Double prcie) {
        this.prcie = prcie;
    }

    public Double getRetestPrcie() {
        return retestPrcie;
    }

    public void setRetestPrcie(Double retestPrcie) {
        this.retestPrcie = retestPrcie;
    }

    public int getRetest_type() {
        return retest_type;
    }

    public void setRetest_type(int retest_type) {
        this.retest_type = retest_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getExam_time() {
        return exam_time;
    }

    public void setExam_time(Date exam_time) {
        this.exam_time = exam_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getCreate_start_time() {
        return create_start_time;
    }

    public void setCreate_start_time(Date create_start_time) {
        this.create_start_time = create_start_time;
    }

    public Date getCreate_end_time() {
        return create_end_time;
    }

    public void setCreate_end_time(Date create_end_time) {
        this.create_end_time = create_end_time;
    }

    public String getPeople_num() {
        return people_num;
    }

    public void setPeople_num(String people_num) {
        this.people_num = people_num;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getCreate_enclosure() {
        return create_enclosure;
    }

    public void setCreate_enclosure(String create_enclosure) {
        this.create_enclosure = create_enclosure;
    }

    public String getCreate_disclaimer() {
        return create_disclaimer;
    }

    public void setCreate_disclaimer(String create_disclaimer) {
        this.create_disclaimer = create_disclaimer;
    }

    public String getCreate_watermark() {
        return create_watermark;
    }

    public void setCreate_watermark(String create_watermark) {
        this.create_watermark = create_watermark;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getCurrent1() {
        return current1;
    }

    public void setCurrent1(Integer current1) {
        this.current1 = current1;
    }

    public Integer getCollege_id() {
        return college_id;
    }

    public void setCollege_id(Integer college_id) {
        this.college_id = college_id;
    }

    public String getReport_setting() {
        return report_setting;
    }

    public void setReport_setting(String report_setting) {
        this.report_setting = report_setting;
    }

    public Integer getHuchi() {
        return huchi;
    }

    public void setHuchi(Integer huchi) {
        this.huchi = huchi;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getFather_id() {
        return father_id;
    }

    public void setFather_id(String father_id) {
        this.father_id = father_id;
    }

    public Integer getCheck_pay() {
        return check_pay;
    }

    public void setCheck_pay(Integer check_pay) {
        this.check_pay = check_pay;
    }

    public Integer getSubject_q_fen() {
        return subject_q_fen;
    }

    public void setSubject_q_fen(Integer subject_q_fen) {
        this.subject_q_fen = subject_q_fen;
    }

    public Integer getFather_q_fen() {
        return father_q_fen;
    }

    public void setFather_q_fen(Integer father_q_fen) {
        this.father_q_fen = father_q_fen;
    }

    public String getSubject_q_fen_child() {
        return subject_q_fen_child;
    }

    public void setSubject_q_fen_child(String subject_q_fen_child) {
        this.subject_q_fen_child = subject_q_fen_child;
    }

    public String getFather_q_fen_child() {
        return father_q_fen_child;
    }

    public void setFather_q_fen_child(String father_q_fen_child) {
        this.father_q_fen_child = father_q_fen_child;
    }

    public String getSubject_k_d_zong() {
        return subject_k_d_zong;
    }

    public void setSubject_k_d_zong(String subject_k_d_zong) {
        this.subject_k_d_zong = subject_k_d_zong;
    }

    public String getFather_k_d_zong() {
        return father_k_d_zong;
    }

    public void setFather_k_d_zong(String father_k_d_zong) {
        this.father_k_d_zong = father_k_d_zong;
    }
}
