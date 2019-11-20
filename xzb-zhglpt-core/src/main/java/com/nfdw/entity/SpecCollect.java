package com.nfdw.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "sys_department")
@Data
@ToString
@EqualsAndHashCode
public class SpecCollect {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String  code;
    @Column(name = "introduction")
    private String  introduction;
    @Column(name = " update_time;")
    private Date updateTime;;
    @Column(name = "add_name;")
    private String addName;;

}
