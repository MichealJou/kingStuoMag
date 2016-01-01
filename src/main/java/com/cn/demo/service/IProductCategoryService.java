package com.cn.demo.service;

import java.util.List;

import com.cn.demo.dto.ProductCategoryDTO;
import com.cn.demo.pojo.TProGroupWithBLOBs;
import com.cn.demo.pojo.TProductCategory;

/**
 * Title:
 * Description:
 * Copyright: 2015 �����ض�˼��Ϣ�����ɷ����޹�˾ ��Ȩ����.��������Ȩ
 * Company:�����ض�˼��Ϣ�����ɷ����޹�˾(TRS)
 * Project: demo
 * Create User: TRS-Vincent.Liu
 * Create Time:2015/10/18 10:58
 */
public interface IProductCategoryService {

    public List<TProGroupWithBLOBs> getList(TProGroupWithBLOBs productCategory);
    public List<TProGroupWithBLOBs> getListByPid(TProGroupWithBLOBs productCategory);

    public int add(TProGroupWithBLOBs productCategory);


    public int delete(int delid);


    public TProGroupWithBLOBs editInit(int delid);


    public int update(TProGroupWithBLOBs productCategory);
}
