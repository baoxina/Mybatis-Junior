package com.baoxina.mybatis.junior.introductory_program;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisDelete {
	@Test
	public void testDeleteUserById(){
		String resource = "SqlMapConfig.xml";
		InputStream resourceStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession = null;
		try {
			resourceStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.delete("test.deleteUserById", 11);
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
