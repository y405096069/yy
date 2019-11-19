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
    private String specialty_id;//专业id

    @Column(name = "specialty_name")
    private String specialty_name;//专业名称

    @Column(name = "province_id")
    private String province_id;//生源地限制 省ID 多个用逗号隔开 <list>

    @Column(name = "gathering_id")
    private Integer gathering_id;//信息采集模板

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

    @Column(name = "create_start_time")
    private String create_start_time;//初试考试开始时间 list

    @Column(name = "create_end_time")
    private String create_end_time; //初试考试结束时间  list

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
    private Integer report_setting;//兼报设置 0是 1否

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






}
