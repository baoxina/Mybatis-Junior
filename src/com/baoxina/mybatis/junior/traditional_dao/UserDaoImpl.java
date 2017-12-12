package com.baoxina.mybatis.junior.traditional_dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.baoxina.mybatis.junior.po.User;

/**
 * ԭʼdao  ����������
 * 
 * ����1�����ڴ���ģ�巽�����޷�����
 * SqlSession sqlSession = sqlSessionFactory.openSession();
 * 
 * ����2��test.findUserById Ӳ����
 * User user = (User)sqlSession.selectOne("test.findUserById", id);
 * 
 * ����3�����������������ڱ���׶β����������ڿ���
 * User user = (User)sqlSession.selectOne("test.findUserById", new Date());
 * @author baoxina
 *
 */
public class UserDaoImpl implements IUserDao{

	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = (User)sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}
	
	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> users = sqlSession.selectList("test.findUserByName", name);
		sqlSession.close();
		return users;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUserById", id);
		sqlSession.commit();
		sqlSession.close();
	}
}
