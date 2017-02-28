package com.zkh.guide.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ChangeUNameQueryVo {

	@NotNull(message="{changeunameqv.uname.length.error}")
	@Pattern(regexp="^[a-zA-Z0-9_]{5,45}$",message="{changeunameqv.uname.pattern.error}")
	private String uname;
	@NotNull(message="{changeunameqv.upwd.length.error}")
	@Pattern(regexp="^[A-Za-z0-9!#$%^&*.~_]{5,32}$",message="{changeunameqv.upwd.pattern.error}")
	private String upwd;
	@NotNull(message="{changeunameqv.ucode.length.error}")
	private String ucode;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUcode() {
		return ucode;
	}
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}
	
}
