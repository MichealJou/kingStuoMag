package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.dto.MenuDTO;
import com.cn.demo.pojo.TMenu;


public interface TMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    TMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
    
    List<MenuDTO> getList(TMenu record);
    
    List<MenuDTO> getListByParid(TMenu record);
}