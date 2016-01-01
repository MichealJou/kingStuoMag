package com.cn.demo.service;

import java.util.List;

import com.cn.demo.dto.ProductDTO;
import com.cn.demo.pojo.TProduct;
import com.cn.demo.pojo.TShow;

/**
 * 
  * @ClassName: IShowService 
  * @Description: TODO(这里用一句话描述这个类的作用) 
  * @author zw
  * @date 2015年11月5日 上午10:21:15 
  *
 */
public interface IShowService {

    public List<TShow> getList(TShow show);

    public int add(TShow show);


    public int delete(int delid);


    public TShow editInit(int delid);


    public int update(TShow show);
    
    public TShow getShow(TShow show);
    
    TShow selectByPrimaryKey(Integer showId);
    
    
}
