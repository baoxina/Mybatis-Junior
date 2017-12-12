package com.baoxina.mybatis.junior.mapper;

import java.util.List;

import com.baoxina.mybatis.junior.po.User;

/**
 * mapper����ʽ����ԭʼdao��ʵ��
 * @author baoxina
 *
 */
public interface UserMapper {

	//����ID��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	
	//��������ģ����ѯ�û���Ϣ
	public List<User> findUserByName(String name) throws Exception;
	
	//����û���Ϣ
	public void insertUser(User user) throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUserById(int id) throws Exception;
	
	//�����û���Ϣ
	public void updateUser(User user) throws Exception;
}
