package com.cn.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.demo.dto.UserDTO;
import com.cn.demo.service.IUserService;



@Controller
@RequestMapping("/user")  
public class UserController extends BaseController {

	
	@Resource  
    private IUserService userService;  
	
	@RequestMapping(value = "/userInit")  
	 public String userInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
		List<UserDTO> list = userService.getList();
		model.put("users", list);
		return "user/userIndex";  
	 }
	
	
	
}
