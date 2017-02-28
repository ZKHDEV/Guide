package com.zkh.guide.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zkh.guide.common.CommonUtils;
import com.zkh.guide.mapper.GuideExtuserMapper;
import com.zkh.guide.mapper.GuideUserMapper;
import com.zkh.guide.po.ChangePwdQueryVo;
import com.zkh.guide.po.ForgetQueryVo;
import com.zkh.guide.po.GuideExtuser;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.GuideUserExample;
import com.zkh.guide.po.LoginQueryVo;
import com.zkh.guide.po.RegisterQueryVo;
import com.zkh.guide.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private GuideUserMapper guideUserMapper;
	
	@Autowired
	private GuideExtuserMapper guideExtuserMapper;
	
	@Override
	public GuideUser checkLogin(LoginQueryVo loginQueryVo) {
		
		GuideUserExample guideUserExample = new GuideUserExample();
		GuideUserExample.Criteria criteria = guideUserExample.createCriteria();
		criteria.andUserNameEqualTo(loginQueryVo.getUsername().toLowerCase());
		criteria.andUserPwdEqualTo(loginQueryVo.getPassword());
		List<GuideUser> list = guideUserMapper.selectByExample(guideUserExample);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public Boolean existedUser(String username) {
		GuideUserExample guideUserExample = new GuideUserExample();
		GuideUserExample.Criteria criteria = guideUserExample.createCriteria();
		criteria.andUserNameEqualTo(username.toLowerCase());
		List<GuideUser> list = guideUserMapper.selectByExample(guideUserExample);
		return list.size() > 0;
	}

	@Override
	public Boolean existedEmail(String email) {
		GuideUserExample guideUserExample = new GuideUserExample();
		GuideUserExample.Criteria criteria = guideUserExample.createCriteria();
		criteria.andUserEmailEqualTo(email.toLowerCase());
		List<GuideUser> list = guideUserMapper.selectByExample(guideUserExample);
		return list.size() > 0;
	}

	@Override
	public void register(RegisterQueryVo registerQueryVo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuideUser user = new GuideUser();
		user.setUserName(registerQueryVo.getReguser().trim().toLowerCase());
		user.setUserPwd(registerQueryVo.getRegpwd());
		user.setUserEmail(registerQueryVo.getRegemail().trim().toLowerCase());
		user.setUserModifiedon(dateFormat.format(new Date()));
		user.setUserSubtime(dateFormat.format(new Date()));
		user.setUserState((byte)0);
		user.setUserVerify(CommonUtils.uuid().substring(0, 8).toUpperCase());
		guideUserMapper.insert(user);
		
		GuideExtuser extuser = new GuideExtuser();
		extuser.setExtuserUserId(user.getUserId());
		extuser.setExtuserModifiedon(dateFormat.format(new Date()));
		extuser.setExtuserLikenum(0);
		guideExtuserMapper.insert(extuser);
	}

	@Override
	public Boolean checkUserAndEmail(ForgetQueryVo forgetQueryVo) {
		GuideUserExample guideUserExample = new GuideUserExample();
		GuideUserExample.Criteria criteria = guideUserExample.createCriteria();
		criteria.andUserNameEqualTo(forgetQueryVo.getFgname().toLowerCase());
		criteria.andUserEmailEqualTo(forgetQueryVo.getFgemail().toLowerCase());
		List<GuideUser> list = guideUserMapper.selectByExample(guideUserExample);
		return list.size() > 0;
	}

	@Override
	public GuideUser selectByUserName(String userName) {
		GuideUserExample guideUserExample = new GuideUserExample();
		GuideUserExample.Criteria criteria = guideUserExample.createCriteria();
		criteria.andUserNameEqualTo(userName.toLowerCase());
		List<GuideUser> list = guideUserMapper.selectByExample(guideUserExample);
		return list.get(0);
	}

	public Boolean changePwd(GuideUser user,String newPwd){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		user.setUserModifiedon(dateFormat.format(new Date()));
		user.setUserPwd(newPwd);
		return guideUserMapper.updateByPrimaryKey(user) > 0;
	}

	@Override
	public GuideUser selectByPrimaryKey(Integer userId) {
		return guideUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Boolean changeUserName(GuideUser user, String userName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		user.setUserModifiedon(dateFormat.format(new Date()));
		user.setUserName(userName.toLowerCase());
		return guideUserMapper.updateByPrimaryKey(user) > 0;
	}

	@Override
	public Boolean changeEmail(GuideUser user, String email) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		user.setUserModifiedon(dateFormat.format(new Date()));
		user.setUserEmail(email.toLowerCase());
		user.setUserState((byte)0);
		user.setUserVerify(CommonUtils.uuid().substring(0, 8).toUpperCase());
		return guideUserMapper.updateByPrimaryKey(user) > 0;
	}

	@Override
	public Boolean updateStateByPrimaryKey(GuideUser user,Byte state) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		user.setUserModifiedon(dateFormat.format(new Date()));
		user.setUserState(state);
		return guideUserMapper.updateByPrimaryKey(user) > 0;
	}
	
}
