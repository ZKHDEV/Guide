package com.zkh.guide.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zkh.guide.po.GuideUser;
import com.zkh.guide.service.CategoryService;

@Controller
@RequestMapping("/Category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/checkCategory",method={RequestMethod.POST})
	public void checkCategory(HttpServletRequest request, HttpServletResponse response,String category) throws IOException{
		if(!category.trim().isEmpty() && category!=null){
			HttpSession session = request.getSession();
			GuideUser user = (GuideUser)session.getAttribute("login_user");
			response.getWriter().write(categoryService.existedCategory(category.trim(),user.getUserId())?"false":"true");
		}
		
	}
	
	@RequestMapping(value="/updateCategory",method={RequestMethod.POST})
	public void updateCategory(HttpServletRequest request, HttpServletResponse response,String ucategory,Integer ucategory_id) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(ucategory.trim().isEmpty() || ucategory==null){
			response.getWriter().write("no:收藏夹名必填。");
		}else if(ucategory_id==null){
			response.getWriter().write("no:ucategory_id必填。");
		}else if(categoryService.existedCategory(ucategory.trim(),user.getUserId())){
			response.getWriter().write("no:收藏夹已存在。");
		}else if(categoryService.updateByCateIdAndUserId(ucategory.trim(),ucategory_id,user.getUserId())){
			response.getWriter().write("ok:修改成功。");
		}else{
			response.getWriter().write("no:修改失败，请重试。");
		}
	}
	
	@RequestMapping(value="/createCategory",method={RequestMethod.POST})
	public void createCategory(HttpServletRequest request, HttpServletResponse response,String category) throws IOException{	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		
		if(!categoryService.existedCategory(category.trim(),user.getUserId())){
			if(categoryService.insert(user.getUserId(),category.trim())){
				response.getWriter().write("ok:添加成功。");
			}else{
				response.getWriter().write("no:添加失败，请重试。");
			}
		}else{
			response.getWriter().write("no:收藏夹已存在。");
		}
	}
	
	@RequestMapping("/deleteCategory")
	public void deleteCategory(HttpServletRequest request,HttpServletResponse response, Integer id) throws IOException{	
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		categoryService.delete(user.getUserId(),id);
		response.getWriter().write("ok");
	}
	
	@RequestMapping(value="/checkCateEcName",method={RequestMethod.POST})
	public void checkCateEcName(HttpServletRequest request, HttpServletResponse response,Integer ucategory_id,String ucategory) throws IOException{
		if(!ucategory.trim().isEmpty() && ucategory!=null && ucategory_id!=null){
			HttpSession session = request.getSession();
			GuideUser user = (GuideUser)session.getAttribute("login_user");
			response.getWriter().write(categoryService.existedCateEcTitle(ucategory_id,ucategory.trim(),user.getUserId())?"false":"true");
		}	
	}
}
