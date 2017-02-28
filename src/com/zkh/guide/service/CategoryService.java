package com.zkh.guide.service;

import java.util.List;

import com.zkh.guide.po.GuideCategory;

public interface CategoryService {

	public List<GuideCategory> selectByUserId(Integer id);

	public Boolean existedCategory(String category, Integer userId);

	public Boolean insert(Integer userId, String categoryName);

	public void delete(Integer userId, Integer categoryId);

	public Boolean updateByCateIdAndUserId(String categoryName, Integer categoryId, Integer userId);

	public Boolean existedCateEcTitle(Integer categoryId, String categoryName, Integer userId);


}
