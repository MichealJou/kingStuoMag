package com.cn.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.demo.dto.MenuDTO;
import com.cn.demo.dto.ProductCategoryDTO;
import com.cn.demo.pojo.TMenu;
import com.cn.demo.service.IMenuService;


@Controller
@RequestMapping("/menu")  
public class MenuController extends BaseController{
	
	@Resource  
    private IMenuService menuService;  
	
	/**
	 * 
	  * @Title: init 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param request
	  * @param @param response
	  * @param @param model
	  * @param @return  
	  * @author zw 
	  * @return String    返回类型 
	  * @date 2015年9月24日 下午2:53:04 
	  * @throws
	 */
	@RequestMapping(value = "/init")  
	 public String init(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
       List<MenuDTO> mList = new ArrayList<MenuDTO>();
       HttpSession session= request.getSession();
       String comId =String.valueOf(session.getAttribute("comId")) ;
       TMenu m = new TMenu();
       m.setComId(comId);
       mList = menuService.getList(m);
       
       List<MenuDTO> pList = new ArrayList<MenuDTO>();//父级标菜单的list
       List<MenuDTO> iList = new ArrayList<MenuDTO>();//子菜单的list
       
       if(null!=mList&&mList.size()>0){
    	   for (MenuDTO menuDTO : iList) {
    			if(menuDTO.gettParentId() == 0 || StringUtils.isBlank(menuDTO.getPname())){
    				pList.add(menuDTO);
    			}else{
    				iList.add(menuDTO);
    			}
           }
           
       }
      
       
       model.put("pList", mList);
       model.put("iList", mList);
//       model.put("menus", mList);
       return "menu/menuIndex";  
   }

	
	/**
	 * 
	  * @Title: addInit 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param request
	  * @param @param response
	  * @param @param model
	  * @param @return  
	  * @author zw 
	  * @return String    返回类型 
	  * @date 2015年9月24日 下午2:53:08 
	  * @throws
	 */
	@RequestMapping(value = "/addInit")  
	 public String addInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
      List<MenuDTO> mList = new ArrayList<MenuDTO>();
      HttpSession session= request.getSession();
      String comId =String.valueOf(session.getAttribute("comId")) ;
      TMenu m = new TMenu();
      m.setComId(comId);
      mList = menuService.getList(m);
      model.put("menus", mList);
      return "menu/add";  
  }
	
	/**
	  * @Title: add 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param request
	  * @param @param response
	  * @param @param menu
	  * @param @param model
	  * @param @return  
	  * @author zw 
	  * @return String    返回类型 
	  * @date 2015年9月24日 下午3:07:21 
	  * @throws
	 */
	@RequestMapping(value = "/add")  
	public String add(HttpServletRequest request,HttpServletResponse response,TMenu menu,Map<String, Object> model){
		
//		menu.setComId(pUtils.get("comid"));
		HttpSession session= request.getSession();
		
		menu.setComId(String.valueOf(session.getAttribute("comId")));
		if(menu.gettParentId()==null){
			menu.settParentId(0);
		}
		System.out.println(menu.gettMenuName());
		int i = menuService.add(menu);
		return "redirect:init";  
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delMenu")  
	public void delMenu(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		int delid = Integer.parseInt(request.getParameter("delid"));
		//判断是否占用
		TMenu menu = new TMenu();
		HttpSession session= request.getSession();
		menu.setComId(String.valueOf(session.getAttribute("comId")));
		menu.settParentId(delid);
		List<MenuDTO> mList = new ArrayList<MenuDTO>();
		mList  = menuService.getListByParid(menu);
		 if(mList !=null&&mList.size()>0 ){//已占用
			 result="该菜单为其他菜单父级菜单，无法删除";
		 }else{//未占用
			 int i = menuService.delete(delid);
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
	 int menuId = Integer.parseInt(request.getParameter("menuId"));
	 TMenu m = menuService.editInit(menuId);
     model.put("menu", m);
     
     List<MenuDTO> mList = new ArrayList<MenuDTO>();
     HttpSession session= request.getSession();
     String comId =String.valueOf(session.getAttribute("comId")) ;
     TMenu tm = new TMenu();
     tm.setComId(comId);
     mList = menuService.getList(tm);
//     model.put("menus", mList);
     
     
     
     
     
     List<MenuDTO> lv_1 = new ArrayList<MenuDTO>();
     List<MenuDTO> lv_2 = new ArrayList<MenuDTO>();
     List<MenuDTO> lv_3 = new ArrayList<MenuDTO>();
     if(null !=mList && mList.size()>0){
     	for (MenuDTO menuDTO : mList) {
  			if(menuDTO.gettParentId() == 0){ //一级菜单
  				lv_1.add(menuDTO); 
  			}
     		for(MenuDTO menuDTO1 : mList){
     			if(menuDTO1.gettParentId() == menuDTO.getId() && menuDTO.gettParentId() == 0){//二级菜单
     				 lv_2.add(menuDTO1);
     			}else if(menuDTO1.gettParentId() == menuDTO.getId() && menuDTO.gettParentId() != 0){//三级菜单
     				lv_3.add(menuDTO1);
     			}
     		}
  		}
     }
     model.put("lv_1", lv_1);
     model.put("lv_2", lv_2);
     model.put("lv_3", lv_3);
     
     return "menu/edit";  
 }
	
	
	@RequestMapping(value = "/update")  
	public String update(HttpServletRequest request,HttpServletResponse response,TMenu menu,Map<String, Object> model){
		HttpSession session= request.getSession();
	    String comId =String.valueOf(session.getAttribute("comId")) ;
		menu.setComId(comId);
		int i = menuService.update(menu);
		return "redirect:init";  
	}
	
}
