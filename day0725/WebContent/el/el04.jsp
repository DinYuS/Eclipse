<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el隐式对象</title>
</head>
<body>
	${pageContext.request }<br>
	<h4>在jsp页面动态获取虚拟目录</h4>
	${pageContext.request.contextPath }<br>
</body>
</html>