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
<c:forEach items="${list }" var="i">
<table border="1">
	<tr>
	<td>电影的Id</td>
	<td>${i.movieid }</td>
	
	</tr>
	<tr>
	<td>关键字</td>
	<td>${i.keyword }</td>
	</tr>
	<tr>
	<tr><td><a href="javascript:void(0)" onclick="deleteM(${i.id })" >删除</a></td></tr>
	</table>
	</c:forEach>

</body>

	<script type="text/javascript">
		function deleteM(id)
		{
			alert(id);
			
			if(confirm("确认删除。。"))
			{
				
				$.ajax({
					url:"/IMovie/dodeleteCategry?id="+id,
					
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
</html>