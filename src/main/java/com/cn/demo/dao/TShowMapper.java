package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.pojo.TShow;


public interface TShowMapper {
    int deleteByPrimaryKey(Integer showId);

    int insert(TShow record);

    int insertSelective(TShow record);

    TShow selectByPrimaryKey(Integer showId);

    int updateByPrimaryKeySelective(TShow record);

    int updateByPrimaryKey(TShow record);
    
    List<TShow> getList(TShow show);
    
    TShow getShow(TShow show);
}