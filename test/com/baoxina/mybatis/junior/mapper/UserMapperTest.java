package com.baoxina.mybatis.junior.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baoxina.mybatis.junior.po.User;

public class UserMapperTest {

	//sqlSessionFactory创建单例的对象
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}

	@Test
	public void testFindUserById() throws Exception {
		//由于sqlSession不是线程安全的，因此以局部变量的形式创建
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//用sqlSession创建mapper代理对象，代理对象实现了mapper接口的方法
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		System.out.println(user);
	}
}
