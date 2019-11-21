package com.nfdw.base;

import com.nfdw.entity.Achievement_Summary;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.io.Serializable;
import java.util.List;

/**
 * mapper封装 crud
 */
public interface BaseMapper<T, E extends Serializable> extends tk.mybatis.mapper.common.BaseMapper<T>, MySqlMapper<T>, IdsMapper<T> {
    /*
     *//**
     * 根据id删除
     * @param id
     * @return
     *//*
    int deleteByPrimaryKey(E id);

    *//**
     * 插入
     * @param record
     * @return
     *//*
    int insert(T record);

    *//**
     *插入非空字段
     * @param record
     * @return
     *//*
    int insertSelective(T record);

    *//**
     * 根据id查询
     * @param id
     * @return
     *//*
    T selectByPrimaryKey(E id);

    *//**
     * 更新非空数据
     * @param record
     * @return
     *//*
    int updateByPrimaryKeySelective(T record);

    *//**
     * 更新
     * @param record
     * @return
     *//*
    int updateByPrimaryKey(T record);

    */

    /**
     * 查询
     *
     * @param record
     * @return
     */



    List<T> selectListByPage(T record);

    List<T> selectListByPage(T record,int exam_id);

    /*  param
        考试id  专业id  初步入围人数  高考省份  入围分数线    入围排名
     */
    List<Achievement_Summary> selectListByTerm(Integer exam_id,String professional_name, Integer cut_num, String high_provinces,
                                               Integer cut_score,Integer cut_rank);

}
