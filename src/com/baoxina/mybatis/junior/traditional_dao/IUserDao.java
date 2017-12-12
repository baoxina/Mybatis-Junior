package com.baoxina.mybatis.junior.traditional_dao;

import java.util.List;

import com.baoxina.mybatis.junior.po.User;

public interface IUserDao {
	//����ID��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	//����û���Ϣ
	public void insertUser(User user) throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUserById(int id) throws Exception;
}
