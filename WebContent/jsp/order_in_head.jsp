<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<a class="brand" href="home.jsp">商品管理系统</a>

			<ul class="nav">
				<li><a href="home.jsp">首页</a></li>

				<li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">库存管理<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                          <li>
                            <a href="order_in_list.jsp">入库管理</a>
                          </li>
                          <li>
                            <a href="order_out_list.jsp">出库管理</a>
                          </li>
                    </ul>
				</li>

				<li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">商品管理<b class="caret"></b></a>
				    <ul class="dropdown-menu">
					    <li>
                            <a href="goods_list.jsp">商品</a>
					    </li>
				    </ul>
				</li>
			</ul>

               <div class="nav pull-right">
               	<form class="form-search" action="order_in_search.jsp" method="post">
		          <div class="input-append">
		            <input type="text" class="span2 search-query" name="keyword" id="keyname">
		            <button type="submit" class="btn">Search</button>
		          </div>
		        </form>
		     </div>

	</div>
</div>