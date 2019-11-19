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
    private int code;


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
    private String collect_id;

}
