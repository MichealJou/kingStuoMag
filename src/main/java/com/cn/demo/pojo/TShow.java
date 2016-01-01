package com.cn.demo.pojo;

public class TShow {
    private Integer showId;

    private Integer comId;

    private Integer showDel;

    private Integer showPicOrder;

    private String showPicText;

    private String showPicUrlPath;

    private String tShowPicName;

    private String showPicPath;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getShowDel() {
        return showDel;
    }

    public void setShowDel(Integer showDel) {
        this.showDel = showDel;
    }

    public Integer getShowPicOrder() {
        return showPicOrder;
    }

    public void setShowPicOrder(Integer showPicOrder) {
        this.showPicOrder = showPicOrder;
    }

    public String getShowPicText() {
        return showPicText;
    }

    public void setShowPicText(String showPicText) {
        this.showPicText = showPicText == null ? null : showPicText.trim();
    }

    public String getShowPicUrlPath() {
        return showPicUrlPath;
    }

    public void setShowPicUrlPath(String showPicUrlPath) {
        this.showPicUrlPath = showPicUrlPath == null ? null : showPicUrlPath.trim();
    }

    public String gettShowPicName() {
        return tShowPicName;
    }

    public void settShowPicName(String tShowPicName) {
        this.tShowPicName = tShowPicName == null ? null : tShowPicName.trim();
    }

    public String getShowPicPath() {
        return showPicPath;
    }

    public void setShowPicPath(String showPicPath) {
        this.showPicPath = showPicPath == null ? null : showPicPath.trim();
    }
}