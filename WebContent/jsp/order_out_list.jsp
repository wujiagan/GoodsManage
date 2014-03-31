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

<body class="home">
<%
	List<Order> all = DAOFactory.getOrderOutDAOInstance().getAll();
	Iterator<Order> iter = all.iterator();
%>
     <%@include file="order_out_head.jsp" %>
        <ul class="nav nav-tabs">
            <li class="active">
                <a href="order_out_list.jsp">出库列表</a>
            </li>
            <li>
                <a href="order_out_add.jsp">新建</a>
            </li>
            <li>
                <a href="order_out_statistics.jsp">按时间查询</a>
            </li>
        </ul>

        <table class="table table-hover">
            <tr class="info">
                <td>id</td>
                <td>商品id</td>
                <td>商品</td>
                <td>数量</td>
                <td>日期</td>
                <td>提货人</td>
                <td></td>
            </tr>
            <%
            	while(iter.hasNext()){
            		Order order = iter.next();
            %>
            <tr>
                <td><%=order.getId() %></td>
                <td><%=order.getGoods_id()  %></td>
                <td><%=order.getGoods_name()  %></td>
                <td><%=order.getAmount() %></td>
                <td><%=order.getDate() %></td>
                <td><%=order.getOperateMan() %></td>
                <td>
                    <a href=""><i class="icon-edit"></i></a>
                    <a href=""><i class="icon-trash"></i></a>
                </td>
            </tr>
            <% } %>
        </table>
        <h2>共计<%=all.size() %>条记录</h2>
</body>
</html>
