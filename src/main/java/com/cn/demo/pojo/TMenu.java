package com.cn.demo.pojo;

public class TMenu {
    private Integer id;

    private String comId;

    private String tLink;

    private String tMenuName;

    private Integer tParentId;

    private Integer tSort;

    private String tType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String gettLink() {
        return tLink;
    }

    public void settLink(String tLink) {
        this.tLink = tLink == null ? null : tLink.trim();
    }

    public String gettMenuName() {
        return tMenuName;
    }

    public void settMenuName(String tMenuName) {
        this.tMenuName = tMenuName == null ? null : tMenuName.trim();
    }

    public Integer gettParentId() {
        return tParentId;
    }

    public void settParentId(Integer tParentId) {
        this.tParentId = tParentId;
    }

    public Integer gettSort() {
        return tSort;
    }

    public void settSort(Integer tSort) {
        this.tSort = tSort;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType == null ? null : tType.trim();
    }
}