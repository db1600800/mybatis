package com.lixing.ibatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;

	private MyBatisUtil() {
	}

	public static SqlSessionFactory getInstance() {
		String resource = "mybatis-config.xml";
		Reader reader;

		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("没有找到文件");
		}
		return sqlSessionFactory;
	}
}
