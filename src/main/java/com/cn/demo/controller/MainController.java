package com.cn.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.demo.dto.MenuDTO;
import com.cn.demo.pojo.Mmenu;
import com.cn.demo.pojo.MmenuItem;
import com.cn.demo.service.IMmenuService;


@Controller
@RequestMapping("/main")  
public class MainController {

	@Resource  
    private IMmenuService mmenuService;  
	
	@RequestMapping(value = "/init")  
	 public String init(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
		  List<Mmenu> mList = new ArrayList<Mmenu>();
		  Mmenu memu = new Mmenu();
		  HttpSession session= request.getSession();
	      String menus =String.valueOf(session.getAttribute("menus")) ;
	      System.out.println("menus ["+menus+"]");
	      memu.setMenus(menus);
		  mList = mmenuService.getMenuList(memu);
		  model.put("menus", mList);
		  model.put("menuarr", menus);
		  
		  
		  
		  
		  
		  
        return "main/index2";  
    }
	
}
