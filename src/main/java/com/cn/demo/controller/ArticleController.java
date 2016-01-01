package com.cn.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.demo.dto.MenuDTO;
import com.cn.demo.pojo.TMenu;
import com.cn.demo.pojo.Tarticle;
import com.cn.demo.service.IArticleService;


@Controller
@RequestMapping("/article") 
public class ArticleController extends BaseController {

	@Resource  
    private IArticleService articleService;  
	
	
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
	  * @date 2015年10月20日 下午2:23:40 
	  * @throws
	 */
	@RequestMapping(value = "/init")  
	 public String init(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
		
		try {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			List<Tarticle> aList = new ArrayList<Tarticle>();
			HttpSession session= request.getSession();
			String comId =String.valueOf(session.getAttribute("comId")) ;
			Tarticle article = new Tarticle();
			article.setComId(Integer.parseInt(comId));
			article.setArtType(typeId);
			aList = articleService.getArticlesByType(article);
			model.put("articles", aList);
			model.put("artType", typeId);
		} catch (Exception e) {
			e.printStackTrace();
		    return "redirect:login/init";  
		}
        return "article/articleIndex";  
	}
	
	
	
	/**
	  * @Title: addInit 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param request
	  * @param @param response
	  * @param @param model
	  * @param @return  
	  * @author zw 
	  * @return String    返回类型 
	  * @date 2015年10月20日 下午3:23:56 
	  * @throws
	 */
	@RequestMapping(value = "/addInit")  
	 public String addInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		model.put("typeId", typeId);
		return "article/add";  
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
	  * @date 2015年10月20日 下午3:24:03 
	  * @throws
	 */
	@RequestMapping(value = "/add")  
	public String add(HttpServletRequest request,HttpServletResponse response,Tarticle article,Map<String, Object> model){
		
//		menu.setComId(pUtils.get("comid"));
		HttpSession session= request.getSession();
		System.out.println(session.getAttribute("comId"));
		article.setComId(2);
		article.setArtCreateTime(new Date());
		System.out.println(article.getArtContent());
		int i = articleService.add(article);
		model.put("msg", "成功");  
		return null;
	}
	
	
	@RequestMapping(value = "/delArticle")  
	public @ResponseBody Map<String, Object> delArticle(HttpServletRequest request,HttpServletResponse response){
		 Map<String, Object> model = new HashMap<String, Object>();
		int delid = Integer.parseInt(request.getParameter("delid"));
		int i = articleService.delete(delid);
		model.put("msg", "成功");  
		return model;  
	}
	
	
	@RequestMapping(value = "/editInit")  
	 public String editInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
		 int articleId = Integer.parseInt(request.getParameter("articleId"));
		 Tarticle t = articleService.editInit(articleId);
	     model.put("article", t);
	     return "article/edit";  
	}
	
	@RequestMapping(value = "/update")  
	public String update(HttpServletRequest request,HttpServletResponse response,Tarticle article,Map<String, Object> model){
//		HttpSession session= request.getSession();
//	    String comId =String.valueOf(session.getAttribute("comId")) ;
//	    article.setComId(comId);
		
		int i = articleService.update(article);
		model.put("msg", "成功");  
		return null;
	}
}
