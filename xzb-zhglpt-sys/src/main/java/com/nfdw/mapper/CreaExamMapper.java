package com.nfdw.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface CreaExamMapper {
    //查询报考人数
    public Integer countPeople();

    //查询初试报考费
    public BigDecimal firstFee();

    //查询复试报考费
    public BigDecimal reexamineFee();

}
