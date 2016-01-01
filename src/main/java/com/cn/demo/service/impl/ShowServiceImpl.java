package com.cn.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.TShowMapper;
import com.cn.demo.dto.ProductDTO;
import com.cn.demo.pojo.TProduct;
import com.cn.demo.pojo.TShow;
import com.cn.demo.service.IShowService;

@Service("showService")
public class ShowServiceImpl implements IShowService {

	@Resource
	TShowMapper showDao;
	public List<TShow> getList(TShow show) {
		return showDao.getList(show);
	}

	public int add(TShow show) {
		// TODO Auto-generated method stub
		return showDao.insert(show);
	}

	public int delete(int delid) {
		// TODO Auto-generated method stub
		return showDao.deleteByPrimaryKey(delid);
	}

	public TShow editInit(int delid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(TShow show) {
		return showDao.updateByPrimaryKeySelective(show);
	}

	public TShow getShow(TShow show) {
		return showDao.getShow(show);
	}

	public TShow selectByPrimaryKey(Integer showId) {
		// TODO Auto-generated method stub
		return showDao.selectByPrimaryKey(showId);
	}


	
}
