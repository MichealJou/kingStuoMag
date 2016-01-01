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

import com.cn.demo.pojo.TProduct;
import com.cn.demo.pojo.TShow;
import com.cn.demo.service.IShowService;
import com.cn.demo.utils.FileUtil;

/**
 * 
  * @ClassName: ShowController 
  * @Description: TODO(这里用一句话描述这个类的作用) 
  * @author zw
  * @date 2015年11月5日 上午8:50:17 
  *
 */
@Controller
@RequestMapping("/show")
public class ShowController {

    @Resource
    private IShowService showService;

    @RequestMapping(value = "/init")
    public String init(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
    	  HttpSession session= request.getSession();
          String comId =String.valueOf(session.getAttribute("comId")) ;
          TShow show = new TShow();
          show.setComId(Integer.parseInt(comId));
	      List<TShow> sList = new ArrayList<TShow>();
	      sList = showService.getList(show);
	      model.put("shows", sList);
        return "show/showIndex";
    }



    @RequestMapping(value = "/addInit")
    public String addInit(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
//        List<ProductDTO> pList = new ArrayList<ProductDTO>();
//        pList = productService.getList();
//        model.put("products", pList);
        return "show/add";
    }


    @RequestMapping(value = "/add")
    public  void add(HttpServletRequest request,HttpServletResponse response,TShow show){
    	  HttpSession session= request.getSession();
          String comId =String.valueOf(session.getAttribute("comId")) ;
          show.setComId(Integer.parseInt(comId));
          String result = "上传成功";
          if(StringUtils.isBlank(show.getShowPicPath())){
        	  result="请上传图片";
          }else{
	          if(null==showService.getShow(show)){
	        	  int i = showService.add(show);
	          }else{
	        	  result="您已上传该位置状态为可用的图片";
	          }
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
          
//          return result;
      
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delShow")
    public @ResponseBody
    Map<String, Object> delMenu(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> model = new HashMap<String, Object>();
        int delid = Integer.parseInt(request.getParameter("delid"));
        //先获取文件路径
        
        TShow show = showService.selectByPrimaryKey(delid);
        if(null != show){
        	if(FileUtil.checkPath(show.getShowPicPath())){
        		try {
					FileUtil.DeleteFolder(show.getShowPicPath());
				} catch (Exception e) {
					System.out.println("删除文件异常"+e);
					e.printStackTrace();
				}
        	}
        }
        
        int i = showService.delete(delid);
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
//        int menuId = Integer.parseInt(request.getParameter("productId"));
//        TProduct product = productService.editInit(menuId);
//        model.put("product", product);
//
//        List<ProductDTO> pList = new ArrayList<ProductDTO>();
//        pList = productService.getList();
//        model.put("products", pList);
        return "menu/edit";
    }


    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model){
    	int showId = Integer.parseInt(request.getParameter("showId"));
    	String text = request.getParameter("text");
    	int delVal = Integer.parseInt(request.getParameter("delVal"));
    	int orderVal = Integer.parseInt(request.getParameter("orderVal"));
    	
	    HttpSession session= request.getSession();
        String comId =String.valueOf(session.getAttribute("comId")) ;
        TShow show = new TShow();
        show.setComId(Integer.parseInt(comId));
        show.setShowId(showId);
        show.setShowDel(delVal);
        show.setShowPicText(text);
        show.setShowPicOrder(orderVal);
    	
    	int i =showService.update(show);
    	model.put("msg", "成功");
        return "";
    }
}
