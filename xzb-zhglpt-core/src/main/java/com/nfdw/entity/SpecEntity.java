package com.nfdw.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description: 接收第三方接口的专业名称的实体类
 */
@Data
@ToString
@Table(name = "spec_entity")
public class SpecEntity {

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;

    //专业号
    @Column(name = "ZYH")
    private String ZYH;

    //(是否停用（1是 0否）, 示例值：1)
    @Column(name = "SFTY")
    private String SFTY;

    //修改时间
    @Column(name = "XGSJ")
    private String XGSJ;

    //专业名称
    @Column(name = "ZYMC")
    private String ZYMC;
}
