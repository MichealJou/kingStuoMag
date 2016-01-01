package com.cn.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.demo.dto.ProductCategoryDTO;
import com.cn.demo.pojo.TProGroupWithBLOBs;
import com.cn.demo.pojo.TProduct;
import com.cn.demo.pojo.TProductCategory;
import com.cn.demo.service.IProductCategoryService;
import com.cn.demo.service.IProductService;

/**
 * Title:
 * Description:
 * Copyright: 2015 �����ض�˼��Ϣ�����ɷ����޹�˾ ��Ȩ����.��������Ȩ
 * Company:�����ض�˼��Ϣ�����ɷ����޹�˾(TRS)
 * Project: demo
 * Create User: TRS-Vincent.Liu
 * Create Time:2015/10/18 10:50
 */
@Controller
@RequestMapping("/proGroup")
public class ProductCategoryController {

    @Resource
    private IProductCategoryService productCategoryService;
    @Resource
    private IProductService productService;

    @RequestMapping(value = "/init")
    public String init(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
        List<TProGroupWithBLOBs> pList = new ArrayList<TProGroupWithBLOBs>();
        HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        TProGroupWithBLOBs proGroup = new TProGroupWithBLOBs();
        proGroup.setComId(Integer.parseInt(comId));
        pList = productCategoryService.getList(proGroup);
        model.put("proGroups", pList);
        return "proGroup/proGroupIndex";
    }



    @RequestMapping(value = "/addInit")
    public String addInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
        List<TProGroupWithBLOBs> pList = new ArrayList<TProGroupWithBLOBs>();
        HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        TProGroupWithBLOBs proGroup = new TProGroupWithBLOBs();
        proGroup.setComId(Integer.parseInt(comId));
        pList = productCategoryService.getList(proGroup);
        
        List<TProGroupWithBLOBs> lv_1 = new ArrayList<TProGroupWithBLOBs>();
        List<TProGroupWithBLOBs> lv_2 = new ArrayList<TProGroupWithBLOBs>();
        List<TProGroupWithBLOBs> lv_3 = new ArrayList<TProGroupWithBLOBs>();
        if(null !=pList && pList.size()>0){
        	for (TProGroupWithBLOBs productCategoryDTO : pList) {
     			if(productCategoryDTO.getProCategoryParentId() == 0){ //一级菜单
     				lv_1.add(productCategoryDTO); 
     			}
        		for(TProGroupWithBLOBs productCategoryDTO1 : pList){
        			if(productCategoryDTO1.getProCategoryParentId() == productCategoryDTO.getProCategoryId() && productCategoryDTO.getProCategoryParentId() == 0){//二级菜单
        				 lv_2.add(productCategoryDTO1);
        			}else if(productCategoryDTO1.getProCategoryParentId() == productCategoryDTO.getProCategoryId() && productCategoryDTO.getProCategoryParentId() != 0){//三级菜单
        				lv_3.add(productCategoryDTO1);
        			}
        		}
     		}
        }
       
        
        
//        model.put("proGroups", pList);
        model.put("lv_1", lv_1);
        model.put("lv_2", lv_2);
        model.put("lv_3", lv_3);
        return "proGroup/add";
    }


    @RequestMapping(value = "/add")
    public String add(HttpServletRequest request,HttpServletResponse response,TProGroupWithBLOBs productCategory,Map<String, Object> model){
    	 HttpSession session= request.getSession();
         String comId =String.valueOf(session.getAttribute("comId")) ;
        productCategory.setComId( Integer.valueOf(comId));
        int i = productCategoryService.add(productCategory);
        return "redirect:init";
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delProGroup")
    public void delProductCategory(HttpServletRequest request,HttpServletResponse response){
    	String result = "";
        int delid = Integer.parseInt(request.getParameter("delid"));
        HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        TProGroupWithBLOBs productCategory = new TProGroupWithBLOBs();
        productCategory.setComId(Integer.parseInt(comId));
        productCategory.setProCategoryId(delid);
        
        List<TProGroupWithBLOBs> pList = new ArrayList<TProGroupWithBLOBs>();
        
        pList = productCategoryService.getListByPid(productCategory);
        TProduct product = new TProduct();
        product.setComId(Integer.parseInt(comId));
        product.setProductGroupId(delid);
        List<TProduct> proList = new ArrayList<TProduct>();
        proList = productService.selectByGroupId(product);
        
        if(null!=pList && pList.size()>0){
        	result="该分类为其他分类的父类，无法删除";
        }else if(null!=proList && proList.size()>0){
        	result="该分类已被产品信息使用，无法删除";
        }else{
        	int i = productCategoryService.delete(delid);
        }
        
    	PrintWriter writer = null;
	      try {
	    	  response.setCharacterEncoding("UTF-8");
	    	  writer = response.getWriter(); 
	    	  writer.write(result);
	    	  writer.flush(); 
	    	  writer.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
    }

    /**
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/editInit")
    public String editInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
        int proGroupId = Integer.parseInt(request.getParameter("proGroupId"));
        TProGroupWithBLOBs productCategory = productCategoryService.editInit(proGroupId);
        model.put("productCategory", productCategory);

        List<TProGroupWithBLOBs> pList = new ArrayList<TProGroupWithBLOBs>();
        HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        TProGroupWithBLOBs proGroup = new TProGroupWithBLOBs();
        proGroup.setComId(Integer.parseInt(comId));
        pList = productCategoryService.getList(proGroup);
        
        List<TProGroupWithBLOBs> lv_1 = new ArrayList<TProGroupWithBLOBs>();
        List<TProGroupWithBLOBs> lv_2 = new ArrayList<TProGroupWithBLOBs>();
        List<TProGroupWithBLOBs> lv_3 = new ArrayList<TProGroupWithBLOBs>();
        if(null !=pList && pList.size()>0){
        	for (TProGroupWithBLOBs productCategoryDTO : pList) {
     			if(productCategoryDTO.getProCategoryParentId() == 0){ //一级菜单
     				lv_1.add(productCategoryDTO); 
     			}
        		for(TProGroupWithBLOBs productCategoryDTO1 : pList){
        			if(productCategoryDTO1.getProCategoryParentId() == productCategoryDTO.getProCategoryId() && productCategoryDTO.getProCategoryParentId() == 0){//二级菜单
        				 lv_2.add(productCategoryDTO1);
        			}else if(productCategoryDTO1.getProCategoryParentId() == productCategoryDTO.getProCategoryId() && productCategoryDTO.getProCategoryParentId() != 0){//三级菜单
        				lv_3.add(productCategoryDTO1);
        			}
        		}
     		}
        }
       
        
        
//        model.put("proGroups", pList);
        model.put("lv_1", lv_1);
        model.put("lv_2", lv_2);
        model.put("lv_3", lv_3);
        
       /* model.put("productCategories", pList);*/
        return "proGroup/edit";
    }


    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request,HttpServletResponse response,TProGroupWithBLOBs productCategory,Map<String, Object> model){
       int i = productCategoryService.update(productCategory);
        return "redirect:init";
    }
}
