<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.factory.*, com.model.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<%
	Goods goods = new Goods();
	goods.setName(request.getParameter("goods_name"));
	goods.setManuFacturer(request.getParameter("goods_manuFacturer"));
	goods.setSn(request.getParameter("goods_sn"));
	goods.setSize(request.getParameter("goods_size"));
	out.println("ok1");
	try{
			if(DAOFactory.getGoodsDAOInstance().doCreate(goods)) {
%>
				<jsp:forward page="goods_list.jsp"></jsp:forward>
<%
			}else {
%>
				<h3>添加失败</h3>
<%		
			}
		}catch(Exception e){
%>
				<h3>数据库插入异常</h3>
<% 
		}
%>
</body>
</html>