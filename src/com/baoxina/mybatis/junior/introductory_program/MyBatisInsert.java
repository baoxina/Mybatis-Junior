package com.baoxina.mybatis.junior.introductory_program;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.baoxina.mybatis.junior.po.User;

public class MyBatisInsert {
	@Test
	public void testInsertUser(){
		String resource = "SqlMapConfig.xml";
		InputStream resourceStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession = null;
		try {
			resourceStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
			sqlSession = sqlSessionFactory.openSession();
			User user = new User();
			user.setName("ammy");
			user.setAge(22);
			sqlSession.insert("test.insertUser", user);
			//手动提交事务
			sqlSession.commit();
			//获取用户信息主键
			System.out.println(user.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
}
