package com.zkh.guide.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zkh.guide.common.Mail;
import com.zkh.guide.common.MailUtils;
import com.zkh.guide.common.ValidateCode;
import com.zkh.guide.po.ChangeEmailQueryVo;
import com.zkh.guide.po.ChangePwdQueryVo;
import com.zkh.guide.po.ChangeUNameQueryVo;
import com.zkh.guide.po.ForgetQueryVo;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.LoginQueryVo;
import com.zkh.guide.po.RegisterQueryVo;
import com.zkh.guide.po.ResetPwdQueryVo;
import com.zkh.guide.service.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/Account/login", method = { RequestMethod.POST })
	public void login(HttpServletRequest request, HttpServletResponse response,
			@Validated LoginQueryVo loginQueryVo, BindingResult bindingResult)
			throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String vCode = session.getAttribute("vCode").toString();
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			String errormsg = "";
			for (ObjectError objectError : allErrors) {
				errormsg += objectError.getDefaultMessage();
			}
			response.getWriter().write("no:" + errormsg);
		} else if (vCode.equalsIgnoreCase(loginQueryVo.getVcode().trim())) {
			GuideUser user = userService.checkLogin(loginQueryVo);
			if (user != null) {
				session.setAttribute("login_user", user);
				response.getWriter().write("ok:登录成功");
			} else {
				response.getWriter().write("no:用户名或密码错误");
			}
		} else {
			response.getWriter().write("no:验证码错误");
		}
	}

	@RequestMapping("/Account/verifyImg")
	public void verifyImg(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession();

		ValidateCode vCode = new ValidateCode(120, 40, 4, 100);
		session.setAttribute("vCode", vCode.getCode());
		vCode.write(response.getOutputStream());
	}

	@RequestMapping(value = "/Account/register", method = { RequestMethod.POST })
	public void register(HttpServletRequest request,
			HttpServletResponse response,
			@Validated RegisterQueryVo registerQueryVo,
			BindingResult bindingResult) throws IOException, MessagingException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String vCode = session.getAttribute("vCode").toString();
		if (vCode.equalsIgnoreCase(registerQueryVo.getRegcode().trim())) {
			if (bindingResult.hasErrors()) {
				List<ObjectError> allErrors = bindingResult.getAllErrors();
				String errormsg = "";
				for (ObjectError objectError : allErrors) {
					errormsg += objectError.getDefaultMessage();
				}
				response.getWriter().write("no:" + errormsg);
			} else if (!registerQueryVo.getRegpwd().equalsIgnoreCase(
					registerQueryVo.getRregpwd())) {
				response.getWriter().write("no:两次密码输入不匹配。");
			} else if (userService.existedUser(registerQueryVo.getReguser()
					.trim())) {
				response.getWriter().write("no:用户名已存在。");
			} else if (userService.existedEmail(registerQueryVo.getRegemail()
					.trim())) {
				response.getWriter().write("no:邮箱已存在。");
			} else {
				userService.register(registerQueryVo);

				GuideUser user = userService.selectByUserName(registerQueryVo
						.getReguser());
				// 发送激活码
				Properties prop = new Properties();
				prop.load(this.getClass().getClassLoader()
						.getResourceAsStream("mail.properties"));
				String content = prop.getProperty("content");
				String msg = MessageFormat.format(content, user.getUserName(),
						user.getUserVerify());
				Session mailSession = MailUtils.createSession(
						prop.getProperty("host"), prop.getProperty("username"),
						prop.getProperty("password"));
				Mail mail = new Mail(prop.getProperty("from"),
						user.getUserEmail(), prop.getProperty("subject"), msg);
				MailUtils.send(mailSession, mail);

				response.getWriter().write("ok:注册成功。");
			}
		} else {
			response.getWriter().write("no:验证码错误");
		}
	}

	@RequestMapping(value = "/Account/checkUser", method = { RequestMethod.POST })
	public void checkUser(HttpServletResponse response, String username)
			throws IOException {
		if (!username.trim().isEmpty() && username != null) {
			response.getWriter()
					.write(userService.existedUser(username.trim()) ? "false"
							: "true");
		}
	}

	@RequestMapping(value = "/Account/checkEmail", method = { RequestMethod.POST })
	public void checkEmail(HttpServletResponse response, String email)
			throws IOException {
		if (!email.trim().isEmpty() && email != null) {
			response.getWriter().write(
					userService.existedEmail(email.trim()) ? "false" : "true");
		}

	}

	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("login_user", null);
		response.getWriter().write("ok");
	}

	@RequestMapping(value = "/Account/forgetPwd", method = { RequestMethod.POST })
	public void forgetPwd(HttpServletRequest request,
			HttpServletResponse response,
			@Validated ForgetQueryVo forgetQueryVo, BindingResult bindingResult)
			throws IOException, MessagingException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String vCode = session.getAttribute("vCode").toString();
		if (vCode.equalsIgnoreCase(forgetQueryVo.getFgcode().trim())) {
			if (bindingResult.hasErrors()) {
				List<ObjectError> allErrors = bindingResult.getAllErrors();
				String errormsg = "";
				for (ObjectError objectError : allErrors) {
					errormsg += objectError.getDefaultMessage();
				}
				response.getWriter().write("no:" + errormsg);
			} else if (userService.checkUserAndEmail(forgetQueryVo)) {

				GuideUser user = userService.selectByUserName(forgetQueryVo
						.getFgname());

				Properties prop = new Properties();
				prop.load(this.getClass().getClassLoader()
						.getResourceAsStream("mail.properties"));
				String content = prop.getProperty("forgetpwdcontent");
				String msg = MessageFormat.format(content, user.getUserName(),
						user.getUserVerify().substring(0,8));
				Session mailSession = MailUtils.createSession(
						prop.getProperty("host"), prop.getProperty("username"),
						prop.getProperty("password"));
				Mail mail = new Mail(prop.getProperty("from"),
						user.getUserEmail(), "密码重置", msg);
				MailUtils.send(mailSession, mail);
				response.getWriter().write("ok:" + user.getUserId());
			} else {
				response.getWriter().write("no:用户名和邮箱不匹配");
			}
		} else {
			response.getWriter().write("no:验证码错误");
		}
	}

	@RequestMapping(value = "/changePwd", method = { RequestMethod.POST })
	public void changePwd(HttpServletRequest request,
			HttpServletResponse response,
			@Validated ChangePwdQueryVo changePwdQueryVo,
			BindingResult bindingResult) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser) session.getAttribute("login_user");
		String vCode = session.getAttribute("vCode").toString();
		if (vCode.equalsIgnoreCase(changePwdQueryVo.getCode().trim())) {
			if (bindingResult.hasErrors()) {
				List<ObjectError> allErrors = bindingResult.getAllErrors();
				String errormsg = "";
				for (ObjectError objectError : allErrors) {
					errormsg += objectError.getDefaultMessage();
				}
				response.getWriter().write("no:" + errormsg);
			} else if (!changePwdQueryVo.getNewpwd().equalsIgnoreCase(
					changePwdQueryVo.getReppwd())) {
				response.getWriter().write("no:两次密码输入不匹配。");
			} else if (!changePwdQueryVo.getOldpwd().equalsIgnoreCase(
					user.getUserPwd())) {
				response.getWriter().write("no:原密码错误。");
			} else if (userService
					.changePwd(user, changePwdQueryVo.getNewpwd())) {
				user = userService.selectByPrimaryKey(user.getUserId());
				session.setAttribute("login_user", user);
				response.getWriter().write("ok:密码修改成功。");
			} else {
				response.getWriter().write("no:密码修改失败，请重试。");
			}
		} else {
			response.getWriter().write("no:验证码错误");
		}
	}

	@RequestMapping(value = "/Account/resetPwd", method = { RequestMethod.POST })
	public void resetPwd(HttpServletRequest request,
			HttpServletResponse response,
			@Validated ResetPwdQueryVo resetPwdQueryVo,
			BindingResult bindingResult) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			String errormsg = "";
			for (ObjectError objectError : allErrors) {
				errormsg += objectError.getDefaultMessage();
			}
			response.getWriter().write("no:" + errormsg);
		} else if (!resetPwdQueryVo.getFgnewpwd().trim()
				.equalsIgnoreCase(resetPwdQueryVo.getFgreppwd().trim())) {
			response.getWriter().write("no:两次密码输入不匹配");
		} else {
			GuideUser user = userService.selectByPrimaryKey(resetPwdQueryVo
					.getFguserid());

			if (user.getUserVerify().substring(0,8).equalsIgnoreCase(
					resetPwdQueryVo.getFgcode2().trim())) {
				user.setUserPwd(resetPwdQueryVo.getFgnewpwd());
				if (userService.changePwd(user, resetPwdQueryVo.getFgnewpwd())) {
					response.getWriter().write("ok:密码重置成功。");
				} else {
					response.getWriter().write("no:密码重置失败，请重试。");
				}
			} else {
				response.getWriter().write("no:验证码错误");
			}
		}
	}

	@RequestMapping(value = "/changeUser", method = { RequestMethod.POST })
	public void changeUser(HttpServletRequest request,
			HttpServletResponse response,
			@Validated ChangeUNameQueryVo changeUNameQueryVo,
			BindingResult bindingResult) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser) session.getAttribute("login_user");
		String vCode = session.getAttribute("vCode").toString();
		if (vCode.equalsIgnoreCase(changeUNameQueryVo.getUcode().trim())) {
			if (bindingResult.hasErrors()) {
				List<ObjectError> allErrors = bindingResult.getAllErrors();
				String errormsg = "";
				for (ObjectError objectError : allErrors) {
					errormsg += objectError.getDefaultMessage();
				}
				response.getWriter().write("no:" + errormsg);
			} else if (userService.existedUser(changeUNameQueryVo.getUname()
					.trim())) {
				response.getWriter().write("no:用户名已存在。");
			} else if (!changeUNameQueryVo.getUpwd().equalsIgnoreCase(
					user.getUserPwd())) {
				response.getWriter().write("no:密码错误");
			} else {
				user.setUserName(changeUNameQueryVo.getUname().trim());

				if (userService.changeUserName(user,
						changeUNameQueryVo.getUname())) {
					user = userService.selectByPrimaryKey(user.getUserId());
					session.setAttribute("login_user", user);
					response.getWriter().write("ok:用户名修改成功。");
				} else {
					response.getWriter().write("no:用户名修改失败，请重试。");
				}
			}
		} else {
			response.getWriter().write("no:验证码错误");
		}
	}

	@RequestMapping(value = "/changeEmail", method = { RequestMethod.POST })
	public void changeEmail(HttpServletRequest request,
			HttpServletResponse response,
			@Validated ChangeEmailQueryVo changeEmailQueryVo,
			BindingResult bindingResult) throws IOException, MessagingException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser) session.getAttribute("login_user");
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			String errormsg = "";
			for (ObjectError objectError : allErrors) {
				errormsg += objectError.getDefaultMessage();
			}
			response.getWriter().write("no:" + errormsg);
		} else if (userService
				.existedUser(changeEmailQueryVo.getEmail().trim())) {
			response.getWriter().write("no:用户名已存在。");
		} else if (!changeEmailQueryVo.getEpwd2().equalsIgnoreCase(
				user.getUserPwd())) {
			response.getWriter().write("no:密码错误");
		} else {
			if (userService.changeEmail(user, changeEmailQueryVo.getEmail()
					.trim())) {
				user = userService.selectByPrimaryKey(user.getUserId());
				session.setAttribute("login_user", user);

				// 发送激活邮件
				Properties prop = new Properties();
				prop.load(this.getClass().getClassLoader()
						.getResourceAsStream("mail.properties"));
				String content = prop.getProperty("content");
				String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/Account/activate.action?code="
						+ user.getUserVerify();
				String msg = MessageFormat.format(content, user.getUserName(),
						url);
				Session mailSession = MailUtils.createSession(
						prop.getProperty("host"), prop.getProperty("username"),
						prop.getProperty("password"));
				Mail mail = new Mail(prop.getProperty("from"),
						user.getUserEmail(), prop.getProperty("subject"), msg);

				response.getWriter().write("ok:" + user.getUserId());
				response.getWriter().write("ok:邮箱修改成功。");
			} else {
				response.getWriter().write("no:邮箱修改失败，请重试。");
			}
		}
	}

	@RequestMapping("/Account/activate")
	public ModelAndView activate(HttpServletRequest request,String code) throws IOException {

		ModelAndView model = new ModelAndView();
		model.setViewName("/info");
		if (userService.updateStateByVerify(code.trim())) {
			
			HttpSession session = request.getSession();
			GuideUser user = (GuideUser) session.getAttribute("login_user");
			if(user!=null){
				user = userService.selectByPrimaryKey(user.getUserId());
				session.setAttribute("login_user", user);
			}	
			
			model.addObject("info", "验证成功！");
		} else {
			model.addObject("info", "验证失败或已验证！");
		}
		return model;
	}

	@RequestMapping("/sendVerify")
	public void sendVerify(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		GuideUser user = (GuideUser) session.getAttribute("login_user");

		Properties prop = new Properties();
		prop.load(this.getClass().getClassLoader()
				.getResourceAsStream("mail.properties"));
		String content = prop.getProperty("content");
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/Account/activate.action?code="
				+ user.getUserVerify();
		String msg = MessageFormat.format(content, user.getUserName(), url);
		Session mailSession = MailUtils.createSession(prop.getProperty("host"),
				prop.getProperty("username"), prop.getProperty("password"));
		Mail mail = new Mail(prop.getProperty("from"), user.getUserEmail(),
				prop.getProperty("subject"), msg);

		try {
			MailUtils.send(mailSession, mail);
			response.getWriter().write("ok:激活邮件发送成功。");
		} catch (MessagingException e) {
			response.getWriter().write("no:激活邮件发送失败，请重试。");
		}
	}

}
