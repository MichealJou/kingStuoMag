package com.cn.demo.dao;

import com.cn.demo.pojo.TIntroduction;


public interface TIntroductionMapper {
    int deleteByPrimaryKey(Integer intrId);

    int insert(TIntroduction record);

    int insertSelective(TIntroduction record);

    TIntroduction selectByPrimaryKey(Integer intrId);
    
    TIntroduction selectByComID(String comId);

    int updateByPrimaryKeySelective(TIntroduction record);

    int updateByPrimaryKey(TIntroduction record);
    
    
}