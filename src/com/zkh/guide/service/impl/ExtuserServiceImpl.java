package com.zkh.guide.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zkh.guide.mapper.GuideExtuserMapper;
import com.zkh.guide.mapper.GuideLinkMapper;
import com.zkh.guide.po.GuideExtuser;
import com.zkh.guide.po.GuideExtuserExample;
import com.zkh.guide.po.GuideLink;
import com.zkh.guide.po.GuideLinkExample;
import com.zkh.guide.service.ExtuserService;

public class ExtuserServiceImpl implements ExtuserService {

	@Autowired
	private GuideExtuserMapper guideExtuserMapper;
	
	@Override
	public GuideExtuser selectByUserId(Integer id) {
		GuideExtuserExample guideExtuserExample = new GuideExtuserExample();
		GuideExtuserExample.Criteria criteria = guideExtuserExample.createCriteria();
		criteria.andExtuserUserIdEqualTo(id);
		List<GuideExtuser> users = guideExtuserMapper.selectByExample(guideExtuserExample);
		return users.get(0);
	}
	

	@Override
	public Boolean updateByUserId(GuideExtuser extuser, Integer userId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		GuideExtuserExample guideExtuserExample = new GuideExtuserExample();
		GuideExtuserExample.Criteria criteria = guideExtuserExample.createCriteria();
		criteria.andExtuserUserIdEqualTo(userId);
		criteria.andExtuserIdEqualTo(extuser.getExtuserId());
		List<GuideExtuser> users = guideExtuserMapper.selectByExample(guideExtuserExample);
		if(!(users.size()>0)){
			return false;
		}

		extuser.setExtuserModifiedon(dateFormat.format(new Date()));
		extuser.setExtuserUserId(userId);
		return guideExtuserMapper.updateByPrimaryKey(extuser) > 0;
	}


	@Override
	public Boolean uploadHeadByUserId(Integer userId, String extuserHead) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		GuideExtuserExample guideExtuserExample = new GuideExtuserExample();
		GuideExtuserExample.Criteria criteria = guideExtuserExample.createCriteria();
		criteria.andExtuserUserIdEqualTo(userId);
		List<GuideExtuser> users = guideExtuserMapper.selectByExample(guideExtuserExample);
		if(!(users.size()>0)){
			return false;
		}
		
		GuideExtuser extuser = users.get(0);
		extuser.setExtuserModifiedon(dateFormat.format(new Date()));
		extuser.setExtuserHead(extuserHead);
		return guideExtuserMapper.updateByPrimaryKey(extuser) > 0;
	}

}
