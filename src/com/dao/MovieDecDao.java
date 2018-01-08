package com.dao;

import java.util.List;

import com.modle.MovieDec;

public interface MovieDecDao {
	/**
	 * 插入电影的评论
	 */
	public boolean insert(MovieDec movieDec);
	/*8
	 * 查找一个电影中的所有的评论
	 */
	public List<MovieDec> select(MovieDec movieDec);
	/*8
	 * 删除电影中的评论
	 */
	public boolean delete(MovieDec movieDec);
}
