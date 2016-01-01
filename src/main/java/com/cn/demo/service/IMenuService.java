package com.cn.demo.service;

import java.util.List;

import com.cn.demo.dto.MenuDTO;
import com.cn.demo.pojo.TMenu;

public interface IMenuService {

	
	/**
	  * @Title: getList 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @return  
	  * @author zw 
	  * @return List<TMenu>    返回类型 
	  * @date 2015年9月24日 下午1:38:12 
	  * @throws
	 */
	public List<MenuDTO> getList(TMenu record);
	
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
	public int add(TMenu menu);
	
	
	public int delete(int delid);
	
	
	public TMenu editInit(int delid);
	
	
	public int update(TMenu menu);
	
	/**
	 * 
	  * @Title: getListByParid 
	  * @Description: 查找父类为record的菜单
	  * @param @param record
	  * @param @return  
	  * @author zw 
	  * @return List<MenuDTO>    返回类型 
	  * @date 2015年11月19日 下午4:46:05 
	  * @throws
	 */
	public List<MenuDTO> getListByParid(TMenu record);
	
	
}
