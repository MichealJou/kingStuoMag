package com.cn.demo.dao;

import com.cn.demo.pojo.TCantact;

public interface TCantactMapper {
    int deleteByPrimaryKey(Integer conId);

    int insert(TCantact record);

    int insertSelective(TCantact record);

    TCantact selectByPrimaryKey(Integer conId);

    int updateByPrimaryKeySelective(TCantact record);

    int updateByPrimaryKey(TCantact record);
    
    TCantact selectByComID(String comId);
}