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
 * @Description: 接收第三方接口的学院
 */
@ToString
@Data
@Table(name = "spec_collectEntity")
public class SpecCollectEntity {

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;

    //(是否有效名称, 示例值：有效)
    @Column(name = "D_STATIC_ORG_VALID_NAME")
    private String D_STATIC_ORG_VALID_NAME;

    //(父机构代码, 示例值：08)
    @Column(name = "D_STATIC_PARENT_ORG_CODE")
    private String D_STATIC_PARENT_ORG_CODE;

    //(机构代码, 示例值：0803)
    @Column(name = "D_STATIC_ORG_CODE")
    private String D_STATIC_ORG_CODE;

    //(是否有效代码, 示例值：1)
    @Column(name = "D_STATIC_ORG_IS_VALID")
    private String D_STATIC_ORG_IS_VALID;

    //(机构名称, 示例值：广州大学纺织服装学院)
    @Column(name = "D_STATIC_ORG_NAME")
    private String D_STATIC_ORG_NAME;

    //(父机构名称, 示例值：二级学院)
    @Column(name = "D_STATIC_PARENT_ORG_NAME")
    private String D_STATIC_PARENT_ORG_NAME;
}
