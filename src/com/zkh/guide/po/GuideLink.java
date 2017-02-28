package com.zkh.guide.po;

public class GuideLink {
    private Integer linkId;

    private String linkTitle;

    private String linkDatetime;

    private Integer linkCategoryId;

    private Integer linkUserId;

    private Byte linkFavflag;

    private String linkModifiedon;

    private String linkUrl;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle == null ? null : linkTitle.trim();
    }

    public String getLinkDatetime() {
        return linkDatetime;
    }

    public void setLinkDatetime(String linkDatetime) {
        this.linkDatetime = linkDatetime == null ? null : linkDatetime.trim();
    }

    public Integer getLinkCategoryId() {
        return linkCategoryId;
    }

    public void setLinkCategoryId(Integer linkCategoryId) {
        this.linkCategoryId = linkCategoryId;
    }

    public Integer getLinkUserId() {
        return linkUserId;
    }

    public void setLinkUserId(Integer linkUserId) {
        this.linkUserId = linkUserId;
    }

    public Byte getLinkFavflag() {
        return linkFavflag;
    }

    public void setLinkFavflag(Byte linkFavflag) {
        this.linkFavflag = linkFavflag;
    }

    public String getLinkModifiedon() {
        return linkModifiedon;
    }

    public void setLinkModifiedon(String linkModifiedon) {
        this.linkModifiedon = linkModifiedon == null ? null : linkModifiedon.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }
}