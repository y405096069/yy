package com.nfdw.pojo;/**
 * @author caisheng
 * @create 2019-11-13 16:38
 */

/**
 * @author caisheng
 * @create 2019-11-13 16:38
 */
public class Condition {
    public String testname;
    public String kelei;
    public String baokaozhuanye;
    public String shengyuandi;
    public Integer page;
    public Integer pageSize;

    @Override
    public String toString() {
        return "Condition{" +
                "testname='" + testname + '\'' +
                ", kelei='" + kelei + '\'' +
                ", baokaozhuanye='" + baokaozhuanye + '\'' +
                ", shengyuandi='" + shengyuandi + '\'' +
                '}';
    }


}
