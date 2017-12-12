package com.baoxina.mybatis.junior.introductory_program;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.baoxina.mybatis.junior.po.User;

public class MyBatisSelectList {
	@Test
	public void testFindUsersByName(){
		String resource = "SqlMapConfig.xml";
		InputStream resourceStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession = null;
		try {
			resourceStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
			sqlSession = sqlSessionFactory.openSession();
			List<User> users = sqlSession.selectList("test.findUsersByName", "aa");
			System.out.println(users);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
}
