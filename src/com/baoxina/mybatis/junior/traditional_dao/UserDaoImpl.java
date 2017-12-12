package com.baoxina.mybatis.junior.traditional_dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.baoxina.mybatis.junior.po.User;

/**
 * 原始dao  引出的问题
 * 
 * 问题1：存在大量模板方法，无法重用
 * SqlSession sqlSession = sqlSessionFactory.openSession();
 * 
 * 问题2：test.findUserById 硬编码
 * User user = (User)sqlSession.selectOne("test.findUserById", id);
 * 
 * 问题3：输入参数传入错误，在编译阶段不报错，不利于开发
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
