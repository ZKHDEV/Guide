package com.zkh.guide.po;

public class GuideCategory {
    private Integer categoryId;

    private String categoryName;

    private Integer categoryUserId;

    private String categorySubtime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getCategoryUserId() {
        return categoryUserId;
    }

    public void setCategoryUserId(Integer categoryUserId) {
        this.categoryUserId = categoryUserId;
    }

    public String getCategorySubtime() {
        return categorySubtime;
    }

    public void setCategorySubtime(String categorySubtime) {
        this.categorySubtime = categorySubtime == null ? null : categorySubtime.trim();
    }
}