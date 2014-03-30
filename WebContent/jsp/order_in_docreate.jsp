<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.factory.*, com.model.*"  %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<%
	Order order = new Order();
	order.setGoods_id(Integer.parseInt(request.getParameter("goods")));
	order.setAmount(Integer.parseInt(request.getParameter("amount")));
	order.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("operate_date")));
	order.setOperateMan(request.getParameter("deliveryman"));
	try{
			if(DAOFactory.getOrderInDAOInstance().doCreate(order)) {
%>
				<jsp:forward page="order_in_list.jsp"></jsp:forward>
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