<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el获取域中（共享对象）的数据</title>
</head>
<body>
	<%
		session.setAttribute("name","李四");
		session.setAttribute("name","张三");
		session.setAttribute("age",23);
		session.setAttribute("str","");
		
	%>
	
	<h3>el获取值</h3>
	${requestScope.name }
	${requestScope.age }
	${requestScope.haha }<br>
	<%-- application -> session -> request --%>
	${name}
	
	
	
</body>
</html>