package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.pojo.MmenuItem;

public interface MmenuItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MmenuItem record);

    int insertSelective(MmenuItem record);

    MmenuItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MmenuItem record);

    int updateByPrimaryKey(MmenuItem record);
    
    List<MmenuItem> getList(MmenuItem record);
}