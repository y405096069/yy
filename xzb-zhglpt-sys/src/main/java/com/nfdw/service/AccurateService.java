package com.nfdw.service;/**
 * @author caisheng
 * @create 2019-11-20 16:18
 */

import com.nfdw.entity.Examination;

import java.util.List;

/**
 * @author caisheng
 * @create 2019-11-20 16:18
 */
public interface AccurateService {
    /**
     * 查出考试信息
     */
    public List<Examination> selectAll();

}
