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

import com.cn.demo.pojo.TIntroduction;
import com.cn.demo.pojo.TMenu;
import com.cn.demo.service.IIntroductionService;
import com.cn.demo.utils.ProUtils;


@Controller
@RequestMapping("/introduction")  
public class IntroductionController extends BaseController{

	@Resource  
    private IIntroductionService introductionService;  
	

	
	
	
	@RequestMapping(value = "/editInit")  
	 public String addInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
		HttpSession session= request.getSession();
	    String comId =String.valueOf(session.getAttribute("comId")) ;
		TIntroduction t =introductionService.editInit(comId);
		model.put("introduction", t);
		return "introduction/edit";  
 }
	
	
	@RequestMapping(value = "/save")  
	public @ResponseBody Map<String, Object> save(HttpServletRequest request,HttpServletResponse response,TIntroduction introduction,Map<String, Object> model){
		HttpSession session= request.getSession();
	    String comId =String.valueOf(session.getAttribute("comId")) ;
		if(StringUtils.isBlank(introduction.getComId())	){
//			introduction.setComId(pUtils.get("comid"));
			introduction.setComId(comId);
		}
		System.out.println(introduction.getIntrContent());
		TIntroduction t =introductionService.editInit(introduction.getComId());
		if(null != t){
			introductionService.update(introduction);
		}else{
			introductionService.add(introduction);
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
