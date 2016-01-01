package com.cn.demo.pojo;

public class TProduct {
    private Integer proId;

    private Integer comId;

    private String proName;

    private String proPicName;

    private String proPicPath;

    private String proPicUrlPath;

    private Integer productGroupId;

    private String proDesc;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProPicName() {
        return proPicName;
    }

    public void setProPicName(String proPicName) {
        this.proPicName = proPicName == null ? null : proPicName.trim();
    }

    public String getProPicPath() {
        return proPicPath;
    }

    public void setProPicPath(String proPicPath) {
        this.proPicPath = proPicPath == null ? null : proPicPath.trim();
    }

    public String getProPicUrlPath() {
        return proPicUrlPath;
    }

    public void setProPicUrlPath(String proPicUrlPath) {
        this.proPicUrlPath = proPicUrlPath == null ? null : proPicUrlPath.trim();
    }

    public Integer getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Integer productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc == null ? null : proDesc.trim();
    }
}