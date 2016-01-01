package com.cn.demo.service;

import com.cn.demo.dto.ProductDTO;
import com.cn.demo.pojo.TProGroupWithBLOBs;
import com.cn.demo.pojo.TProduct;

import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: 2015 �����ض�˼��Ϣ�����ɷ����޹�˾ ��Ȩ����.��������Ȩ
 * Company:�����ض�˼��Ϣ�����ɷ����޹�˾(TRS)
 * Project: demo
 * Create User: TRS-Vincent.Liu
 * Create Time:2015/10/18 10:58
 */
public interface IProductService {

    public List<ProductDTO> getList(ProductDTO product);

    public int add(TProduct product);


    public int delete(int delid);


    public TProduct editInit(int delid);


    public int update(TProduct product);
    
    
    List<TProGroupWithBLOBs> getGroupList(TProGroupWithBLOBs group);
    
    TProduct selectByPrimaryKey(Integer proId);
    
    
    public List<TProduct> selectByGroupId(TProduct product);
}
