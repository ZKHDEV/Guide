package com.zkh.guide.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

public class ChangeLinkQueryVo {

	@NotNull(message="{changelinkqv.ulink_id.length.error}")
	private Integer ulink_id;
	@NotNull(message="{changelinkqv.ucategory_id.length.error}")
	private Integer ucategory_id;
	@NotNull(message="{changelinkqv.ulink_title.length.error}")
	private String ulink_title;
	@NotNull(message="{changelinkqv.ulink_url.length.error}")
	@URL(message="{changelinkqv.ulink_url.pattern.error}")
	private String ulink_url;
	public Integer getUlink_id() {
		return ulink_id;
	}
	public void setUlink_id(Integer ulink_id) {
		this.ulink_id = ulink_id;
	}
	public Integer getUcategory_id() {
		return ucategory_id;
	}
	public void setUcategory_id(Integer ucategory_id) {
		this.ucategory_id = ucategory_id;
	}
	public String getUlink_title() {
		return ulink_title;
	}
	public void setUlink_title(String ulink_title) {
		this.ulink_title = ulink_title;
	}
	public String getUlink_url() {
		return ulink_url;
	}
	public void setUlink_url(String ulink_url) {
		this.ulink_url = ulink_url;
	}
	
}
