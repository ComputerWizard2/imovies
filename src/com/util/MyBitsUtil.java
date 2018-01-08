package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * myBatits������
 * ������ȡSqlSession
 * 
 * @author Administrator
 *
 */
public class MyBitsUtil {
	/**
	 * 1. ����SqlSessionFactory 
	 * @throws IOException 
	 * 
	 */
	private static SqlSessionFactory getSqlSessionFactory() throws IOException
	{
		//1. �����������ļ��Ĵ��λ��,��Ϊ���ǽ������ļ�������SRC�£�����ֱ��д�ļ��������
		String resource="mybits-config.xml";
		//2. ��ȡ����������ȡ�����ļ�
		InputStream inputStream =Resources.getResourceAsStream(resource);
		//3. ʵ����sqlsessionFactoryBuilder 
	
		SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
		//4. ͨ������builder��build �������������ļ�������SQLsessionFactory
		SqlSessionFactory sessionFactory =builder.build(inputStream);
		return sessionFactory;
		
		
	}
	
	
	
	
	/**
	 * 2. ��ȡsqlSession����
	 */
	public static SqlSession getSqlSession(){
		
		SqlSession sqlSession=null;
		try {
			/**
			 * �����Զ��ύ��ģʽ
			 */
			sqlSession = getSqlSessionFactory().openSession(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	
	
	

}
