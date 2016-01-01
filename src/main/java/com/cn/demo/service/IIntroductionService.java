package com.cn.demo.service;

import java.util.List;

import com.cn.demo.dto.MenuDTO;
import com.cn.demo.pojo.TIntroduction;
import com.cn.demo.pojo.TMenu;

public interface IIntroductionService {

	
	/**
	  * @Title: getList 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @return  
	  * @author zw 
	  * @return List<TMenu>    返回类型 
	  * @date 2015年9月24日 下午1:38:12 
	  * @throws
	 */
	public List<TIntroduction> getList();
	
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
	public int add(TIntroduction introduction);
	
	
	public int delete(int delid);
	
	
	public TIntroduction editInit(String comId);
	
	
	public int update(TIntroduction introduction);
	
}
