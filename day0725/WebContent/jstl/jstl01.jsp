<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	<c:if test="false">
		<c:out value="Hello JSTL"></c:out>
	</c:if>
	--%>

	<%
		List list=new ArrayList();
			list.add("aaaa");
		request.setAttribute("list", list);
		request.setAttribute("number", 4);
	%>


	//判断request域中一个list集合是否为空，如果不为null，则显示“遍历集合”
	<c:if test="${not empty list}">
		遍历集合.......
		</c:if>

	<br> 
	<c:if test="${number %2 != 0 }">
			${number }为奇数;
		</c:if>














</body>
</html>