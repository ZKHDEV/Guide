package com.zkh.guide.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zkh.guide.common.ImageHelper;
import com.zkh.guide.po.GuideExtuser;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.HeadImg;
import com.zkh.guide.service.ExtuserService;

@Controller
public class UserController {

	@Autowired
	private ExtuserService extuserService;
	
	@RequestMapping("/user")
	public String index(Model model,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		if(user != null){
			GuideExtuser extuser = extuserService.selectByUserId(user.getUserId());
			String user_head = extuser.getExtuserHead();
			model.addAttribute("user", user);
			model.addAttribute("extuser",extuser);
		}
		
		return "user/index";
	}
	
	@RequestMapping("/updateUser")
	public void update(Model model,HttpServletRequest request, HttpServletResponse response,
			GuideExtuser extuser) throws IOException{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		Integer userId = user.getUserId();
		if(extuserService.updateByUserId(extuser, userId)){
			response.getWriter().write("ok:修改成功。");
		}else{
			response.getWriter().write("no:修改失败，请重试。");
		}
	}
	
	@RequestMapping("/User/uploadImg")
	public @ResponseBody Map<String,String> uploadImg(HttpServletRequest request,
		 @RequestParam(value="Filedata",required=true) MultipartFile file) throws IOException{
		
		Map<String,String> uploadResult = new HashMap<String,String>();
		
		if(file != null){
			String path = null;
			String type = null;
			String fileName = file.getOriginalFilename();
			type = fileName.indexOf(".")!=-1 ? fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()) : null;

			
			if(type!=null){
				if("JPG".equalsIgnoreCase(type)){
					
					String realPath = request.getSession().getServletContext().getRealPath("/")+"upload/Avatar/";
					String trueFileName = String.valueOf(System.currentTimeMillis())+fileName.substring(0,fileName.lastIndexOf("."))+".jpg";
					path = realPath+trueFileName;
					file.transferTo(new File(path));
					
					String webPath = request.getContextPath()+"/upload/Avatar/";
					
					uploadResult.put("status", "1");
					uploadResult.put("path", webPath + trueFileName);	
					
				}else if(file.getSize() > 1000000L){
					uploadResult.put("status", "0");
					uploadResult.put("info", "文件须小于1MB！");	
				}else{
					uploadResult.put("status", "0");
					uploadResult.put("info", "文件类型错误！");	
				}
			}else{
				uploadResult.put("status", "0");
				uploadResult.put("info", "文件类型错误！");	
			}		
		}else{
			uploadResult.put("status", "0");
			uploadResult.put("info", "文件不能为空！");	
		}
		
		return uploadResult;	
	}
	
	@RequestMapping("/User/cropImg")
	public void cropImg(HttpServletRequest request,HttpServletResponse response, HeadImg headImg) throws IOException{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser)session.getAttribute("login_user");
		
		String path = headImg.getSrc();
		String upload_path = request.getSession().getServletContext().getRealPath("/") + "upload\\Avatar\\";
		
		String src_file_name = path.substring(path.lastIndexOf("/")+1);
		String new_file_name = String.valueOf(System.currentTimeMillis()) + src_file_name;
		
		Integer x = Integer.parseInt(headImg.getX().lastIndexOf(".")==-1?headImg.getX():headImg.getX().substring(0,headImg.getX().lastIndexOf(".")));
		Integer y = Integer.parseInt(headImg.getY().lastIndexOf(".")==-1?headImg.getY():headImg.getY().substring(0,headImg.getY().lastIndexOf(".")));
		Integer w = Integer.parseInt(headImg.getW().lastIndexOf(".")==-1?headImg.getW():headImg.getW().substring(0,headImg.getW().lastIndexOf(".")));
		Integer h = Integer.parseInt(headImg.getH().lastIndexOf(".")==-1?headImg.getH():headImg.getH().substring(0,headImg.getH().lastIndexOf(".")));
		
		try {
			ImageHelper.cutImage(upload_path + src_file_name, upload_path + new_file_name, x, y, w, h);
		} catch (IOException e) {
			response.getWriter().write("no:头像修改失败，请重试。");
			return;
		}
		
		if(extuserService.uploadHeadByUserId(user.getUserId(),new_file_name)){
			response.getWriter().write("ok:头像修改成功。");	
		}else{
			response.getWriter().write("no:头像修改失败，请重试。");
		}
	}
}