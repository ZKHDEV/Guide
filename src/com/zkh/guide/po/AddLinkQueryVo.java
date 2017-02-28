package com.zkh.guide.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class AddLinkQueryVo {

	@NotNull(message="{addlinkqv.category_id.length.error}")
	private Integer category_id;
	@NotNull(message="{addlinkqv.link_title.length.error}")
	private String link_title;
	@NotNull(message="{addlinkqv.link_url.length.error}")
	@URL(message="{addlinkqv.link_url.pattern.error}")
	private String link_url;
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getLink_title() {
		return link_title;
	}
	public void setLink_title(String link_title) {
		this.link_title = link_title;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	
}
