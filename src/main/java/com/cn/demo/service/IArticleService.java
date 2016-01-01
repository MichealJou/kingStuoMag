package com.cn.demo.service;

import java.util.List;

import com.cn.demo.pojo.TMenu;
import com.cn.demo.pojo.Tarticle;

public interface IArticleService {
	
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
	public List<Tarticle> getArticlesByType(Tarticle article);
	
	/**
	  * @Title: add 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param article
	  * @param @return  
	  * @author zw 
	  * @date 2015年10月20日 下午3:44:01 
	  * @throws
	 */
	public int add(Tarticle article);
	
	/**
	 * 
	  * @Title: delete 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param delid
	  * @param @return  
	  * @author zw 
	  * @return int    返回类型 
	  * @date 2015年10月20日 下午3:50:46 
	  * @throws
	 */
	public int delete(int delid);
	
	/**
	  * @Title: editInit 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param editId
	  * @param @return  
	  * @author zw 
	  * @return TMenu    返回类型 
	  * @date 2015年10月20日 下午4:03:12 
	  * @throws
	 */
	public Tarticle editInit(int editId);
	
	/**
	  * @Title: update 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param article
	  * @param @return  
	  * @author zw 
	  * @return int    返回类型 
	  * @date 2015年10月20日 下午4:17:41 
	  * @throws
	 */
	public int update(Tarticle article);

}
