package com.cn.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.TProGroupMapper;
import com.cn.demo.pojo.TProGroupWithBLOBs;
import com.cn.demo.service.IProductCategoryService;

/**
 * Title:
 * Description:
 * Copyright: 2015 �����ض�˼��Ϣ�����ɷ����޹�˾ ��Ȩ����.��������Ȩ
 * Company:�����ض�˼��Ϣ�����ɷ����޹�˾(TRS)
 * Project: demo
 * Create User: TRS-Vincent.Liu
 * Create Time:2015/10/18 10:58
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService {

	@Resource TProGroupMapper proGroupDao;
	
	
	
	public List<TProGroupWithBLOBs> getList(TProGroupWithBLOBs productCategory) {
		return proGroupDao.getGroupList(productCategory);
	}

	public List<TProGroupWithBLOBs> getListByPid(TProGroupWithBLOBs productCategory) {
		return proGroupDao.getListByPid(productCategory);
	}

	public int add(TProGroupWithBLOBs productCategory) {
		return proGroupDao.insert(productCategory);
	}

	public int delete(int delid) {
		return proGroupDao.deleteByPrimaryKey(delid);
	}

	public TProGroupWithBLOBs editInit(int delid) {
		return proGroupDao.selectByPrimaryKey(delid);
	}

	public int update(TProGroupWithBLOBs productCategory) {
		return proGroupDao.updateByPrimaryKeySelective(productCategory);
	}

    
}
