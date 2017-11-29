package cn.edu.chenggong.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.chenggong.biz.UsersBiz;
import cn.edu.chenggong.dao.UsersMapper;
import cn.edu.chenggong.po.Users;

@Service
public class UsersBizImpl implements UsersBiz {
	@Resource
	private UsersMapper userMapper;
	
	public UsersMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UsersMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public void addUserInfo(Users users) {
		userMapper.addUserInfo(users);
	}
	
	public Users findUsers(Users users){
		return userMapper.findUsers(users);
	}

	public List<Users> getTheUsesInfo() {
		
		return userMapper.getTheUsesInfo();
	}

	public void updateUsersInfo(Users users) {
	    userMapper.updateUsersInfo(users);
	}

	public Users findUsersInfoById(Users users) {
		
		return userMapper.findUsersInfoById(users);
	}

	public void delectUsersInfo(Users users) {
		userMapper.delectUsersInfo(users);
	}

	public void addAdminInfo(Users users) {
		userMapper.addAdminInfo(users);	
	}

	public Users findUsersInfoByUsersName(Users users) {
		return userMapper.findUsersInfoByUsersName(users);
	}

	public void insertMailcode(Users users) {
		userMapper.insertMailcode(users);
		
	}

	public void userUpdatePwd(Users users) {
		userMapper.userUpdatePwd(users);
	}
}
