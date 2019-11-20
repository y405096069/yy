package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-20 16:01
 */

import javax.persistence.Table;

/**
 * @author caisheng
 * @create 2019-11-20 16:01
 */

public class Zkzb {

    private String id;
    //报考专业
    private String  bkzy;
    //准考证号
    private String zkzh;
    //kssj考试开始时间
    private  String kssj;
    //结束时间
    private String jssj;
    //考场
    private String kc;
    //复试考试科目
    private String kskmf;
    //初试科目
    private String kskmc;
    //备注
    private String bz;
    //zymc专业名称
    private  String zymc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBkzy() {
        return bkzy;
    }

    public void setBkzy(String bkzy) {
        this.bkzy = bkzy;
    }

    public String getZkzh() {
        return zkzh;
    }

    public void setZkzh(String zkzh) {
        this.zkzh = zkzh;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    public String getKc() {
        return kc;
    }

    public void setKc(String kc) {
        this.kc = kc;
    }

    public String getKskmf() {
        return kskmf;
    }

    public void setKskmf(String kskmf) {
        this.kskmf = kskmf;
    }

    public String getKskmc() {
        return kskmc;
    }

    public void setKskmc(String kskmc) {
        this.kskmc = kskmc;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc;
    }
}
