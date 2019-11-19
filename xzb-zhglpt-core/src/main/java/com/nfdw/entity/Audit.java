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

    @Column(name = "u_id")
    private int u_id;

    @Column(name = "name")
    private String name;
    @Column(name = "biog_land")
    private String biog_land;
    @Column(name = "exam_id")
    private int exam_id;
    @Column(name = "exam_name")
    private String exam_name;
    @Column(name = "major_id")
    private int major_id;
    @Column(name = "major")
    private String major;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "sub_time")
    private Date sub_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "end_time")
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
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
}
