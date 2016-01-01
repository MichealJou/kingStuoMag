package com.cn.demo.controller;

import com.cn.demo.dto.ProductDTO;
import com.cn.demo.pojo.TProGroupWithBLOBs;
import com.cn.demo.pojo.TProduct;
import com.cn.demo.service.IProductCategoryService;
import com.cn.demo.service.IProductService;
import com.cn.demo.utils.FileUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
  * @ClassName: ProductController 
  * @Description: TODO(这里用一句话描述这个类的作用) 
  * @author zw
  * @date 2015年11月5日 下午4:55:17 
  *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService productService;
    @Resource
    private IProductCategoryService productCategoryService;

    @RequestMapping(value = "/init")
    public String init(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
    	HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        ProductDTO product=new ProductDTO();
        product.setComId(Integer.parseInt(comId));
        List<ProductDTO> pList = new ArrayList<ProductDTO>();
        pList = productService.getList(product);
        model.put("products", pList);
        return "product/productIndex";
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
         
          
          
//          model.put("proGroups", pList);
          model.put("lv_1", lv_1);
          model.put("lv_2", lv_2);
          model.put("lv_3", lv_3);
    	
        return "product/add";
    }


    @RequestMapping(value = "/add")
    public String add(HttpServletRequest request,HttpServletResponse response,TProduct product,Map<String, Object> model){
//        product.setpGroupId(1);
    	 HttpSession session= request.getSession();
         String comId =String.valueOf(session.getAttribute("comId")) ;
         product.setComId(Integer.parseInt(comId));
        int i = productService.add(product);
        return "redirect:init";
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delProduct")
    public @ResponseBody
    Map<String, Object> delProduct(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> model = new HashMap<String, Object>();
        int delid = Integer.parseInt(request.getParameter("delid"));
        
        TProduct product = new TProduct();
        product = productService.selectByPrimaryKey(delid);
        if(product!=null){
        	if(FileUtil.checkPath(product.getProPicPath())){
        		try {
					FileUtil.DeleteFolder(product.getProPicPath());
				} catch (Exception e) {
					System.out.println("删除文件异常"+e);
					e.printStackTrace();
				}
        	}
        }
        
        
        int i = productService.delete(delid);
        model.put("msg", "成功");
        return model;
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
        int editId = Integer.parseInt(request.getParameter("editId"));
        TProduct product = productService.editInit(editId);
        model.put("product", product);

        /*HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        TProGroupWithBLOBs group = new TProGroupWithBLOBs();
        group.setComId(Integer.parseInt(comId));
        List<TProGroupWithBLOBs> groups = productService.getGroupList(group);
        model.put("groups", groups);*/
        
        
        
        
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
        
        return "product/edit";
    }


    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request,HttpServletResponse response,TProduct product,Map<String, Object> model){
//        product.setpGroupId(1);
//        int i = product.(menu);
    	
    	 TProduct product_e = productService.selectByPrimaryKey(product.getProId());
         if(!product_e.getProPicPath().equals(product.getProPicPath())){
         	if(FileUtil.checkPath(product_e.getProPicPath())){
         		try {
 					FileUtil.DeleteFolder(product_e.getProPicPath());
 				} catch (Exception e) {
 					System.out.println("删除文件异常"+e);
 					e.printStackTrace();
 				}
         	}
         }
    	
    	
    	productService.update(product);
    	
        return "redirect:init";
//        return "";
    }
}
