package com.cn.demo.filter;

import com.cn.demo.controller.LoginController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;

/**
 * 
  * @ClassName: LoginFilter 
  * @Description: TODO(这里用一句话描述这个类的作用) 
  * @author zw
  * @date 2015年12月17日 下午4:43:19 
  *
 */
public class LoginFilter implements Filter {

    private static final String LOGIN_URL = "/kingStuoMag/login/init";
    private static final String LOGIN_URL2 = "/kingStuoMag/login/init2";


    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Login Filter Initial!");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        if(StringUtils.isBlank(comId)){
        	response.sendRedirect(LOGIN_URL2);  
        	 return;
        }
        
        
        String path = request.getRequestURI();
        System.out.println("Login filter is filtering the url >>> "+path);

        // ��½ҳ���������
        if(	path.contains("/kingStuoMag/login/init") 
        		|| path.contains("/jsp/assets/")
        		|| path.contains("/jsp/Css/")
        		|| path.contains("/jsp/front/")
        		|| path.contains("/jsp/Images/")
                || path.contains("/jsp/Js/")
                || path.contains("/jsp/ueditor/")
                || path.contains("/login/login")
                || path.contains("/login/loginout")
                || path.contains("/login/")
                || path.contains("/main/")
        		) {
            System.out.println("Filter result >>> do nothing! ");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (LoginController.getLoginUser(request) == null) {
            System.out.println("Filter result >>> login redirect! ");
            response.sendRedirect(LOGIN_URL);

            return;
        }
        System.out.println("Filter result >>> do nothing! ");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("Login Filter Destroyed!");
    }
}
