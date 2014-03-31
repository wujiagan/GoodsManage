<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.factory.*, com.model.*"  %>
<%@ page import="java.util.*"  %>
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
	List<Goods> all = DAOFactory.getGoodsDAOInstance().getAll();
	Iterator<Goods> iter = all.iterator();
%>
     <%@include file="order_out_head.jsp" %>

        <ul class="nav nav-tabs">
            <li>
                <a href="order_out_list.jsp">出库列表</a>
            </li>
            <li>
                <a href="order_out_add.jsp">新建</a>
            </li>
            <li class="active">
                <a href="order_out_statistics.jsp">按时间查询</a>
            </li>
        </ul>

        <form class="form-horizontal" action="order_out_searchByDate.jsp" method="post">
            <div class="control-group">
                <label class="control-label" for="start_date">开始时间：</label>
                <div class="controls">
                  <input id="start_date" name="start_date" type="date">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="end_date">结束时间：</label>
                <div class="controls">
                  <input id="end_date" name="end_date" type="date">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                <button type="submit" class="btn btn-primary">添加</button>
                </div>
            </div>
        </form>
</body>
</html>
