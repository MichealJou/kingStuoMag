package com.cn.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.cn.demo.utils.CMyFileUpLoad;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright:
 * Company:
 * Project: demo
 * Create User: Vincent.Liu
 * Create Time:2015/10/17 16:47
 */
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String errorMsg = "{\"errcode\":110,\"errmsg\":\"post method required��\"}";
        resp.getWriter().write(errorMsg);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
   	 		HttpSession session= req.getSession();
   	 		String comId =String.valueOf(session.getAttribute("comId")) ;
        // ��ȡ�����е��ļ��Ͳ���ֵ��Map����
        Map<String,Object> wrapedMap = CMyFileUpLoad.upload(req);
        // �����е��ļ�����
        File uploadFile = (File)wrapedMap.get("file");
        System.out.println(uploadFile.getName());
        System.out.println(uploadFile.getPath());

        Map<String,Object> resultMap = new HashMap<String, Object>();

        System.out.println("图片访问路径："+req.getRequestURL()+"/"+comId+"/"+uploadFile.getName());
        System.out.println("图片存储路径："+uploadFile.getPath());
        
        if (uploadFile.exists()) {
            resultMap.put("picPath", uploadFile.getPath());
            resultMap.put("picUrlPath", req.getRequestURL()+"/"+comId+"/"+uploadFile.getName());
            resultMap.put("picName", uploadFile.getName());
            resultMap.put("uploadRst", "200-ok");
        } else {
            resultMap.put("uploadRst", "sys-error-001");
        }

        JSONObject object = (JSONObject) JSONObject.toJSON(resultMap);
        resp.setContentType("text/html");
        resp.getWriter().write(object.toString());
    }

}
