<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>算数运算符</h3>
	${3 + 4 }<br>
	${3 - 4 }<br>
	${3 * 4 }<br>
	${3 / 4  }<br>
	${3 % 4 }<br>
	${3 mod 4 }<br>
	
	<h3>逻辑运算符</h3>
	${3 > 4 && 3 < 4 }<br>
	${3 > 4 and 3 < 4 }<br>
	${3 > 4 || 3 < 4 }<br>
	${3 > 4 or 3 < 4 }<br>
	
	<h3>比较运算符</h3>
	${3 == 4 }<br>
	
	<h3>空运算符</h3>
	<%
		String str="";
		request.setAttribute("str", str);	
		List list=new ArrayList();
		request.setAttribute("list", list);
	%>
	${empty str}<br>
	${not empty str}<br>
	${empty list}<br>
	${not empty list}<br>
	
	
	
</body>
</html>