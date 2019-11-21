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
 * @Date: 2019/11/19
 * @Description: 科目表
 */
@Table(name = "subject")
@Data
public class Subject {

    //id
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private int id;

    //科目
    @Column(name = "subject_name")
    private String subject_name;

    //科目代码
    @Column(name = "code")
    private String code;

    //科目介绍
    @Column(name = "introduction")
    private String introduction;

    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date update_time;

    //更新人
    @Column(name = "update_name")
    private String update_name;

    //专业id
    @Column(name = "spec_id")
    private Integer spec_id;

    //专业名称
    @Column(name = "spec_name")
    private String spec_name;

}
