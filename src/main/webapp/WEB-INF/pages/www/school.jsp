<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>山西华仁通电力科技有限公司招聘筛选</title>	
	    <link rel="stylesheet" href="${contextPath}/static/css/www/position.css" />
	    <link rel="stylesheet" href="${contextPath}/static/css/www/footer.css" />
		<link rel="stylesheet" href="${contextPath}/static/css/bootstrap.css">
		<link rel="stylesheet" href="${contextPath}/static/css/jquery.tagsinput.min.css"/>
		<script type="text/javascript" src="${contextPath}/static/js/jquery-1.11.3.js" ></script>
		<script type="text/javascript" src="${contextPath}/static/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${contextPath}/static/js/jquery.tagsinput.min.js"></script>
		<script type="text/javascript" src="${contextPath}/static/js/sweerAlert2.79.js"></script>
		<script type="text/javascript" src="${contextPath}/static/js/jquery.twbsPagination.min.js"></script>
	</head>
	<body>
		<!--头部导航条-->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<img src="${contextPath}/static/img/B.gif" width="100" height="50"/>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/index1">首页<span class="sr-only">(current)</span></a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">职位选择<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/school/">校园招聘</a></li>
								<li><a href="/position">社会招聘</a></li>
							</ul>
						</li>
						<li><a href="/question">问答管理</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/resume">简历管理</a></li>
								<li><a href="/collection">职位收藏</a></li>
							</ul>
						</li>
					</ul>

					<shiro:notAuthenticated>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="/login1">登录</a></li>
							<li><a href="/register">注册</a></li>
						</ul>
					</shiro:notAuthenticated>

					<shiro:authenticated>
						<ul class="nav navbar-nav navbar-right">
							<shiro:hasRole name="admin">
								<li><a href="/admin/">管理员</a></li>
							</shiro:hasRole>
							<li><a href="javascript:void(0);">${username}</a></li>
							<li><a href="/logout">退出</a></li>
						</ul>
					</shiro:authenticated>
				</div>
			</div>
		</nav>
        
       
        
        <!--招聘条件筛选-->
        <div id="pageContext">
        	<div class = "title">
        		<span>校园招聘</span>
        	</div>
            <div class="shaixuan">
            	<span class="a">筛选条件:</span>
				<div id="tags">

				</div>
            </div>
            <div class="shaixuan">
            	<span class="a">相关职位:</span>
            	<ul class="work">
            		<li class="B"><a href="javascript:void(0)">实习生;</a></li>
            		<li class="B"><a href="javascript:void(0)">应届毕业生;</a></li>
            		<li class="B"><a href="javascript:void(0)">研究生;</a></li>
            		<li class="B"><a href="javascript:void(0)">博士生;</a></li>
            	</ul>
            </div>
           <!--工作地点-->
            <div class="shaixuan">
            	<span class="a">工作地点：</span>
				<ul class="work">
					<li class="B"><a href="javascript:void(0)">太原</a></li>
					<li class="B"><a href="javascript:void(0)">上海</a></li>
					<li class="B"><a href="javascript:void(0)">杭州</a></li>
				</ul>
            </div>
            
            <!--职位类别-->
            <div class="shaixuan">
            	<span class="a">职位类别：</span>
				<ul class="work">
<%--					<li  class="B"><a href="javascript:void(0)">技术.</a></li>--%>
<%--					<li  class="B"><a href="javascript:void(0)">管理.</a></li>--%>
<%--					<li  class="B"><a href="javascript:void(0)">服务.</a></li>--%>
<%--					<li  class="B"><a href="javascript:void(0)">财务.</a></li>--%>
<%--					<li  class="B"><a href="javascript:void(0)">人力资源.</a></li>--%>
<%--					<li  class="B"><a href="javascript:void(0)">销售.</a></li>--%>
				</ul>
            </div>
            
            <!--关键字搜索-->
            <div class="search">
            	<span>关键字搜索：</span>
				<div class="input-group">
				    <input type="text" id="keyWord" class="form-control" placeholder="输入关键词" style="width: 300px;height: 50px;"/>
				      <span class="input-group-btn" style="padding: 15px 0;">
				        <button class="btn btn-danger glyphicon glyphicon-search" type="button" id="searchBtn" style="width: 50px;height: 50px; position: relative;top: 0;"></button>
				      </span>
				</div>
            </div>
        </div>
        
        <!--内容-->
        
        <div id="table">
        	<ul>
        		<li style="display: none;">id</li>
        		<li>职位描述</li>
        		<li>工作地点</li>
        		<li>类别</li>
        		<li>部门名称</li>
        	</ul>
			<ul id="ulPosition">
				<c:forEach items="${positions.list}" var="p" step="1">
					<li class="positionList">
						<span style="display:none;">${p.id}</span>
						<span style="width: 240px">${p.pName}</span>
						<span>${p.workSite}</span>
						<span>${p.pClassify}</span>
						<span>${p.pDepartment}</span>
						<p style="width: 800px;height:31px;overflow: hidden">${p.pRequest}</p>
					</li>
				</c:forEach>
			</ul>
        </div>
        
        <!--分页-->
        <div id="page" style="float: right;margin-right: 145px;position: relative;top: -15px;">
			<span id="totalPage" style="display: none">${positions.pages}</span>
			<ul class="pagination" id="pagination-demo"></ul>
        </div>
        

        
        <footer>
			<div class="left_1">
				<ul>
					<li><a href="http://www.sx-hrt.com/about/">公司公告</a></li>
					<li><a href="http://www.sx-hrt.com/news/">公司新闻</a></li>
				</ul>
			</div>


			<div id="desc">
				<p>© 2019 山西华仁通电力科技有限公司. All Rights Reserved. </p>
			</div>
       </footer>
		<script src="${contextPath}/static/js/www/school.js"></script>
		<script src="${contextPath}/static/js/www/schoolPage.js"></script>
	</body>
</html>
