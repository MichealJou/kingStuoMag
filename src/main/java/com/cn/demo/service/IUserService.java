package com.cn.demo.service;

import java.util.List;

import com.cn.demo.dto.UserDTO;
import com.cn.demo.pojo.MLimit;
import com.cn.demo.pojo.TUser;

public interface IUserService {

	  public TUser getUserById(int userId);  
	  
	  /**
	   * 
	    * @Title: getUserByName 
	    * @Description: TODO(这里用一句话描述这个方法的作用) 
	    * @param @param paras
	    * @param @return  
	    * @author zw 
	    * @return TUser    返回类型 
	    * @date 2015年9月22日 下午2:20:18 
	    * @throws
	   */
	  public TUser getUserByName(String username);
	  
	  /**
	   * 
	    * @Title: getLimit 
	    * @Description: TODO(这里用一句话描述这个方法的作用) 
	    * @param @param record
	    * @param @return  
	    * @author zw 
	    * @return MLimit    返回类型 
	    * @date 2015年11月13日 下午4:38:07 
	    * @throws
	   */
	  public MLimit getLimit(MLimit record) ;
	  
	  /**
	   * 
	    * @Title: getList 
	    * @Description: TODO(这里用一句话描述这个方法的作用) 
	    * @param @return  
	    * @author zw 
	    * @return List<TUser>    返回类型 
	    * @date 2015年11月13日 下午4:38:11 
	    * @throws
	   */
	  public List<UserDTO> getList();
}
