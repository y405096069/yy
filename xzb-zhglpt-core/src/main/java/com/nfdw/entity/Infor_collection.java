package com.nfdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "infor_collection")
@Data
public class Infor_collection {         //信息采集模板表

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private int id;

    @Column(name = "template_name")
    private String template_name;       //模板name

    @Column(name = "template_status")
    private String template_status;     //模板状态

    @Column(name = "founder")
    private String founder;                //创建人

    @Column(name = "founder_name")
    private String founder_name;        //创建人名

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date create_time;            //创建时间

    @Column(name = "exam_id")
    private int exam_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }

    public String getTemplate_status() {
        return template_status;
    }

    public void setTemplate_status(String template_status) {
        this.template_status = template_status;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getFounder_name() {
        return founder_name;
    }

    public void setFounder_name(String founder_name) {
        this.founder_name = founder_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }
}
