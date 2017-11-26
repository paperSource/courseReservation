package cn.edu.chenggong.dao;

import java.util.List;

import cn.edu.chenggong.po.Users;

public interface UsersMapper {
	
	public void addUserInfo(Users users);//添加用户
	public Users findUsers(Users users);//查找用户
	public List<Users> getTheUsesInfo();//获取所有用户信息
	public void updateUsersInfo(Users users);//更新用户信息
	public Users findUsersInfoById(Users users);//查询用户信息通过id
	public void delectUsersInfo(Users users);
	public void addAdminInfo(Users users);//添加超级用户
	
}
