package com.dao;

import java.util.List;

import com.modle.MovieDec;

public interface MovieDecDao {
	/**
	 * �����Ӱ������
	 */
	public boolean insert(MovieDec movieDec);
	/*8
	 * ����һ����Ӱ�е����е�����
	 */
	public List<MovieDec> select(MovieDec movieDec);
	/*8
	 * ɾ����Ӱ�е�����
	 */
	public boolean delete(MovieDec movieDec);
}
