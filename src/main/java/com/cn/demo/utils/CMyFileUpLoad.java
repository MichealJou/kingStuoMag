package com.cn.demo.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CMyFileUpLoad {
    private static Logger logger = Logger.getLogger(CMyFileUpLoad.class);

    private static String uploadPath = null;// �ϴ��ļ���Ŀ¼

    // private static String tempPath = null; // ��ʱ�ļ�Ŀ¼
    private static File uploadFile = null;

    // private static File tempPathFile = null;
    private static int sizeThreshold = 1024;

    private static int sizeMax = 4194304;
    // ��ʼ��
    static {
        uploadPath = "D:/upload/media";
        uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            boolean rst = uploadFile.mkdirs();
        }
    }

    /**
     * ��request�����л�ȡ�ϴ��ļ�����Ĳ�����ļ�������ļ����󼰲���ķ���ֵ
     * @param request HttpServletRequest����
     * @return ���ذ�request���fieldֵ�Լ��ļ������Map
     * modify by Vincent.Liu
     */
    public static Map<String,Object> upload(HttpServletRequest request) {
        Map<String,Object> wrapedMap = new HashMap<String, Object>();
        Map<String,Object> fieldMap = new HashMap<String, Object>();
        // ������������Ƿ�Ϊmultipart�?��ݡ�
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        // �����ǵĻ�
        if (isMultipart) {
            /** Ϊ�����󴴽�һ��DiskFileItemFactory����ͨ��������������ִ�н��������еı?��Ŀ��������һ��List�С� **/
            try {
            	 HttpSession session= request.getSession();
                 String comId =String.valueOf(session.getAttribute("comId")) ;
            	 uploadPath = request.getSession().getServletContext().getRealPath("")+"/uploadimg/"+comId+"/";
                 uploadFile = new File(uploadPath);
                 if (!uploadFile.exists()) {
                     boolean rst = uploadFile.mkdirs();
                 }
            	
            	
            	
            	
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(sizeThreshold); // ���û������С��������4kb
                factory.setRepository(uploadFile);// ���û�����Ŀ¼
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setHeaderEncoding("UTF-8");// ����ļ���������
                upload.setSizeMax(sizeMax);// ��������ļ��ߴ�
                List<FileItem> items = upload.parseRequest(request);
                // �����ļ�
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        fieldMap.put(item.getFieldName(),item.getString().trim());
                    } else {// ������ļ�����
                        String name = item.getName();// ����ļ��� ����·����
                        if (name != null) {
                        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                        	String FileType = item.getName().substring(item.getName().lastIndexOf(".")+1);    
                        	String fname = sdf.format(new Date())+"."+FileType;
                            File fullFile = new File(fname);
//                            File fullFile = new File(item.getName());
                            File savedFile = new File(uploadPath, fullFile.getName());
                            item.write(savedFile);
                            wrapedMap.put("file",savedFile);
                        }
                    }
                }
                wrapedMap.put("fieldMap",fieldMap);
            } catch (Exception e) {
                logger.error("upload file error:",e);
            }
        } else {
            logger.error("the enctype must be multipart/form-data");
        }
        return wrapedMap;
    }

    /**
     * ɾ��һ���ļ�
     * 
     * @param filePath
     *            �ļ�·������
     */
    public static void deleteFile(String[] filePath) {
        if (filePath != null && filePath.length > 0) {
            for (String path : filePath) {
                String realPath = uploadPath + path;
                File delfile = new File(realPath);
                if (delfile.exists()) {
                    delfile.delete();
                }
            }

        }
    }

    /**
     * ɾ����ļ�
     * 
     * @param filePath
     *            �����ļ�·��
     */
    public static void deleteFile(String filePath) {
        if (filePath != null && !"".equals(filePath)) {
            String[] path = new String[] { filePath };
            deleteFile(path);
        }
    }
}
