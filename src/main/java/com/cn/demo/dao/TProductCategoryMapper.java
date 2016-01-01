package com.cn.demo.dao;


import com.cn.demo.dto.ProductCategoryDTO;
import com.cn.demo.dto.ProductDTO;
import com.cn.demo.pojo.TProduct;
import com.cn.demo.pojo.TProductCategory;

import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: 2015 �����ض�˼��Ϣ�����ɷ����޹�˾ ��Ȩ����.��������Ȩ
 * Company:�����ض�˼��Ϣ�����ɷ����޹�˾(TRS)
 * Project: demo
 * Create User: TRS-Vincent.Liu
 * Create Time:2015/10/18 11:02
 */
public interface TProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TProductCategory record);

    int insertSelective(TProductCategory record);

    TProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TProductCategory record);

    int updateByPrimaryKey(TProductCategory record);

    List<ProductCategoryDTO> getList(TProductCategory record);
    List<ProductCategoryDTO> getListByPid(TProductCategory record);
}
