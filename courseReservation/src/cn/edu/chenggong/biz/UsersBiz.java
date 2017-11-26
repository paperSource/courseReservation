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
}
