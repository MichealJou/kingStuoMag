package com.cn.demo.service;

import java.util.List;

import com.cn.demo.dto.MenuDTO;
import com.cn.demo.pojo.TCantact;
import com.cn.demo.pojo.TIntroduction;
import com.cn.demo.pojo.TMenu;

public interface ICantactService {

	
	/**
	  * @Title: getList 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @return  
	  * @author zw 
	  * @return List<TMenu>    返回类型 
	  * @date 2015年9月24日 下午1:38:12 
	  * @throws
	 */
	public List<TCantact> getList();
	
	/**
	  * @Title: add 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param menu
	  * @param @return  
	  * @author zw 
	  * @return int    返回类型 
	  * @date 2015年9月24日 下午3:08:55 
	  * @throws
	 */
	public int add(TCantact cantact);
	
	
	public int delete(int delid);
	
	
	public TCantact editInit(String comId);
	
	
	public int update(TCantact cantact);
	
}
