package com.cn.demo.pojo;

public class TCantact {
    private Integer conId;

    private String comId;

    private String conAddress;

    private String conCode;

    private String conEmail;

    private String conPage;

    private String conTel;

    private String conTelMan;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getConAddress() {
        return conAddress;
    }

    public void setConAddress(String conAddress) {
        this.conAddress = conAddress == null ? null : conAddress.trim();
    }

    public String getConCode() {
        return conCode;
    }

    public void setConCode(String conCode) {
        this.conCode = conCode == null ? null : conCode.trim();
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail == null ? null : conEmail.trim();
    }

    public String getConPage() {
        return conPage;
    }

    public void setConPage(String conPage) {
        this.conPage = conPage == null ? null : conPage.trim();
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel == null ? null : conTel.trim();
    }

    public String getConTelMan() {
        return conTelMan;
    }

    public void setConTelMan(String conTelMan) {
        this.conTelMan = conTelMan == null ? null : conTelMan.trim();
    }
}