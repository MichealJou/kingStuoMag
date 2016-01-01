package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.pojo.Mmenu;

public interface MmenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mmenu record);

    int insertSelective(Mmenu record);

    Mmenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mmenu record);

    int updateByPrimaryKey(Mmenu record);
    
    
    List<Mmenu> getList(Mmenu record);
}