package com.dao;

import java.util.List;

import com.modle.MovieTable;

public interface MovieTableDao {
		
	/**
	 * ��ѯ��Ӱ���е�������Ϣ
	 */
	public List<MovieTable> select(MovieTable movieTable);
	/**
	 * ���Ӱ���в����µ�����
	 */
	public boolean insert(MovieTable movieTable);
	/**
	 * �����и�������
	 */
	public boolean  update(MovieTable movieTable);
	/**
	 * �����ɾ��һ������
	 * 
	 */
	public boolean delete(MovieTable movieTable);
		
}
