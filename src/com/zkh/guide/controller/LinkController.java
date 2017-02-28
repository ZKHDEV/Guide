package com.zkh.guide.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkh.guide.po.AddLinkQueryVo;
import com.zkh.guide.po.ChangeLinkQueryVo;
import com.zkh.guide.po.GuideLink;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.User;
import com.zkh.guide.service.CategoryService;
import com.zkh.guide.service.LinkService;

@Controller
@RequestMapping("/Link")
public class LinkController {

	@Autowired
	private LinkService linkService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/deleteLink")
	public void deleteLink(HttpServletRequest request,HttpServletResponse response, Integer id) throws IOException{
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		linkService.delete(user.getUserId(),id);
		response.getWriter().write("ok");
	}
	
	@RequestMapping(value="/checkLink",method={RequestMethod.POST})
	public void checkLink(HttpServletRequest request, HttpServletResponse response,Integer category_id,String link_title) throws IOException{
		if(!link_title.trim().isEmpty() && link_title!=null){
			HttpSession session = request.getSession();
			GuideUser user = (GuideUser)session.getAttribute("login_user");
			response.getWriter().write(linkService.existedLink(category_id,user.getUserId(),link_title.trim())?"false":"true");
		}	
	}
	
	@RequestMapping(value="/checkLinkEcTitle",method={RequestMethod.POST})
	public void checkLinkEcTitle(HttpServletRequest request, HttpServletResponse response,Integer ulink_id,String ulink_title,Integer ulink_category) throws IOException{
		if(!ulink_title.trim().isEmpty() && ulink_title!=null && ulink_id!=null && ulink_category!=null){
			HttpSession session = request.getSession();
			GuideUser user = (GuideUser)session.getAttribute("login_user");
			response.getWriter().write(linkService.existedLinkEcTitle(ulink_category,user.getUserId(),ulink_title.trim(),ulink_id)?"false":"true");
		}	
	}
	
	@RequestMapping(value="/createLink",method={RequestMethod.POST})
	public void createLink(HttpServletRequest request, HttpServletResponse response, AddLinkQueryVo addLinkQueryVo,BindingResult bindingResult) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			String errormsg = "";
			for(ObjectError objectError:allErrors){
				errormsg += objectError.getDefaultMessage();
			}
			response.getWriter().write("no:"+errormsg);
		}else if(linkService.existedLink(addLinkQueryVo.getCategory_id(),user.getUserId(),addLinkQueryVo.getLink_title().trim())){
			response.getWriter().write("no:标题已存在。");
		}else if(linkService.insertByUserId(addLinkQueryVo,user.getUserId())){
			response.getWriter().write("ok:添加成功。");
		}else{
			response.getWriter().write("no:添加失败，请重试。");
		}
	}
	
	@RequestMapping(value="/updateLink",method={RequestMethod.POST})
	public void updateLink(HttpServletRequest request, HttpServletResponse response,ChangeLinkQueryVo changeLinkQueryVo,BindingResult bindingResult) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			String errormsg = "";
			for(ObjectError objectError:allErrors){
				errormsg += objectError.getDefaultMessage();
			}
			response.getWriter().write("no:"+errormsg);
		}else if(linkService.existedLinkEcTitle(changeLinkQueryVo.getUcategory_id(),user.getUserId(),changeLinkQueryVo.getUlink_title().trim(),changeLinkQueryVo.getUlink_id())){
			response.getWriter().write("no:标题已存在。");
		}else if(linkService.updateByLinkIdAndUserId(changeLinkQueryVo,user.getUserId())){
			response.getWriter().write("ok:修改成功。");
		}else{
			response.getWriter().write("no:修改失败，请重试。");
		}
	}
	
	
	@RequestMapping(value="/editLinkCategory",method={RequestMethod.POST})
	public void editLinkCategory(HttpServletRequest request, HttpServletResponse response,Integer elink_id,Integer ecategory_id) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(elink_id==null || ecategory_id==null){
			response.getWriter().write("no:收藏夹和链接必选。");
		}else if(linkService.existedLinkByCategory(elink_id,ecategory_id,user.getUserId())){
			response.getWriter().write("no:收藏夹已存在同名站点。");
		}else if(linkService.updateByCateIdAndLinkId(elink_id,ecategory_id,user.getUserId())){
			response.getWriter().write("ok:修改成功。");
		}else{
			response.getWriter().write("no:修改失败，请重试。");
		}
	}
	
	@RequestMapping(value="/addFavLink",method={RequestMethod.POST})
	public void addFavLink(HttpServletRequest request, HttpServletResponse response,Integer fcategory_id,Integer flink_id) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(fcategory_id==null || flink_id==null){
			response.getWriter().write("no:收藏夹和链接必选。");
		}else if(linkService.updateFavFlag(flink_id, (byte)1, user.getUserId())){
			response.getWriter().write("ok:添加成功。");
		}else{
			response.getWriter().write("no:添加失败，请重试。");
		}
	}
	
	@RequestMapping("/delFavLink")
	public void delFavLink(HttpServletRequest request, HttpServletResponse response,Integer id) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(id==null){
			response.getWriter().write("no:收藏夹和链接必选。");
		}else if(linkService.updateFavFlag(id, (byte)0, user.getUserId())){
			response.getWriter().write("ok:添加成功。");
		}else{
			response.getWriter().write("no:添加失败，请重试。");
		}
	}
	
	@RequestMapping("/getLinkByCate")
	public @ResponseBody List<GuideLink> getLinkByCate(HttpServletRequest request,Integer id){
		if(id!=null){
			HttpSession session = request.getSession();
			GuideUser user = (GuideUser)session.getAttribute("login_user");
			return linkService.selectLinkByCate(id, user.getUserId());
		}
		return null;
	}
	
}
