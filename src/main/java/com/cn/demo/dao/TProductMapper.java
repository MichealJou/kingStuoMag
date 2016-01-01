package com.cn.demo.dao;

import java.util.List;

import com.cn.demo.dto.ProductDTO;
import com.cn.demo.pojo.TProduct;

public interface TProductMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Integer proId);
    
    List<TProduct> selectByGroupId(TProduct product);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKeyWithBLOBs(TProduct record);

    int updateByPrimaryKey(TProduct record);
    
    
    public List<ProductDTO> getList(ProductDTO product);
}