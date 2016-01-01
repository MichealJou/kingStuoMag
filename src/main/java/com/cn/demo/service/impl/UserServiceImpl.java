package com.cn.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.MLimitMapper;
import com.cn.demo.dao.TUserMapper;
import com.cn.demo.dto.UserDTO;
import com.cn.demo.pojo.MLimit;
import com.cn.demo.pojo.TUser;
import com.cn.demo.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {

	 @Resource  
	   private TUserMapper userDao;  
	 @Resource  
	   private MLimitMapper mLimitDao;
	public TUser getUserById(int userId) {
		
		return this.userDao.selectByPrimaryKey(userId);
	}

	/**
	 * 
	  * @Title: getUserByName 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param paras
	  * @param @return  
	  * @author zw 
	  * @date 2015年9月22日 下午2:20:39 
	  * @throws
	 */
	public TUser getUserByName(String username) {
		Map<String, Object> paras = new HashMap<String, Object>();
		paras.put("username", username);
		return userDao.getUserByName(paras);
	}

	/**
	 * 
	  * @Title: getLimit 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param record
	  * @param @return  
	  * @author zw 
	  * @date 2015年11月13日 下午4:38:38 
	  * @throws
	 */
	public MLimit getLimit(MLimit record) {
		
		
		return mLimitDao.getLimit(record);
	}

	/**
	 * 
	  * @Title: getList 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @return  
	  * @author zw 
	  * @date 2015年11月13日 下午4:38:41 
	  * @throws
	 */
	public List<UserDTO> getList() {
		return userDao.getList();
	}


}
