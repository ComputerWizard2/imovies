package com.dao;

import java.util.List;

import com.modle.MovieDec;
import com.modle.MovieDetail;


public interface MovieDetailDao {
		public List<MovieDetail> select(MovieDetail movieDetail);
		
		public boolean insert(MovieDetail movieDec);
		
		public boolean delete(MovieDetail movieDec);
		
}
