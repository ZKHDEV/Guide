package com.zkh.guide.service;

import com.zkh.guide.po.ForgetQueryVo;
import com.zkh.guide.po.GuideExtuser;
import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.LoginQueryVo;
import com.zkh.guide.po.RegisterQueryVo;

public interface UserService {

	public GuideUser checkLogin(LoginQueryVo loginQueryVo);

	public Boolean existedUser(String username);

	public Boolean existedEmail(String email);

	public void register(RegisterQueryVo registerQueryVo);
	
	public Boolean checkUserAndEmail(ForgetQueryVo forgetQueryVo);
	
	public Boolean changePwd(GuideUser user,String newPwd);
	
	public Boolean changeUserName(GuideUser user,String userName);
	
	public Boolean changeEmail(GuideUser user,String email);
	
	public GuideUser selectByUserName(String userName);
	
	public GuideUser selectByPrimaryKey(Integer userId);
	
	public Boolean updateStateByPrimaryKey(GuideUser user,Byte state);
	
	public Boolean updateStateByVerify(String userVerify);
}
