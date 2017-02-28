package com.zkh.guide.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zkh.guide.mapper.GuideCategoryMapper;
import com.zkh.guide.mapper.GuideExtuserMapper;
import com.zkh.guide.mapper.GuideLinkMapper;
import com.zkh.guide.po.GuideCategory;
import com.zkh.guide.po.GuideCategoryExample;
import com.zkh.guide.po.GuideExtuser;
import com.zkh.guide.po.GuideExtuserExample;
import com.zkh.guide.po.GuideLinkExample;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.GuideUserExample;
import com.zkh.guide.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private GuideCategoryMapper guideCategoryMapper;
	
	@Autowired
	private GuideLinkMapper guideLinkMapper;
	
	@Override
	public List<GuideCategory> selectByUserId(Integer id) {
		GuideCategoryExample guideCategoryExample = new GuideCategoryExample();
		guideCategoryExample.setOrderByClause("category_subtime");
		GuideCategoryExample.Criteria criteria = guideCategoryExample.createCriteria();
		criteria.andCategoryUserIdEqualTo(id);
		List<GuideCategory> links = guideCategoryMapper.selectByExample(guideCategoryExample);
		return links;
	}

	@Override
	public Boolean existedCategory(String category, Integer userId) {
		GuideCategoryExample guideCategoryExample = new GuideCategoryExample();
		GuideCategoryExample.Criteria criteria = guideCategoryExample.createCriteria();
		criteria.andCategoryNameEqualTo(category);
		criteria.andCategoryUserIdEqualTo(userId);
		List<GuideCategory> list = guideCategoryMapper.selectByExample(guideCategoryExample);
		return list.size() > 0;
	}

	@Override
	public Boolean insert(Integer userId, String categoryName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuideCategory category = new GuideCategory();
		category.setCategoryName(categoryName);
		category.setCategoryUserId(userId);
		category.setCategorySubtime(dateFormat.format(new Date()));
		return guideCategoryMapper.insert(category) > 0;
	}

	@Override
	public void delete(Integer userId, Integer categoryId) {
		GuideCategoryExample guideCategoryExample = new GuideCategoryExample();
		GuideCategoryExample.Criteria criteria = guideCategoryExample.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		criteria.andCategoryUserIdEqualTo(userId);
		guideCategoryMapper.deleteByExample(guideCategoryExample);
		
		GuideLinkExample guideLinkExample = new GuideLinkExample();
		GuideLinkExample.Criteria criteria2 = guideLinkExample.createCriteria();
		criteria2.andLinkCategoryIdEqualTo(categoryId);
		criteria2.andLinkUserIdEqualTo(userId);
		guideLinkMapper.deleteByExample(guideLinkExample);
	}

	@Override
	public Boolean updateByCateIdAndUserId(String categoryName,
			Integer categoryId, Integer userId) {
		GuideCategory category = new GuideCategory();
		category.setCategoryName(categoryName);
		category.setCategoryUserId(userId);
		category.setCategoryId(categoryId);
		return guideCategoryMapper.updateByPrimaryKey(category) > 0;
	}

	@Override
	public Boolean existedCateEcTitle(Integer categoryId, String categoryName, Integer userId) {
		GuideCategoryExample guideCategoryExample = new GuideCategoryExample();
		GuideCategoryExample.Criteria criteria = guideCategoryExample.createCriteria();
		criteria.andCategoryIdNotEqualTo(categoryId);
		criteria.andCategoryUserIdEqualTo(userId);
		criteria.andCategoryNameEqualTo(categoryName);
		List<GuideCategory> list = guideCategoryMapper.selectByExample(guideCategoryExample);
		return list.size() > 0;
	}

}
