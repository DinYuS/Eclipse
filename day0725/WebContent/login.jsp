<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script>
        window.onload = function(){
            document.getElementById("img").onclick = function(){
                this.src="/day0725/checkCodeServlet?time="+new Date().getTime();
            }
        }


    </script>
    
    <style>
        div{
            color: red;
        }

    </style>
	
</head>
<body>
	<form action="loginServlet" method="post">
		<label>用户名：</label>
		<div>
			<input type="text" name="username"/>
		</div>
		
		<label>密码：</label>
		<div>
			<input type="password" name="password"/>
		</div>
		
		<div>
			验证码：<input type="text" name="checkCode"/>
		</div>
		
		<div>
			<img id="img" src="<%=request.getContextPath() %> + '/checkCodeServlet'"/>
		</div>
	
		<div>
			<input type="submit" value="登陆"/>
		</div>
	
	
	
	
	
	
	</form>
	<!--  登陆失败，显示错误信息  -->
	<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>
	
	
	
</body>
</html>