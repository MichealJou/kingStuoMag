package com.cn.demo.service.impl;

import com.cn.demo.dao.TProGroupMapper;
import com.cn.demo.dao.TProductMapper;
import com.cn.demo.dto.MenuDTO;
import com.cn.demo.dto.ProductDTO;
import com.cn.demo.pojo.TMenu;
import com.cn.demo.pojo.TProGroupWithBLOBs;
import com.cn.demo.pojo.TProduct;
import com.cn.demo.service.IProductService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 
  * @ClassName: ProductServiceImpl 
  * @Description: TODO(这里用一句话描述这个类的作用) 
  * @author zw
  * @date 2015年11月6日 下午4:21:04 
  *
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Resource
    TProductMapper productDao;
    @Resource
    TProGroupMapper proGroupMapper;

    public List<ProductDTO> getList( ProductDTO product) {
        return productDao.getList(product);
    }

    public int add(TProduct product) {
        return productDao.insert(product);
    }

    public int delete(int delid) {
        return productDao.deleteByPrimaryKey(delid);
    }

    public TProduct editInit(int editid) {
        return productDao.selectByPrimaryKey(editid);
    }

    public int update(TProduct product) {
        return productDao.updateByPrimaryKeySelective(product);
    }

	public List<TProGroupWithBLOBs> getGroupList(TProGroupWithBLOBs group) {
		return proGroupMapper.getGroupList(group);
	}

	public TProduct selectByPrimaryKey(Integer proId) {
		// TODO Auto-generated method stub
		return productDao.selectByPrimaryKey(proId);
	}

	public List<TProduct> selectByGroupId(TProduct product) {
		// TODO Auto-generated method stub
		return productDao.selectByGroupId(product);
	}
    
    
}
