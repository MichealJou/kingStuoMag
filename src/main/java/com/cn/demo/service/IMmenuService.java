package com.cn.demo.service;

import java.util.List;

import com.cn.demo.pojo.MLimit;
import com.cn.demo.pojo.Mmenu;
import com.cn.demo.pojo.MmenuItem;

public interface IMmenuService {

	
	/**
	  * @Title: getList 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @return  
	  * @author zw 
	  * @return List<TMenu>    返回类型 
	  * @date 2015年9月24日 下午1:38:12 
	  * @throws
	 */
	public List<Mmenu> getMenuList(Mmenu record);
	
	/**
	 * 
	  * @Title: getItemList 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param record
	  * @param @return  
	  * @author zw 
	  * @return List<MmenuItem>    返回类型 
	  * @date 2015年11月11日 下午4:40:35 
	  * @throws
	 */
	public List<MmenuItem> getItemList(MmenuItem record);
	
	
	public MLimit getLimit(MLimit record);
	
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
	public int add(Mmenu menu);
	
	
	public int delete(int delid);
	
	
	
	
	public int update(Mmenu menu);
	
}
