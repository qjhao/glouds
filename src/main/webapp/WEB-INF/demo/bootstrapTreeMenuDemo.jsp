<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bootstrap树形测试</title>
<script type="text/javascript" src="${ctxStatic}/adminlte/js/adminlte.min.js"></script>
        
        <link type="text/css" href="${ctxStatic}/fonts/css/font-awesome.min.css" rel="stylesheet"/>
        <link type="text/css" href="${ctxStatic}/ionicons/css/ionicons.min.css" rel="stylesheet"/>
        <link type="text/css" href="${ctxStatic}/adminlte/css/AdminLTE.min.css" rel="stylesheet"/>
        <link type="text/css" href="${ctxStatic}/adminlte/css/skins/skin-blue.min.css" rel="stylesheet"/>
        <link type="text/css" href="${ctxStatic}/morris/morris.css" rel="stylesheet"/>
        <link type="text/css" href="${ctxStatic}/jvectormap/jquery-jvectormap.css" rel="stylesheet"/>
<script type="text/javascript">
</script>

</head>
<body>
	<aside class="main-sidebar">
		<section class="sidebar">
			<ul class="sidebar-menu" data-widget="tree">
				<li class="treeview">
					<a title="系统管理" href="javascript:" data-href="blank" class="addTablePage">
						<i class="fa fa-fw icon-settings"></i>
						<span>系统管理</span>
						<span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li class="treeview">
							<a title="组织管理" href="javascript:" data-href="blank" class="addTabPage">
								<i class="fa fa-fw icon-grid"></i>
								<span>组织管理</span>
								<span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
							</a>
							<ul class="treeview-menu">
								<li class="treeview">
									<a title="用户管理" href="javascript:" data-href="http://www.baidu.com" class="addTabPage">
										<i class="fa fa-fw icon-user"></i>
										<span>用户管理</span>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</section>
	</aside>
</body>
</html>