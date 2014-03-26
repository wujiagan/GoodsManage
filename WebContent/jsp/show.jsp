<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.util.TransCodeTool" %>
<jsp:useBean id="person" class="com.model.Person" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>姓名：<%=TransCodeTool.toUTF(person.getName()) %></li>
		<li>年龄：<%=person.getAge() %></li>
	</ul>
</body>
</html>