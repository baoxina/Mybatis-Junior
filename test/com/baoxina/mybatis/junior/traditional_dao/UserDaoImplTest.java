package com.baoxina.mybatis.junior.traditional_dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baoxina.mybatis.junior.po.User;
import com.baoxina.mybatis.junior.traditional_dao.UserDaoImpl;

public class UserDaoImplTest {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		//´´½¨sqlSessionFactory
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testFindUserById() throws Exception {
		UserDaoImpl dao = new UserDaoImpl(sqlSessionFactory);
		User user = dao.findUserById(10);
		System.out.println(user.getName());
	}

}

