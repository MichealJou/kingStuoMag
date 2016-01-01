package com.cn.demo.dao;

import java.util.List;
import java.util.Map;

import com.cn.demo.dto.UserDTO;
import com.cn.demo.pojo.TUser;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
	
	TUser getUserByName(Map<String, Object> paras);
	
	List<UserDTO> getList();
}