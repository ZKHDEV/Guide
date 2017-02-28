package com.zkh.guide.po;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginQueryVo {

	@NotNull(message="{loginqv.username.length.error}")
	@Pattern(regexp="^[a-zA-Z0-9_]{5,45}$",message="{loginqv.username.pattern.error}")
	private String username;
	@NotNull(message="{loginqv.password.length.error}")
	@Pattern(regexp="^[A-Za-z0-9!#$%^&*.~_]{5,32}$",message="{loginqv.password.pattern.error}")
	private String password;
	@NotNull(message="{loginqv.vcode.length.error}")
	private String vcode;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	
}
