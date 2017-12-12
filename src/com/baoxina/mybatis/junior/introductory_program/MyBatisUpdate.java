package com.baoxina.mybatis.junior.introductory_program;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.baoxina.mybatis.junior.po.User;

public class MyBatisUpdate {
	@Test
	public void testUpdateUser(){
		String resource = "SqlMapConfig.xml";
		InputStream resourceStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession = null;
		try {
			resourceStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
			sqlSession = sqlSessionFactory.openSession();
			User user = new User();
			user.setId(11);
			user.setName("hahaha");
			user.setAge(245);
			sqlSession.insert("test.updateUser", user);
			//手动提交事务
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
}
