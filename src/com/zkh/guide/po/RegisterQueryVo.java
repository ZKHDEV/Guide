package com.zkh.guide.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class RegisterQueryVo {

	@NotNull(message="{registerqv.reguser.length.error}")
	@Pattern(regexp="^[a-zA-Z0-9_]{5,45}$",message="{registerqv.reguser.pattern.error}")
	private String reguser;
	@NotNull(message="{registerqv.regpwd.length.error}")
	@Pattern(regexp="^[A-Za-z0-9!#$%^&*.~_]{5,32}$",message="{registerqv.regpwd.pattern.error}")
	private String regpwd;
	@NotNull(message="{registerqv.rregpwd.length.error}")
	private String rregpwd;
	@NotNull(message="{registerqv.regemail.length.error}")
	@Email(message="{registerqv.regemail.pattern.error}")
	private String regemail;
	private String regcode;
	public String getReguser() {
		return reguser;
	}
	public void setReguser(String reguser) {
		this.reguser = reguser;
	}
	public String getRegpwd() {
		return regpwd;
	}
	public void setRegpwd(String regpwd) {
		this.regpwd = regpwd;
	}
	public String getRregpwd() {
		return rregpwd;
	}
	public void setRregpwd(String rregpwd) {
		this.rregpwd = rregpwd;
	}
	public String getRegemail() {
		return regemail;
	}
	public void setRegemail(String regemail) {
		this.regemail = regemail;
	}
	public String getRegcode() {
		return regcode;
	}
	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}
	
	
}
