package com.dao;

import java.util.List;

import com.modle.MovieTable;

public interface MovieTableDao {
		
	/**
	 * 查询电影表中的所有信息
	 */
	public List<MovieTable> select(MovieTable movieTable);
	/**
	 * 向电影表中插入新的数据
	 */
	public boolean insert(MovieTable movieTable);
	/**
	 * 像电表中更新数据
	 */
	public boolean  update(MovieTable movieTable);
	/**
	 * 向表中删除一条数据
	 * 
	 */
	public boolean delete(MovieTable movieTable);
		
}
