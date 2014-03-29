<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="navbar navbar-header">
		<div class="navbar-inner">
			<!-- Be sure to leave the brand out there if you want it shown -->
			<a class="brand" href="">商品管理系统</a>

			<ul class="nav">
				<li><a href="home.jsp">首页</a></li>

				<li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">库存管理<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                          <li>
                            <a href="entrepot_in_list.html">入库管理</a>
                          </li>
                          <li>
                            <a href="entrepot_out_list.html">出库管理</a>
                          </li>
                    </ul>
				</li>

				<li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">商品管理<b class="caret"></b></a>
				    <ul class="dropdown-menu">
					    <li>
                            <a href="goods_list.jsp">商品</a>
						    <a href="search.html">查询</a>
					    </li>
				    </ul>
				</li>

				<li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">用户管理<b class="caret"></b></a>
				    <ul class="dropdown-menu">
					    <li>
						    <a href="">用户</a>
					    </li>
				    </ul>
				</li>

			</ul>
            <ul class="nav pull-right">
                <li class="divider-vertical"></li>
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">  欢迎你admin@fn315.com <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="">返回首页</a></li>
                        <li><a href="">修改密码</a></li>
                        <li><a href="">退出</a></li>
                    </ul>
                </li>
             </ul>
			</div>
		</div>