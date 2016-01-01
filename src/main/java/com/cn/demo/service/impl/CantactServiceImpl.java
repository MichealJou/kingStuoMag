package com.cn.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.TCantactMapper;
import com.cn.demo.dao.TIntroductionMapper;
import com.cn.demo.pojo.TCantact;
import com.cn.demo.service.ICantactService;

@Service("cantactService")  
public class CantactServiceImpl implements ICantactService {
	 @Resource  
	 TCantactMapper cantactMapper;

	public List<TCantact> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int add(TCantact cantact) {
		return cantactMapper.insert(cantact);
	}

	public int delete(int delid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TCantact editInit(String comId) {
		return cantactMapper.selectByComID(comId);
	}

	public int update(TCantact cantact) {
		return cantactMapper.updateByPrimaryKey(cantact);
	}

}
