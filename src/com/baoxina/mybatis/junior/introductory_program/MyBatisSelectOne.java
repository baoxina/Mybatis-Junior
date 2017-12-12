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

	//����id��ѯ�û����õ�һ����Ϣ
	@Test
	public void testfindUserById(){
		//mybatis�����ļ�·��
		String resource = "SqlMapConfig.xml";
		InputStream resourceStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession = null;
		try {
			//����MyBatis���������ļ�
			resourceStream = Resources.getResourceAsStream(resource);
			//�����Ự����
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
			//ͨ�������õ��Ự
			sqlSession = sqlSessionFactory.openSession();
			/*
			 * ͨ��sqlSession�������ݿ�
			 * 1:String statement ӳ���ļ��е�statement��id, �� namespace+"."+statementid
			 * 2:Object parameter ��ӳ���ļ�����ƥ���parameterType���͵Ĳ���
			 * 
			 * sqlSession.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���
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
