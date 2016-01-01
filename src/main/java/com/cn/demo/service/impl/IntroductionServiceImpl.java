package com.cn.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.TIntroductionMapper;
import com.cn.demo.pojo.TIntroduction;
import com.cn.demo.service.IIntroductionService;


@Service("introductionService")  
public class IntroductionServiceImpl implements IIntroductionService {
	
	
	 @Resource  
	 TIntroductionMapper introductionMapper;
	 

	public List<TIntroduction> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int add(TIntroduction introduction) {
		return introductionMapper.insert(introduction);
	}

	public int delete(int delid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TIntroduction editInit(String comId) {
		// TODO Auto-generated method stub
		return introductionMapper.selectByComID(comId);
	}

	public int update(TIntroduction introduction) {
		return introductionMapper.updateByPrimaryKey(introduction);
	}

}
