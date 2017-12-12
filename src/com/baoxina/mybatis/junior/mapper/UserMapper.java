package com.baoxina.mybatis.junior.mapper;

import java.util.List;

import com.baoxina.mybatis.junior.po.User;

/**
 * mapper代理方式代替原始dao的实现
 * @author baoxina
 *
 */
public interface UserMapper {

	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据名称模糊查询用户信息
	public List<User> findUserByName(String name) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUserById(int id) throws Exception;
	
	//更新用户信息
	public void updateUser(User user) throws Exception;
}
