package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.dto.ProductCategoryDTO;
import com.cn.demo.pojo.TProGroup;
import com.cn.demo.pojo.TProGroupWithBLOBs;
import com.cn.demo.pojo.TProductCategory;

public interface TProGroupMapper {
    int deleteByPrimaryKey(Integer proCategoryId);

    int insert(TProGroupWithBLOBs record);

    int insertSelective(TProGroupWithBLOBs record);

    TProGroupWithBLOBs selectByPrimaryKey(Integer proCategoryId);

    int updateByPrimaryKeySelective(TProGroupWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TProGroupWithBLOBs record);

    int updateByPrimaryKey(TProGroup record);
    
    List<TProGroupWithBLOBs> getGroupList(TProGroupWithBLOBs group);
    
    
  
    List<TProGroupWithBLOBs> getListByPid(TProGroupWithBLOBs record);
}