package com.nfdw.service;/**
 * @author caisheng
 * @create 2019-11-13 21:48
 */

import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Examinationstatistics;
import com.nfdw.pojo.Examination;

import java.util.List;

/**
 * 考试情况统计
 * @author
 * @create 2019-11-13 21:48
 */
public interface AdministratoraccountService {
    public PageInfo<Examinationstatistics> Examinationstatistics(Examination examination);

    public PageInfo<Examinationstatistics> Examinationstatisticsimpl(Integer page,Integer pageSize);


}
