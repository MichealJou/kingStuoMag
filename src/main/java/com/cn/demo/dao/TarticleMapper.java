package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.pojo.Tarticle;

public interface TarticleMapper {
    int deleteByPrimaryKey(Integer artId);

    int insert(Tarticle record);

    int insertSelective(Tarticle record);

    Tarticle selectByPrimaryKey(Integer artId);

    int updateByPrimaryKeySelective(Tarticle record);

    int updateByPrimaryKeyWithBLOBs(Tarticle record);

    int updateByPrimaryKey(Tarticle record);
    
    List<Tarticle> getListByType(Tarticle record);
    
}