package com.cn.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.demo.pojo.TCantact;
import com.cn.demo.pojo.TIntroduction;
import com.cn.demo.pojo.TMenu;
import com.cn.demo.service.ICantactService;
import com.cn.demo.service.IIntroductionService;
import com.cn.demo.utils.ProUtils;


@Controller
@RequestMapping("/cantact")  
public class CantactController extends BaseController{

	@Resource  
    private ICantactService cantactService;  
	

	
	
	
	@RequestMapping(value = "/editInit")  
	 public String addInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
		HttpSession session= request.getSession();
	    String comId =String.valueOf(session.getAttribute("comId")) ;
		TCantact t =cantactService.editInit(comId);
		model.put("cantact", t);
		return "cantact/edit";  
 }
	
	
	@RequestMapping(value = "/save")  
	public @ResponseBody Map<String, Object> save(HttpServletRequest request,HttpServletResponse response,TCantact cantact,Map<String, Object> model){
		HttpSession session= request.getSession();
	    String comId =String.valueOf(session.getAttribute("comId")) ;
		if(StringUtils.isBlank(cantact.getComId())	){
//			introduction.setComId(pUtils.get("comid"));
			cantact.setComId(comId);
		}
		TCantact t =cantactService.editInit(cantact.getComId());
		if(null != t){
			cantactService.update(cantact);
		}else{
			cantactService.add(cantact);
		}
	
		model.put("msg", "成功");  
		return null;
	}
	

	

	
	
	
	@RequestMapping(value = "/update")  
	public String update(HttpServletRequest request,HttpServletResponse response,TMenu menu,Map<String, Object> model){
		menu.setComId("1");
		
//		System.out.println(menu.gettMenuName());
//		System.out.println(menu.gettType());
//		System.out.println(menu.gettParentId());
//		
//		int i = introductionService.update(menu);
		return "redirect:init";  
	}
	
}
