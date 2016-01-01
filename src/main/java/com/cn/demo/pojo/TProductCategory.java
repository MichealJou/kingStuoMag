package com.cn.demo.pojo;

/**
 * Title:
 * Description:
 * Copyright: 2015 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: demo
 * Create User: TRS-Vincent.Liu
 * Create Time:2015/11/2 21:18
 */
public class TProductCategory {

    private Integer id;
    private Integer comId;
    private String pCategoryDesc;
    private String pCategoryName;
    private Integer pCategoryStatus;
    private Integer pCategoryParId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getpCategoryDesc() {
        return pCategoryDesc;
    }

    public void setpCategoryDesc(String pCategoryDesc) {
        this.pCategoryDesc = pCategoryDesc;
    }

    public String getpCategoryName() {
        return pCategoryName;
    }

    public void setpCategoryName(String pCategoryName) {
        this.pCategoryName = pCategoryName;
    }

    public Integer getpCategoryStatus() {
        return pCategoryStatus;
    }

    public void setpCategoryStatus(Integer pCategoryStatus) {
        this.pCategoryStatus = pCategoryStatus;
    }

    public Integer getpCategoryParId() {
        return pCategoryParId;
    }

    public void setpCategoryParId(Integer pCategoryParId) {
        this.pCategoryParId = pCategoryParId;
    }
}
