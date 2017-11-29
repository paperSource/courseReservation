package cn.edu.chenggong.biz;

import java.util.List;

import cn.edu.chenggong.po.Users;


public interface UsersBiz {
	
	public void addUserInfo(Users users);
	public Users findUsers(Users users);
	public List<Users> getTheUsesInfo();
	public void updateUsersInfo(Users users);
	public Users findUsersInfoById(Users users);
	public void delectUsersInfo(Users users);
	public void addAdminInfo(Users users);
	public Users findUsersInfoByUsersName(Users users);//查找用户信息通过姓名
	public void insertMailcode(Users users);//插入验证码(mapper.xml其实使用update更新验证)
	public void userUpdatePwd(Users users);//修改用户密码
}
