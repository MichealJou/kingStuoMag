package com.cn.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.demo.dao.TarticleMapper;
import com.cn.demo.pojo.TMenu;
import com.cn.demo.pojo.Tarticle;
import com.cn.demo.service.IArticleService;

@Service("articleService")  
public class ArticleServiceImpl implements IArticleService {

	 @Resource  
	 TarticleMapper articleDao;

	 /**
	  * 
	   * @Title: getArticlesByType 
	   * @Description: TODO(这里用一句话描述这个方法的作用) 
	   * @param @param article
	   * @param @return  
	   * @author zw 
	   * @date 2015年10月20日 下午2:35:43 
	   * @throws
	  */
	public List<Tarticle> getArticlesByType(Tarticle article) {
		return articleDao.getListByType(article);
	}

	/**
	  * @Title: add 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param article
	  * @param @return  
	  * @author zw 
	  * @date 2015年10月20日 下午3:44:01 
	  * @throws
	 */
	public int add(Tarticle article) {
		return articleDao.insert(article);
	}

	/**
	  * @Title: delete 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param delid
	  * @param @return  
	  * @author zw 
	  * @date 2015年10月20日 下午3:51:32 
	  * @throws
	 */
	public int delete(int delid) {
		return articleDao.deleteByPrimaryKey(delid);
	}

	/**
	  * @Title: editInit 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param editId
	  * @param @return  
	  * @author zw 
	  * @date 2015年10月20日 下午4:17:49 
	  * @throws
	 */
	public Tarticle editInit(int editId) {
		return articleDao.selectByPrimaryKey(editId);
	}

	/**
	  * @Title: update 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param article
	  * @param @return  
	  * @author zw 
	  * @date 2015年10月20日 下午4:18:00 
	  * @throws
	 */
	public int update(Tarticle article) {
		return articleDao.updateByPrimaryKeySelective(article);
	}
	 
}
