package com.zkh.guide.po;

public class GuideUser {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userEmail;

    private String userSubtime;

    private String userModifiedon;

    private Byte userState;

    private String userVerify;

    

	public String getUserSubtime() {
		return userSubtime;
	}

	public void setUserSubtime(String userSubtime) {
		this.userSubtime = userSubtime == null ? null : userSubtime.trim();
	}

	public String getUserModifiedon() {
		return userModifiedon;
	}

	public void setUserModifiedon(String userModifiedon) {
		this.userModifiedon = userModifiedon == null ? null : userModifiedon.trim();
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Byte getUserState() {
        return userState;
    }

    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    public String getUserVerify() {
        return userVerify;
    }

    public void setUserVerify(String userVerify) {
        this.userVerify = userVerify == null ? null : userVerify.trim();
    }
}