<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
</head>
<body>
	<!--下拉菜单  -->
	
	<form action="/IMovie/showMovie">
	
	电影类型：	<select name="mid">
	<option value="-1">分类选项</option>
	<c:forEach items="${list2 }" var="i">
	<option value="${i.movieid }">${i.keyword }</option>
	</c:forEach>
	</select>
	<br>
	<br>
	<br>
	<br>
	<!--输入框进行模糊  -->
	电影名：	<input type="text" name="moviename"/>
	<input type="submit" value="查询">
	</form>
	<br>
	<br>
	<br>
	<br>
	
	<c:forEach items="${list }" var="i">
	<table border="1">
	<tr>
	<td><a href="/IMovie/moviedetaile?mid=${i.mid}">电影名字</a></td>
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
	<tr><td><a href="/IMovie/insertMovie?mid=${i.mid }">更新</a></td></tr>
	<tr><td><a href="javascript:void(0)" onclick="deleteM(${i.mid })" >删除</a></td></tr>

	</table>
	</c:forEach>
	<script type="text/javascript">
		function deleteM(id)
		{
			alert(id);
			
			if(confirm("确认删除。。"))
			{
				
				$.ajax({
					url:"/IMovie/deleteMovie?mid="+id,
					
					success: function(data){
						if(data=='success')
							{
							alert("删除成功。。");
							window.location="/IMovie/showMovie";
							
							}
						else{
								alert("删除失败。。");
							
						}
						
						
					}
					
				})
				
				
				}
				return ;		
		}
	
	</script>
	

</body>
</html>