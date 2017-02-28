package com.zkh.guide.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class ChangeEmailQueryVo {

	@NotNull(message="{changeemailqv.epwd2.length.error}")
	@Pattern(regexp="^[A-Za-z0-9!#$%^&*.~_]{5,32}$",message="{changeemailqv.epwd2.pattern.error}")
	private String epwd2;
	@NotNull(message="{changeemailqv.email.length.error}")
	@Email(message="{changeemailqv.email.pattern.error}")
	private String email;
	@NotNull(message="{changeemailqv.ecode.length.error}")
	private String ecode;
	
	public String getEpwd2() {
		return epwd2;
	}
	public void setEpwd2(String epwd2) {
		this.epwd2 = epwd2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	
	
}
