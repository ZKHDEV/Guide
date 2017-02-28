package com.zkh.guide.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zkh.guide.po.GuideCategory;
import com.zkh.guide.po.GuideExtuser;
import com.zkh.guide.po.GuideLink;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.LoginQueryVo;
import com.zkh.guide.service.CategoryService;
import com.zkh.guide.service.ExtuserService;
import com.zkh.guide.service.LinkService;
import com.zkh.guide.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	@Autowired
	private ExtuserService extuserService;
	@Autowired
	private LinkService linkService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/index",method={RequestMethod.GET})
	public String index(Model model, HttpServletRequest request) throws IOException{
		
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(user != null){
			GuideExtuser extuser = extuserService.selectByUserId(user.getUserId());
			String user_head = extuser.getExtuserHead();
			List<GuideCategory> categories = categoryService.selectByUserId(user.getUserId());
			List<GuideLink> links = linkService.selectByUserId(user.getUserId());
			List<GuideLink> favlinks = linkService.selectFavByUserId(user.getUserId());
			model.addAttribute("user", user);
			model.addAttribute("extuser",extuser);
			model.addAttribute("categories",categories);
			model.addAttribute("links",links);
			model.addAttribute("favlinks",favlinks);
		}
		return "index/index";
	}
}
