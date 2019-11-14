package com.nfdw.base.service;

import com.nfdw.base.BaseMapper;
import com.nfdw.util.ReType;

import java.io.Serializable;

/**

 * 通用service层
 */
public interface BaseService<T, E extends Serializable> extends BaseMapper<T, E> {
    /**
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

  */

    /**
     * 更新
     *
     * @param
     * @return
     *//*
  int updateByPrimaryKey(T record);


  List<T> selectListByPage(T record);*/

    public ReType show(T t, int page, int limit);

    public String showAll(T t);
}
