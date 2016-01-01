package com.cn.demo.pojo;

public class TIntroduction {
    private Integer intrId;

    private String comId;

    private String intrIdea;

    private String intrContent;

    private String intrPurpose;

    private String intrSlogan;

    private String instrTerget;

    public Integer getIntrId() {
        return intrId;
    }

    public void setIntrId(Integer intrId) {
        this.intrId = intrId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getIntrIdea() {
        return intrIdea;
    }

    public void setIntrIdea(String intrIdea) {
        this.intrIdea = intrIdea == null ? null : intrIdea.trim();
    }

    public String getIntrContent() {
        return intrContent;
    }

    public void setIntrContent(String intrContent) {
        this.intrContent = intrContent == null ? null : intrContent.trim();
    }

    public String getIntrPurpose() {
        return intrPurpose;
    }

    public void setIntrPurpose(String intrPurpose) {
        this.intrPurpose = intrPurpose == null ? null : intrPurpose.trim();
    }

    public String getIntrSlogan() {
        return intrSlogan;
    }

    public void setIntrSlogan(String intrSlogan) {
        this.intrSlogan = intrSlogan == null ? null : intrSlogan.trim();
    }

    public String getInstrTerget() {
        return instrTerget;
    }

    public void setInstrTerget(String instrTerget) {
        this.instrTerget = instrTerget == null ? null : instrTerget.trim();
    }
}