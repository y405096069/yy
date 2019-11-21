package com.nfdw.mapper;/**
 * @author caisheng
 * @create 2019-11-20 15:57
 */

import com.nfdw.entity.Examination;
import com.nfdw.entity.Zkzb;

import java.util.List;

/**
 *准考证
 * @author
 * @create 2019-11-20 15:57
 */
public interface AccurateMapper {
    /**
     * 查出考试信息
     */
    public List<Examination> selectAll();



}
