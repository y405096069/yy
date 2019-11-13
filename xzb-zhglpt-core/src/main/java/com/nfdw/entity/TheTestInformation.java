package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-13 14:34
 */

/**
 * @author caisheng
 * @create 2019-11-13 14:34
 */
public class TheTestInformation {
    private String testname;
    private String zhuaye;
    private String kemu;
    private String xingxishenghe;
    private String jiaofeiqingkuang;
    private String baomingzhuangtai;
    private String chushiqiandao;


    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getZhuaye() {
        return zhuaye;
    }

    public void setZhuaye(String zhuaye) {
        this.zhuaye = zhuaye;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getXingxishenghe() {
        return xingxishenghe;
    }

    public void setXingxishenghe(String xingxishenghe) {
        this.xingxishenghe = xingxishenghe;
    }

    public String getJiaofeiqingkuang() {
        return jiaofeiqingkuang;
    }

    public void setJiaofeiqingkuang(String jiaofeiqingkuang) {
        this.jiaofeiqingkuang = jiaofeiqingkuang;
    }

    public String getBaomingzhuangtai() {
        return baomingzhuangtai;
    }

    public void setBaomingzhuangtai(String baomingzhuangtai) {
        this.baomingzhuangtai = baomingzhuangtai;
    }

    public String getChushiqiandao() {
        return chushiqiandao;
    }

    public void setChushiqiandao(String chushiqiandao) {
        this.chushiqiandao = chushiqiandao;
    }

    @Override
    public String toString() {
        return "TheTestInformation{" +
                "testname='" + testname + '\'' +
                ", zhuaye='" + zhuaye + '\'' +
                ", kemu='" + kemu + '\'' +
                ", xingxishenghe='" + xingxishenghe + '\'' +
                ", jiaofeiqingkuang='" + jiaofeiqingkuang + '\'' +
                ", baomingzhuangtai='" + baomingzhuangtai + '\'' +
                ", chushiqiandao='" + chushiqiandao + '\'' +
                '}';
    }
}
