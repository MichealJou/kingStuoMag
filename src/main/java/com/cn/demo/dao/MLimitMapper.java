package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.pojo.MLimit;

public interface MLimitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MLimit record);

    int insertSelective(MLimit record);

    MLimit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MLimit record);

    int updateByPrimaryKey(MLimit record);
    
    MLimit getLimit(MLimit record);
}