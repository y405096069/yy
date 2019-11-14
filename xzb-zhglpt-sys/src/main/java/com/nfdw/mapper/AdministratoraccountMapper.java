package com.nfdw.mapper;/**
 * @author caisheng
 * @create 2019-11-13 20:31
 */

import com.nfdw.entity.Examinationstatistics;
import com.nfdw.pojo.Examination;

import java.util.List;

/**
 * 考试情况统计
 * @author
 * @create 2019-11-13 20:31
 */
public interface AdministratoraccountMapper {

    public List<Examinationstatistics> Examinationstatistics(Examination examination);

    public List<Examinationstatistics> Examinationstatisticsimpl();


}
