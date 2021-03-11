package com.zy.common.db;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisUtils {

	private static Logger logger = LoggerFactory.getLogger(MyBatisUtils.class);
	private static SqlSessionFactory sqlSessionFactory;
	private static ThreadLocal<SqlSession> localSessions = new ThreadLocal<>();

	public static void init() {
		ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
		ClassLoader extensionLoader = MyBatisUtils.class.getClassLoader();
		Thread.currentThread().setContextClassLoader(extensionLoader);
		InputStream in = MyBatisUtils.class.getResourceAsStream("/mybatis.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		Thread.currentThread().setContextClassLoader(origLoader);
		logger.info("MyBatisUtils is ready");
	}

	private static SqlSession openSession() {
		SqlSession session = localSessions.get();
		if (session == null) {
			session = sqlSessionFactory.openSession(true);
			localSessions.set(session);
		}
		return session;
	}

	public static void close() {
		SqlSession session = localSessions.get();
		if (session != null) {
			session.close();
			localSessions.remove();
		}
	}

	public static <T> T getMapperImpl(Class<T> type) {
		SqlSession session = openSession();
		return session.getMapper(type);
	}

}
