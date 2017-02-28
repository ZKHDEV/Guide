package com.zkh.guide.service;

import com.zkh.guide.po.GuideExtuser;

public interface ExtuserService {

	public GuideExtuser selectByUserId(Integer id);
	
	public Boolean updateByUserId(GuideExtuser extuser, Integer userId);

	public Boolean uploadHeadByUserId(Integer userId, String extuserHead);
}
