<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.factory.*, com.model.*"  %>
<%@ page import="java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body class="home">
<%@include file="base.jsp" %>
<%
	List<Goods> all = DAOFactory.getGoodsDAOInstance().getAll();
	Iterator<Goods> iter = all.iterator();
%>
     	
        <ul class="nav nav-tabs">
            <li class="active">
                <a href="goods_list.jsp">商品列表</a>
            </li>
            <li><a href="goods_add.jsp">添加商品</a></li>
        </ul>
        <table class="table table-hover">
            <tr class="info">
            	<td>id</td>
                <td>名称</td>
                <td>生产商</td>
                <td>型号</td>
                <td>规格</td>
                <td></td>
            </tr>
            <% 
				while(iter.hasNext()) {
				Goods goods = iter.next();
			%>
			<tr>
				<td><%=goods.getId() %></td>
				<td><%=goods.getName() %></td>
				<td><%=goods.getManuFacturer() %></td>
				<td><%=goods.getSn() %></td>
				<td><%=goods.getSize() %></td>
				<td>
                    <a href=""><i class="icon-edit"></i></a>
                    <a href=""><i class="icon-trash"></i></a>
                </td>
			</tr>
			<%	} %>
        </table>
</body>
</html>