package com.cn.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.demo.pojo.MLimit;
import com.cn.demo.pojo.TUser;
import com.cn.demo.service.IUserService;

@Controller
@RequestMapping("/login")  
public class LoginController {

	@RequestMapping(value = "/init")  
	 public String login(HttpServletRequest request,HttpServletResponse response){
         
         return "login/login_new";  
     }
	
	@RequestMapping(value = "/init2")  
	public String login2(HttpServletRequest request,HttpServletResponse response){
		
		return "login/login2";  
	}
	
	@Resource  
    private IUserService userService;  
	
	@RequestMapping(value = "/login")  
	 public void login(HttpServletRequest req  
	            , HttpServletResponse res,TUser user,Map<String, Object> model) throws Exception {
		String result = "";
		TUser u = userService.getUserByName(user.getUsername());
//		System.out.println(req.getParameter("id") );
//		TUser u = userService.getUserById(Integer.parseInt(req.getParameter("id")));
		
		if(null!=u){
			MLimit limit = new MLimit();
			limit.setUserId(u.getId());
			MLimit lim = userService.getLimit(limit);
			if(null!=lim){
				if(user.getPassword().equals(u.getPassword())){
					HttpSession session= req.getSession();
		   	        session.setAttribute("comId", u.getComId());
		   	        session.setAttribute("user", u);
		   	        session.setAttribute("userId", u.getId());
		   	        session.setAttribute("menus", lim.getMenus());
//					return "redirect:/main/init";  
				}else{
					result = "密码错误";
				}
			}else{
				result = "账号已过期或无权限";
			}
			
			
		}else{//用户不存在
			result = "用户不存在";
		}
	
	PrintWriter writer = null;
      try {
    	  res.setCharacterEncoding("UTF-8");
    	  writer = res.getWriter(); 
    	  writer.write(result);
    	  writer.flush(); 
    	  writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
		
//		return null;  
		
		
	}
	
	

	@RequestMapping(value = "/loginout")  
	 public String loginout(HttpServletRequest req  
	            , HttpServletResponse res) throws Exception {
			HttpSession session= req.getSession();
			session.removeAttribute("user");
  	        session.removeAttribute("comId");
  	        session.removeAttribute("userId");
  	        session.removeAttribute("menus");
			return "login/login_new";  
		
		
	}
	
	
	
	
	/**
	 * 
	  * @Title: getLoginUser 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param request
	  * @param @return  
	  * @author zw 
	  * @return TUser    返回类型 
	  * @date 2015年11月18日 下午4:41:53 
	  * @throws
	 */
	public static TUser getLoginUser(HttpServletRequest request){
		return (TUser)request.getSession().getAttribute("user");
	}
	

	
	
	public IUserService getUserService() {
		return userService;
	}



	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	
}
