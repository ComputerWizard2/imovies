package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dao.MovieDecDao;
import com.dao.MovieDetailDao;
import com.dao.MovieTableDao;
import com.modle.MovieDec;
import com.modle.MovieDetail;
import com.modle.MovieTable;
import com.util.MyBitsUtil;

@Controller
public class MovieInfoController {
		/**
		 * 用于显示 和查找电影信息的处理器
		 * @return
		 */
	@RequestMapping("/showMovie")
	public String showMovie(ModelMap map, MovieTable movieTable)
	{
		MovieDec movieDec=new MovieDec();
		MovieTableDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieTableDao.class);
		MovieDetailDao mapper2 = MyBitsUtil.getSqlSession().getMapper(MovieDetailDao.class);
		MovieDecDao mapper3 = MyBitsUtil.getSqlSession().getMapper(MovieDecDao.class);	
		List<MovieDec> select = mapper3.select(movieDec);
		float avg =0f;
		int sum =0;
		for (MovieDec movieDec2 : select) {
			sum+=movieDec2.getScore();
		}
		avg=sum/select.size();
		movieTable.setScore(avg);
		
		mapper.update(movieTable);
		
		MovieDetail movieDetail =new MovieDetail();
		List<MovieTable> list = mapper.select(movieTable);
		List<MovieDetail> list2 = mapper2.select(movieDetail);
		map.addAttribute("list", list);
		map.addAttribute("list2", list2);
		
		return "movieshow";
	}
	@RequestMapping("/moviedetaile")
	public String moviedetaile(ModelMap map, MovieTable movieTable)
	{
		MovieDetail movie =new MovieDetail();
		movie.setId(movieTable.getMid());
		MovieTableDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieTableDao.class);
		MovieDetailDao mapper2 = MyBitsUtil.getSqlSession().getMapper(MovieDetailDao.class);
		 MovieDecDao mapper3 = MyBitsUtil.getSqlSession().getMapper(MovieDecDao.class);
		MovieDec movieDec =new MovieDec();
		movieDec.setMid(movieTable.getMid());
		System.out.println("---->"+movieDec.getMid());
		
		MovieTable list = mapper.select(movieTable).get(0);
		MovieDetail list2 = mapper2.select(movie).get(0);
		List<MovieDec> list3 = mapper3.select(movieDec);
		System.out.println(list3);
		
		map.addAttribute("i", list);
		map.addAttribute("a", list2);
		map.addAttribute("desc", list3);
		return "moviedetail";
	}
	
	@RequestMapping("/insertDec")
	public String insertDec(MovieDec movieDec )
	{
		
	
		MovieDecDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieDecDao.class);
		boolean insert = mapper.insert(movieDec);
		
		if (insert) {
			
			return "redirect:/moviedetaile";
		}
		return "";
	}
	
	@RequestMapping("/doInsertMovie")
	public String InsertMovie(MovieTable movieTable,@RequestParam("file")MultipartFile multipartFile,HttpServletRequest request) throws IllegalStateException, IOException
	{
		if (multipartFile.getOriginalFilename()!=null&& ! "".equals(multipartFile.getOriginalFilename())) {
		String filename = multipartFile.getOriginalFilename();
		String newName = UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
		String realPath = request.getServletContext().getRealPath("/upload");
		String imgpath=request.getContextPath()+"/upload/"+newName;
		File file =new File(realPath+"/"+newName);
		multipartFile.transferTo(file);
		movieTable.setImagepath(imgpath);
		movieTable.setSaveimagepath(realPath);
		}
		MovieTableDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieTableDao.class);
		boolean insert = mapper.insert(movieTable);
		if (insert) {
			
			return "redirect:/showMovie";
		}
		
		
		return "";
		
	}
	@RequestMapping("/insertMovie")
	public String insertMovie(MovieTable movieTable ,ModelMap map)
	{
		if (movieTable.getMid()!=null) {
			MovieTableDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieTableDao.class);
			MovieTable select = mapper.select(movieTable).get(0);
			map.addAttribute("i", select);
			
		}
		
		return "insertMovie";
		
		
	}
	@ResponseBody
	@RequestMapping("deleteMovie")
	public String deleteMovie(MovieTable movieTable)
	{
		
		MovieDec movieDec =new MovieDec();
		movieDec.setMid(movieTable.getMid());
		MovieTableDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieTableDao.class);
		MovieDecDao mapper2 = MyBitsUtil.getSqlSession().getMapper(MovieDecDao.class);
		boolean delete = mapper.delete(movieTable);
		boolean delete2 = mapper2.delete(movieDec);
		if (delete2&&delete) {
			
			return "success";
		}
		else
		{
			return "";
		}
		
		
	}
	
	@RequestMapping("/insertCatgory")
	public String insertCatgory()
	{
		
		
		return "insertmoviedetail";
		
		
	}
	@RequestMapping("/deleteCatgory")
	public String deleteCatgory(ModelMap map)
	{
		MovieDetail movieDetail =new MovieDetail();
		MovieDetailDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieDetailDao.class);
		List<MovieDetail> select = mapper.select(movieDetail);
		map.addAttribute("list", select);
		return "showallcatgiry";
		
		
	}
	@ResponseBody
	@RequestMapping("/dodeleteCategry")
	public String dodeleteCatgory(MovieDetail movieDetail)
	{
		MovieDetailDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieDetailDao.class);
		boolean delete = mapper.delete(movieDetail);
		if (delete) {
			
			return "success";
		}
		return"";
		
		
	}
	@RequestMapping("/doinsertCatgory")
	public String doinsertCatgory(MovieDetail movieDec)
	{
		MovieDetailDao mapper = MyBitsUtil.getSqlSession().getMapper(MovieDetailDao.class);
		boolean insert = mapper.insert(movieDec);
		if (insert) {
			
			return "redirect:/showMovie";
		}
		return "";
		
	}
	
}
