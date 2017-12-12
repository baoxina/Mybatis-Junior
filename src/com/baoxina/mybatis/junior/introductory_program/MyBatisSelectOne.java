package com.baoxina.mybatis.junior.introductory_program;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.baoxina.mybatis.junior.po.User;

public class MyBatisSelectOne {

	//根据id查询用户，得到一条信息
	@Test
	public void testfindUserById(){
		//mybatis配置文件路径
		String resource = "SqlMapConfig.xml";
		InputStream resourceStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession = null;
		try {
			//加载MyBatis核心配置文件
			resourceStream = Resources.getResourceAsStream(resource);
			//创建会话工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
			//通过工厂得到会话
			sqlSession = sqlSessionFactory.openSession();
			/*
			 * 通过sqlSession操作数据库
			 * 1:String statement 映射文件中的statement的id, 即 namespace+"."+statementid
			 * 2:Object parameter 与映射文件中所匹配的parameterType类型的参数
			 * 
			 * sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
			 */
			User user = sqlSession.selectOne("test.findUserById",1);
			System.out.println(user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
}
