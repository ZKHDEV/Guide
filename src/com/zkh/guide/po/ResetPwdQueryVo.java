package com.zkh.guide.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ResetPwdQueryVo {

	@NotNull(message="{resetpwdqv.fguserid.length.error}")
	private Integer fguserid;
	@NotNull(message="{resetpwdqv.fgnewpwd.length.error}")
	@Pattern(regexp="^[A-Za-z0-9!#$%^&*.~_]{5,32}$",message="{resetpwdqv.newpwd.pattern.error}")
	private String fgnewpwd;
	@NotNull(message="{resetpwdqv.fgreppwd.length.error}")
	private String fgreppwd;
	@NotNull(message="{resetpwdqv.fgcode2.length.error}")
	private String fgcode2;
	public Integer getFguserid() {
		return fguserid;
	}
	public void setFguserid(Integer fguserid) {
		this.fguserid = fguserid;
	}
	public String getFgnewpwd() {
		return fgnewpwd;
	}
	public void setFgnewpwd(String fgnewpwd) {
		this.fgnewpwd = fgnewpwd;
	}
	public String getFgreppwd() {
		return fgreppwd;
	}
	public void setFgreppwd(String fgreppwd) {
		this.fgreppwd = fgreppwd;
	}
	public String getFgcode2() {
		return fgcode2;
	}
	public void setFgcode2(String fgcode2) {
		this.fgcode2 = fgcode2;
	}
	
}
