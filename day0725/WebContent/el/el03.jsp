<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.ali.domain.Address"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el获取数据</title>
</head>
<body>
	<%
		Address user=new Address();
			user.setName("张三");
			user.setAge(23);
			user.setBirthday(new Date());
			request.setAttribute("u", user);
			
			List list=new ArrayList();
			list.add("aaa");
			list.add("bbb");
			list.add(user);
			request.setAttribute("list", list);
			
			Map map=new HashMap();
			map.put("sname","李四");
			map.put("gender","女");
			map.put("user",user);
			request.setAttribute("map", map);
	%>
	
	
	<h3>el获取对象中的值</h3>
	<%-- 
		通过对象的属性来获取
		setter或getter方法
		setName-->Name-->name	
	 --%>
	 ${requestScope.u.name }<br>
	 ${u.age }<br>
	 ${u.birthday }<br>
	
	
	<h3>el获取List中的值</h3>
	${list }<br>
	${list[0] }<br>
	${list[1] }<br>
	${list[10] }<br>
	
	${list[2].name }<br>
	
	
	<h3>el获取List中的值</h3>
	${map.gender }<br>
	${map["gender"] }<br>
	${map.user.name }<br>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>