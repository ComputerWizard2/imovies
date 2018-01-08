<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
	<td>电影名字</td>
	<td>${i.moviename }</td>
	
	</tr>
	<tr>
	<td>时长</td>
	<td>${i.time }</td>
	</tr>
	<tr>
	<td>评分</td>
	<td>${i.score }</td>
	</tr>
	<tr>
	<td>封面图</td>
	<td><img src="${i.imagepath }"></td>
	</tr>
	<tr>
	<td>导演</td>
	<td>${i.director }</td>
	</tr>
	<tr>
	<td>主演</td>
	<td>${i.performer}</td>
	</tr>
	<tr>
	<td>分类</td>
	<td>${a.keyword}</td>
	</tr>
	

	</table>
	
	<br>
	<br>
	
	电影的相关评论:
	
	<c:forEach items="${desc}" var="a">
		<textarea rows="10" cols="20" >${a.decs}</textarea>
	</c:forEach>	
	<br>
	<br>
	<form action="/IMovie/insertDec">
	电影评论：
	<textarea rows="10" cols="20" name="decs"></textarea>
	<input type="hidden" value="${i.mid}" name ="mid">
	<select name="score">
		<option value="10">10</option>
		<option value="9">9</option>
		<option value="8">8</option>
		<option value="7">7</option>
	</select>
	<input type="submit">
	</form>
</body>
</html>