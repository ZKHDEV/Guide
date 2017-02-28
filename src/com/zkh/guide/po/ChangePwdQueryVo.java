package com.zkh.guide.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ChangePwdQueryVo {

	@NotNull(message="{changepwdqv.oldpwd.length.error}")
	private String oldpwd;
	@NotNull(message="{changepwdqv.newpwd.length.error}")
	@Pattern(regexp="^[A-Za-z0-9!#$%^&*.~_]{5,32}$",message="{changepwdqv.newpwd.pattern.error}")
	private String newpwd;
	@NotNull(message="{changepwdqv.reppwd.length.error}")
	private String reppwd;
	@NotNull(message="{changepwdqv.code.length.error}")
	private String code;
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getReppwd() {
		return reppwd;
	}
	public void setReppwd(String reppwd) {
		this.reppwd = reppwd;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
