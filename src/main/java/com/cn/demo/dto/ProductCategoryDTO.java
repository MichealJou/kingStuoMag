package com.cn.demo.dto;

/**
 * Title:
 * Description:
 * Copyright: 2015 �����ض�˼��Ϣ�����ɷ����޹�˾ ��Ȩ����.��������Ȩ
 * Company:�����ض�˼��Ϣ�����ɷ����޹�˾(TRS)
 * Project: demo
 * Create User: TRS-Vincent.Liu
 * Create Time:2015/10/19 08:36
 */
public class ProductCategoryDTO {

    private Integer id;
    private Integer comId;
    private String pCategoryDesc;
    private String pCategoryName;
    private Integer pCategoryStatus;
    private Integer pCategoryParId;
    private String pCategoryParName;

    public String getpCategoryParName() {
		return pCategoryParName;
	}

	public void setpCategoryParName(String pCategoryParName) {
		this.pCategoryParName = pCategoryParName;
	}

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
