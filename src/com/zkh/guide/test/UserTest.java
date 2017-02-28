package com.zkh.guide.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zkh.guide.common.ImageHelper;
import com.zkh.guide.mapper.GuideUserMapper;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.GuideUserExample;
import com.zkh.guide.po.LoginQueryVo;
import com.zkh.guide.service.UserService;
import com.zkh.guide.service.impl.UserServiceImpl;

public class UserTest {

	private ApplicationContext applicationContext;
	private ApplicationContext applicationContext2;
	
	private GuideUserMapper guideUserMapper;
	private UserService userService;
	
	@Before
	public void setUp(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		applicationContext2 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
		guideUserMapper = (GuideUserMapper)applicationContext.getBean("guideUserMapper");
		userService = (UserService)applicationContext2.getBean("userService");
	}
	
	@Test
	public void testLogin(){
		LoginQueryVo loginQueryVo = new LoginQueryVo();
		loginQueryVo.setUsername("zkh101");
		loginQueryVo.setPassword("dd8abc5536c14ee3463705f14aa60998");
		
		System.out.println(userService.checkLogin(loginQueryVo));
		System.out.println("Done");
	}
	
	@Test
	public void testCreat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuideUser user = new GuideUser();
		user.setUserEmail("abc5@abc.com");
		user.setUserModifiedon(dateFormat.format(new Date()));
		user.setUserName("abc5");
		user.setUserPwd("123");
		user.setUserState((byte) 0);
		user.setUserSubtime(dateFormat.format(new Date()));
		user.setUserVerify("12345");
		guideUserMapper.insert(user);
		Integer id = user.getUserId();
		GuideUser user2 = user;
	}
	
	@Test
	public void testCutImg() throws IOException{
		String srcPath = "D:\\Program_Files\\apache-tomcat-8.5.8\\webapps\\Guide\\upload\\Avatar\\3.jpg";
		String subPath = "D:\\Program_Files\\apache-tomcat-8.5.8\\webapps\\Guide\\upload\\Avatar\\4.jpg";
		System.out.println("Done");
		ImageHelper.cutCenterImage(srcPath, subPath, 200,100);
		System.out.println("Done");
	}
}
