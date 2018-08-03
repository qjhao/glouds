<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bootstrap树形测试</title>
<script type="text/javascript" src="${ctxStatic}/adminlte/js/adminlte.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery/Plugins/TabPanel.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery/Plugins/TabPanel.extend.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery/Plugins/Fader.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery/Plugins/jquery.slimscroll.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-migrate-1.4.1.js"></script>
<script type="text/javascript" src="${ctxStatic}/jeesite/jeesite.js"></script>
<script type="text/javascript" src="${ctxStatic}/jeesite/sysIndex.js"></script>
     
<link type="text/css" href="${ctxStatic}/fonts/css/font-awesome.min.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/ionicons/css/ionicons.min.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/adminlte/css/AdminLTE.min.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/adminlte/css/skins/skin-blue.min.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/morris/morris.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/jvectormap/jquery-jvectormap.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/jquery/Plugins/TabPanel.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/jeesite/jeesite.css" rel="stylesheet"/>
<link type="text/css" href="${ctxStatic}/jeesite/sysIndex.css" rel="stylesheet"/>
<script type="text/javascript">
</script>

<style type="text/css">
</style>

</head>
<body class="hold-transition fixed noscroll2 sidebar-mini ">
	<div class="wrapper">
	<header class="main-header">
		<div class="logo" data-toggle="push-menu" title="AdminLTE">
			<b>AdminLTE</b>
			<small>
				&nbsp; &nbsp;
				<i class="fa fa-bars"></i>
			</small>
		</div>
		<nav class="navbar navbar-static-top">
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li>
						<a href="http://www.baidu.com" target="_blank">
							<i class="fa fa-diamond"></i>
						</a>
					</li>
					<li>
						<a href="javascript:" id="fullScreen" title="全屏">
							<i class="fa fa-arrows-alt"></i>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
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
									<a title="用户管理" href="javascript:" data-href="/sins/demo/demo?name=lhgDemo" class="addTabPage">
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
	<div class="content-wrapper">
		<div id="tabpanel"></div>
		<div class="hide" id="desktopTabPage" data-title="仪表盘" data-url="http://www.baidu.com"></div>
	</div>
	</div>
</body>
</html>