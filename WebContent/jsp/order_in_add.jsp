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
     <%@include file="base.jsp" %>

        <ul class="nav nav-tabs">
            <li>
                <a href="order_in_list.jsp">入库列表</a>
            </li>
            <li class="active">
                <a href="order_in_add.jsp">新建</a>
            </li>
        </ul>

        <form class="form-horizontal" action="order_in_docreate.jsp" method="post">
            <div class="control-group">
                <label class="control-label" for="goods">商品名称：</label>
                <div class="controls">
                    <select data-allow-blank="1" data-role="select2" id="goods" name="goods"><option selected value="__None">
                    <%
                    	while(iter.hasNext()) {
                    		Goods goods = iter.next();
                    %>
                    <option value="<%=goods.getId() %>"><%=goods.getName() %></option>
                    <% } %>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="amount">数量：</label>
                <div class="controls">
                    <input type="text" id="amount" name="amount">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="operate_date">入库时间：</label>
                <div class="controls">
                  <input id="operate_date" name="operate_date" type="date">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="deliveryman">送货人：</label>
                <div class="controls">
                <input type="text" id="deliveryman" name="deliveryman">
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
