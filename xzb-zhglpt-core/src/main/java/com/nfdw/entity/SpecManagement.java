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
 * @Date: 2019/11/18
 * @Description: 专业管理表
 */
@Table(name = "spec_management")
@Data
public class SpecManagement {

    //id
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;
    //名称

    @Column(name = "sub_limit")
    private int sub_limit;//0：文科 1：理科
    //科目限制

    //专业代码
    @Column(name = "code")
    private String code;


    @Column(name = "res_status")
    //复试状态
    private int res_status;


    @Column(name = "zs_content")
    //招生简章
    private String zs_content;

    @Column(name = "ticket_id")
    private String ticket_id;
    //专业准考证号前序

    //更新时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date update_time;

    //更新人
    @Column(name = "update_people")
    private String update_people;

    //学院id
    @Column(name = "collect_id")
    private int collect_id;

    //是否停用
    @Column(name = "sfty")
    private  int sfty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSub_limit() {
        return sub_limit;
    }

    public void setSub_limit(int sub_limit) {
        this.sub_limit = sub_limit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRes_status() {
        return res_status;
    }

    public void setRes_status(int res_status) {
        this.res_status = res_status;
    }

    public String getZs_content() {
        return zs_content;
    }

    public void setZs_content(String zs_content) {
        this.zs_content = zs_content;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_people() {
        return update_people;
    }

    public void setUpdate_people(String update_people) {
        this.update_people = update_people;
    }

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
    }

    public int getSfty() {
        return sfty;
    }

    public void setSfty(int sfty) {
        this.sfty = sfty;
    }
}
