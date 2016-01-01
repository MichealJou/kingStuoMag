package com.cn.demo.pojo;

public class TProGroupWithBLOBs extends TProGroup {
    private String proCategoryDesc;

    private String proCategoryName;
    
    
    private String pCategoryParName;


	public String getProCategoryDesc() {
		return proCategoryDesc;
	}


	public void setProCategoryDesc(String proCategoryDesc) {
		this.proCategoryDesc = proCategoryDesc;
	}


	public String getProCategoryName() {
		return proCategoryName;
	}


	public void setProCategoryName(String proCategoryName) {
		this.proCategoryName = proCategoryName;
	}


	public String getpCategoryParName() {
		return pCategoryParName;
	}


	public void setpCategoryParName(String pCategoryParName) {
		this.pCategoryParName = pCategoryParName;
	}

/*    public String getProCategoryDesc() {
        return proCategoryDesc;
    }

    public void setProCategoryDesc(String proCategoryDesc) {
        this.proCategoryDesc = proCategoryDesc == null ? null : proCategoryDesc.trim();
    }

    public String getProCategoryName() {
        return proCategoryName;
    }

    public void setProCategoryName(String proCategoryName) {
        this.proCategoryName = proCategoryName == null ? null : proCategoryName.trim();
    }
    
    public String getPCategoryParName() {
    	return pCategoryParName;
    }
    
    public void setPCategoryParName(String pCategoryParName) {
    	this.pCategoryParName = pCategoryParName == null ? null : pCategoryParName.trim();
    }
*/
    

}