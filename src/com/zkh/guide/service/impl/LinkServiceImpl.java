package com.zkh.guide.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zkh.guide.mapper.GuideLinkMapper;
import com.zkh.guide.po.AddLinkQueryVo;
import com.zkh.guide.po.ChangeLinkQueryVo;
import com.zkh.guide.po.GuideCategory;
import com.zkh.guide.po.GuideCategoryExample;
import com.zkh.guide.po.GuideLink;
import com.zkh.guide.po.GuideLinkExample;
import com.zkh.guide.po.GuideUserExample;
import com.zkh.guide.service.LinkService;

public class LinkServiceImpl implements LinkService {

	@Autowired
	private GuideLinkMapper guideLinkMapper;
	
	@Override
	public List<GuideLink> selectByUserId(Integer id) {
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		guideLinkExample.setOrderByClause("link_modifiedon");
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkUserIdEqualTo(id);
		List<GuideLink> links = guideLinkMapper.selectByExampleWithBLOBs(guideLinkExample);
		return links;
	}

	@Override
	public List<GuideLink> selectFavByUserId(Integer id) {
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		guideLinkExample.setOrderByClause("link_modifiedon");
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkUserIdEqualTo(id);
		criteria.andLinkFavflagEqualTo((byte)1);
		List<GuideLink> links = guideLinkMapper.selectByExampleWithBLOBs(guideLinkExample);
		return links;
	}

	@Override
	public void delete(Integer userId, Integer linkId) {
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkIdEqualTo(linkId);
		criteria.andLinkUserIdEqualTo(userId);
		guideLinkMapper.deleteByExample(guideLinkExample);
	}

	@Override
	public Boolean existedLink(Integer categoryId, Integer userId,
			String linkTitle) {
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkCategoryIdEqualTo(categoryId);
		criteria.andLinkUserIdEqualTo(userId);
		criteria.andLinkTitleEqualTo(linkTitle);
		List<GuideLink> list = guideLinkMapper.selectByExample(guideLinkExample);
		return list.size() > 0;
	}

	@Override
	public Boolean existedLinkEcTitle(Integer linkCategoryId, Integer userId,
			String linkTitle, Integer linkId) {
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkCategoryIdEqualTo(linkCategoryId);
		criteria.andLinkUserIdEqualTo(userId);
		criteria.andLinkIdNotEqualTo(linkId);
		criteria.andLinkTitleEqualTo(linkTitle);
		List<GuideLink> list = guideLinkMapper.selectByExample(guideLinkExample);
		return list.size() > 0;
	}

	@Override
	public Boolean insertByUserId(AddLinkQueryVo addLinkQueryVo, Integer userId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuideLink link = new GuideLink();
		link.setLinkCategoryId(addLinkQueryVo.getCategory_id());
		link.setLinkDatetime(dateFormat.format(new Date()));
		link.setLinkFavflag((byte)0);
		link.setLinkModifiedon(dateFormat.format(new Date()));
		link.setLinkTitle(addLinkQueryVo.getLink_title().trim());
		link.setLinkUrl(addLinkQueryVo.getLink_url().trim());
		link.setLinkUserId(userId);
		
		return guideLinkMapper.insert(link) > 0;
	}

	@Override
	public Boolean updateByLinkIdAndUserId(ChangeLinkQueryVo changeLinkQueryVo,
			Integer userId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkIdEqualTo(changeLinkQueryVo.getUlink_id());
		criteria.andLinkUserIdEqualTo(userId);	
		List<GuideLink> list = guideLinkMapper.selectByExampleWithBLOBs(guideLinkExample);
		if(!(list.size()>0)){
			return false;
		}
		
		GuideLink link = list.get(0);
		link.setLinkModifiedon(dateFormat.format(new Date()));
		link.setLinkTitle(changeLinkQueryVo.getUlink_title().trim());
		link.setLinkUrl(changeLinkQueryVo.getUlink_url().trim());
		
		return guideLinkMapper.updateByPrimaryKeyWithBLOBs(link) > 0;
	}

	@Override
	public Boolean existedLinkByCategory(Integer linkId, Integer linkCategoryId, Integer userId) {
		GuideLink link = guideLinkMapper.selectByPrimaryKey(linkId);
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkCategoryIdEqualTo(linkCategoryId);
		criteria.andLinkUserIdEqualTo(userId);
		criteria.andLinkTitleEqualTo(link.getLinkTitle());
		List<GuideLink> list = guideLinkMapper.selectByExample(guideLinkExample);
		return list.size() > 0;
	}

	@Override
	public Boolean updateByCateIdAndLinkId(Integer linkId, Integer linkCategoryId,
			Integer userId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkIdEqualTo(linkId);
		criteria.andLinkUserIdEqualTo(userId);	
		List<GuideLink> list = guideLinkMapper.selectByExampleWithBLOBs(guideLinkExample);
		if(!(list.size()>0)){
			return false;
		}
		
		GuideLink link = list.get(0);
		link.setLinkModifiedon(dateFormat.format(new Date()));
		link.setLinkCategoryId(linkCategoryId);
		
		return guideLinkMapper.updateByPrimaryKeyWithBLOBs(link) > 0;
	}

	@Override
	public Boolean updateFavFlag(Integer linkId, Byte linkFavflag,
			Integer userId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkIdEqualTo(linkId);
		criteria.andLinkUserIdEqualTo(userId);	
		List<GuideLink> list = guideLinkMapper.selectByExampleWithBLOBs(guideLinkExample);
		if(!(list.size()>0)){
			return false;
		}
		
		GuideLink link = list.get(0);
		link.setLinkModifiedon(dateFormat.format(new Date()));
		link.setLinkFavflag(linkFavflag);
		
		return guideLinkMapper.updateByPrimaryKeyWithBLOBs(link) > 0;
	}

	@Override
	public List<GuideLink> selectLinkByCate(Integer linkCategoryId,
			Integer userId) {
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria = guideLinkExample.createCriteria();
		criteria.andLinkCategoryIdEqualTo(linkCategoryId);
		criteria.andLinkUserIdEqualTo(userId);
		return guideLinkMapper.selectByExampleWithBLOBs(guideLinkExample);
	}

}
