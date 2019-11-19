package com.nfdw.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 报名统计
 */
@Mapper
public interface RegistrationStatisticsMapper {

    public Integer NumberApplicants();//报名人数
    public Integer PendingReview();//待审核
    public Integer Audited();//已审核
    public Integer PendingPayment();//待缴费
    public Integer Paid();//已缴费
    public Integer SignUpSuccess();//报名成功人数





}
