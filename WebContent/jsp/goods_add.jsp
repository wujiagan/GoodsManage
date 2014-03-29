<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@include file="base.jsp" %>
        <ul class="nav nav-tabs">
            <li>
                <a href="goods_list.jsp">商品列表</a>
            </li>
            <li class="active">
                <a href="goods_add.jsp">添加商品</a>
            </li>
        </ul>
        <form class="form-horizontal" action="goods_insert_do.jsp" method="post">
            <div class="control-group">
                <label class="control-label" for="goods_name">名称：</label>
                <div class="controls">
                <input type="text" id="goods_name" name="goods_name" required="required">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="goods_manuFacturer">生产商：</label>
                <div class="controls">
                <input type="text" id="goods_manuFacturer" name="goods_manuFacturer">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="goods_sn">型号：</label>
                <div class="controls">
                <input type="text" id="goods_sn" name="goods_sn">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="goods_size">规格：</label>
                <div class="controls">
                <input type="text" id="goods_size" name="goods_size">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                <button type="Submit" class="btn btn-primary">添加</button>
                </div>
            </div>
        </form>
</body>
</html>
