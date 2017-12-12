package com.baoxina.mybatis.junior.traditional_dao;

import java.util.List;

import com.baoxina.mybatis.junior.po.User;

public interface IUserDao {
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUserById(int id) throws Exception;
}
