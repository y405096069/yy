package com.nfdw.service;

import java.math.BigDecimal;

public interface CreaExamService {

    //查询报考人数
    public Integer countPeople();

    //查询初试报考费
    public BigDecimal firstFee();

    //查询复试报考费
    public BigDecimal reexamineFee();

}
