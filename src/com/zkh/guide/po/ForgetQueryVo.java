package com.zkh.guide.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class ForgetQueryVo {

	@NotNull(message="{forgetqv.fgname.length.error}")
	@Pattern(regexp="^[a-zA-Z0-9_]{5,45}$",message="{forgetqv.fgname.pattern.error}")
	private String fgname;
	@NotNull(message="{forgetqv.fgemail.length.error}")
	@Email(message="{forgetqv.fgemail.pattern.error}")
	private String fgemail;
	@NotNull(message="{forgetqv.fgcode.length.error}")
	private String fgcode;
	public String getFgname() {
		return fgname;
	}
	public void setFgname(String fgname) {
		this.fgname = fgname;
	}
	public String getFgemail() {
		return fgemail;
	}
	public void setFgemail(String fgemail) {
		this.fgemail = fgemail;
	}
	public String getFgcode() {
		return fgcode;
	}
	public void setFgcode(String fgcode) {
		this.fgcode = fgcode;
	}
	
}
