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

<form action="/IMovie/doInsertMovie" method="post" enctype="multipart/form-data">
<table border="1">
	<tr>
	<td>电影名字</td>
	<td><input type="text" name="moviename" value="${i.moviename }"></td>
	</tr>
	<tr>
	<td>时长</td>
	<td><input type="text" name="time" value="${i.time }"></td>
	</tr>
	<tr>
	<td>评分</td>
	<td><input type="text" name="score" value="${i.score }"></td>
	</tr>
	<tr>
	<td>封面图</td>
	
	<td>
	<c:choose>
	<c:when test="${i.imagepath eq ''}">
	<input type="file" name="file" >
	</c:when>
	<c:otherwise>
	<img src="${i.imagepath }">
	<input type="file" name="file" >
	</c:otherwise>
	</c:choose>
	</td>
	
	</tr>
	<tr>
	<td>导演</td>
	<td><input type="text" name="director" value="${i.director }"></td>
	</tr>
	<tr>
	<td>主演</td>
	<td><input type="text" name="performer" value="${i.performer}"></td>
	</tr>

	</table>
	<input type ="submit" value ="提交">
</form>
</body>
</html>