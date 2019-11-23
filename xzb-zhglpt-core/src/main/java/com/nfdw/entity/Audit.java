package com.nfdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_audit")
@Data
public class Audit {                //审核汇总表

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;

    @Column(name = "u_id")      //用户id
    private String u_id;

    @Column(name = "name")      //姓名
    private String name;
    @Column(name = "biog_land")  //生源地
    private String biog_land;
    @Column(name = "exam_id")
    private int exam_id;
    @Column(name = "exam_name")     //考试名称
    private String exam_name;
    @Column(name = "major_id")
    private int major_id;
    @Column(name = "major")     //专业名称
    private String major;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "sub_time")
    private Date sub_time;          //信息提交时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "end_time")          //报名截止时间
    private Date end_time;

    @Column(name = "audit_status")
    private String audit_status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "audit_time")
    private Date audit_time;

    @Column(name = "enroll_status")
    private String enroll_status;
    @Column(name = "audit_reason")
    private String audit_reason;
    @Column(name = "pay_status")
    private String pay_status;
    @Column(name = "audit_link")
    private String audit_link;

    @Column(name = "info_collect_status")      //信息采集状态
    private String info_collect_status;
    @Column(name = "re_pay_status")             //复试缴费状态
    private String re_pay_status;
    @Column(name = "re_enroll_status")          //复试报名状态
    private String re_enroll_status;
    @Column(name = "re_audit_status")           //复试审核状态
    private String re_audit_status;
    @Column(name = "re_audit_time")              //复试审核时间
    private String re_audit_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiog_land() {
        return biog_land;
    }

    public void setBiog_land(String biog_land) {
        this.biog_land = biog_land;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getSub_time() {
        return sub_time;
    }

    public void setSub_time(Date sub_time) {
        this.sub_time = sub_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status;
    }

    public Date getAudit_time() {
        return audit_time;
    }

    public void setAudit_time(Date audit_time) {
        this.audit_time = audit_time;
    }

    public String getEnroll_status() {
        return enroll_status;
    }

    public void setEnroll_status(String enroll_status) {
        this.enroll_status = enroll_status;
    }

    public String getAudit_reason() {
        return audit_reason;
    }

    public void setAudit_reason(String audit_reason) {
        this.audit_reason = audit_reason;
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }

    public String getAudit_link() {
        return audit_link;
    }

    public void setAudit_link(String audit_link) {
        this.audit_link = audit_link;
    }

    public String getInfo_collect_status() {
        return info_collect_status;
    }

    public void setInfo_collect_status(String info_collect_status) {
        this.info_collect_status = info_collect_status;
    }

    public String getRe_pay_status() {
        return re_pay_status;
    }

    public void setRe_pay_status(String re_pay_status) {
        this.re_pay_status = re_pay_status;
    }

    public String getRe_enroll_status() {
        return re_enroll_status;
    }

    public void setRe_enroll_status(String re_enroll_status) {
        this.re_enroll_status = re_enroll_status;
    }

    public String getRe_audit_status() {
        return re_audit_status;
    }

    public void setRe_audit_status(String re_audit_status) {
        this.re_audit_status = re_audit_status;
    }

    public String getRe_audit_time() {
        return re_audit_time;
    }

    public void setRe_audit_time(String re_audit_time) {
        this.re_audit_time = re_audit_time;
    }

}
