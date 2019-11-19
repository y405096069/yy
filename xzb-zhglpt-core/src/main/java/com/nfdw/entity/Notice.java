package com.nfdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/16
 * @Description: 消息通知表
 */
@Table(name = "crea_notice")
@Data
@ToString
public class Notice {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "user_name")
    private String user_name;//更新人

    @Column(name = "caption")
    private String caption;//通知标题

    @Column(name = "status")
    private int status;//通知状态类型

    @Column(name = "content")
    private String content;//通知内容

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date create_time;//创建时间

    @Column(name = "type")
    private String type;//类型
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date update_time;//更新时间

    @Column(name = "delFlag")
    private Integer delFlag; //0：删除 1：正常

}
