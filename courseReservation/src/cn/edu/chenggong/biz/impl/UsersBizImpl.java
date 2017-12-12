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
	
	@Override
	public void addUserInfo(Users users) {
		userMapper.addUserInfo(users);
	}
	
	@Override
	public Users findUsers(Users users){
		return userMapper.findUsers(users);
	}

	@Override
	public List<Users> getTheUsesInfo() {
		
		return userMapper.getTheUsesInfo();
	}

	@Override
	public void updateUsersInfo(Users users) {
	    userMapper.updateUsersInfo(users);
	}

	@Override
	public Users findUsersInfoById(Users users) {
		
		return userMapper.findUsersInfoById(users);
	}

	@Override
	public void delectUsersInfo(Users users) {
		userMapper.delectUsersInfo(users);
	}

	@Override
	public void addAdminInfo(Users users) {
		userMapper.addAdminInfo(users);	
	}

	@Override
	public Users findUsersInfoByUsersName(Users users) {
		return userMapper.findUsersInfoByUsersName(users);
	}

	@Override
	public void insertMailcode(Users users) {
		userMapper.insertMailcode(users);
		
	}

	@Override
	public void userUpdatePwd(Users users) {
		userMapper.userUpdatePwd(users);
	}

	@Override
	public Users findAllById(int id) {
		return userMapper.findAllById(id);
	}

	
}
