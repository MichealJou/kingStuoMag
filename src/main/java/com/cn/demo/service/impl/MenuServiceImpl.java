package com.cn.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.TMenuMapper;
import com.cn.demo.dto.MenuDTO;
import com.cn.demo.pojo.TMenu;
import com.cn.demo.service.IMenuService;

@Service("menuService")  
public class MenuServiceImpl implements IMenuService {


	 @Resource  
	 TMenuMapper menuDao;
	 
	 
	public List<MenuDTO> getList(TMenu record) {
		
		
		return menuDao.getList(record);
	}

	
	/**
	 * 
	  * @Title: add 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param menu
	  * @param @return  
	  * @author zw 
	  * @return int    返回类型 
	  * @date 2015年9月24日 下午3:08:40 
	  * @throws
	 */
	public int add(TMenu menu){
		return menuDao.insert(menu);
	}


	/**
	  * @Title: delete 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param delid
	  * @param @return  
	  * @author zw 
	  * @date 2015年9月24日 下午4:20:23 
	  * @throws
	 */
	public int delete(int delid) {
		return menuDao.deleteByPrimaryKey(delid);
	}


	public TMenu editInit(int delid) {
		return menuDao.selectByPrimaryKey(delid);
	}


	public int update(TMenu menu) {
		
		return menuDao.updateByPrimaryKeySelective(menu);
	}


	public List<MenuDTO> getListByParid(TMenu record) {
		// TODO Auto-generated method stub
		return menuDao.getListByParid(record);
	}
	
	
}
