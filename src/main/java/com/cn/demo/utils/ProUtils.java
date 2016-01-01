package com.cn.demo.utils;

import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

public class ProUtils {
	
	private Properties props; 
     
    public ProUtils(){ 
        readProperties("/my.properties"); 
    } 
    private void readProperties(String fileName) { 
        try { 
            props = new Properties(); 
            InputStream fis =getClass().getResourceAsStream(fileName); 
            props.load(fis); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    /**
     * 获取某个属性
     */ 
    public String get(String key){ 
        return props.getProperty(key); 
    } 
  
      
    
	
	
}
