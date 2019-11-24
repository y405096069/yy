package com.nfdw.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "achievement_summary")
@Data
public class SignIn {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;//序号
    private String name;//姓名
    private String examineeName;//考试名称
    private String applyingMajor;//报考专业
    private String exam;//准考证
    private String no;//考生号
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String singInCondition;//签到情况










}
