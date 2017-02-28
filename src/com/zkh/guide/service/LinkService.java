package com.zkh.guide.service;

import java.util.List;

import com.zkh.guide.po.AddLinkQueryVo;
import com.zkh.guide.po.ChangeLinkQueryVo;
import com.zkh.guide.po.GuideLink;

public interface LinkService {

	public List<GuideLink> selectByUserId(Integer id);
	public List<GuideLink> selectFavByUserId(Integer id);
	public void delete(Integer userId, Integer linkId);
	public Boolean existedLink(Integer categoryId, Integer userId, String linkTitle);
	public Boolean existedLinkEcTitle(Integer linkCategoryId, Integer userId,String linkTitle,Integer linkId);
	public Boolean insertByUserId(AddLinkQueryVo addLinkQueryVo, Integer userId);
	public Boolean updateByLinkIdAndUserId(ChangeLinkQueryVo changeLinkQueryVo, Integer userId);
	public Boolean existedLinkByCategory(Integer linkId, Integer linkCategoryId, Integer userId);
	public Boolean updateByCateIdAndLinkId(Integer linkId, Integer linkCategoryId, Integer userId);
	public Boolean updateFavFlag(Integer linkId, Byte linkFavflag, Integer userId);
	public List<GuideLink> selectLinkByCate(Integer linkCategoryId, Integer userId);
}
