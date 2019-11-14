package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-13 20:46
 */

import java.util.Date;

/**
 * @author caisheng
 * @create 2019-11-13 20:46
 */
public class Examinationstatistics {
     private String name;
    private String biog_land;
    private String major;
    private String audit_status;
    private String enroll_status;
    private String audit_reason;
    private String pay_status;
    private String audit_link;
    private int id;
    private int u_id;
    private int major_id;
    private int exam_id;
    private String exam_name;
    private Date sub_time;
    private Date end_time;
    private Date audit_time;


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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
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

    public Date getAudit_time() {
        return audit_time;
    }

    public void setAudit_time(Date audit_time) {
        this.audit_time = audit_time;
    }

    @Override
    public String toString() {
        return "Examinationstatistics{" +
                "name='" + name + '\'' +
                ", biog_land='" + biog_land + '\'' +
                ", major='" + major + '\'' +
                ", audit_status='" + audit_status + '\'' +
                ", enroll_status='" + enroll_status + '\'' +
                ", audit_reason='" + audit_reason + '\'' +
                ", pay_status='" + pay_status + '\'' +
                ", audit_link='" + audit_link + '\'' +
                ", id=" + id +
                ", u_id=" + u_id +
                ", major_id=" + major_id +
                ", exam_id=" + exam_id +
                ", exam_name=" + exam_name +
                ", sub_time=" + sub_time +
                ", end_time=" + end_time +
                ", audit_time=" + audit_time +
                '}';
    }
}
