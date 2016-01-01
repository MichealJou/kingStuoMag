package com.cn.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.MLimitMapper;
import com.cn.demo.dao.MmenuItemMapper;
import com.cn.demo.dao.MmenuMapper;
import com.cn.demo.pojo.MLimit;
import com.cn.demo.pojo.Mmenu;
import com.cn.demo.pojo.MmenuItem;
import com.cn.demo.service.IMmenuService;

@Service("mmenuService")  
public class MmenuServiceImpl implements IMmenuService {


	 @Resource  
	 MmenuMapper menuDao;
	 
	 @Resource  
	 MmenuItemMapper menuItemDao;
	 @Resource  
	 MLimitMapper mLimitDao;

	public List<Mmenu> getMenuList(Mmenu record) {
		return menuDao.getList(record);
	}
	
	public List<MmenuItem> getItemList(MmenuItem record){
		return menuItemDao.getList(record);
	}
	
	public MLimit getLimit(MLimit record) {
		return mLimitDao.getLimit(record);
	}


	public int add(Mmenu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int delid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Mmenu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
