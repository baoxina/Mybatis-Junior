package com.baoxina.mybatis.junior.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baoxina.mybatis.junior.po.User;

public class UserMapperTest {

	//sqlSessionFactory���������Ķ���
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}

	@Test
	public void testFindUserById() throws Exception {
		//����sqlSession�����̰߳�ȫ�ģ�����Ծֲ���������ʽ����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//��sqlSession����mapper������󣬴������ʵ����mapper�ӿڵķ���
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		System.out.println(user);
	}
}
