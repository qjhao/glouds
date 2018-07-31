<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/sitemesh/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE</title>

<script type="text/javascript"
	src="${ctxStatic}/adminlte/js/adminlte.min.js"></script>

<link type="text/css" href="${ctxStatic}/fonts/css/font-awesome.min.css"
	rel="stylesheet" />
<link type="text/css" href="${ctxStatic}/ionicons/css/ionicons.min.css"
	rel="stylesheet" />
<link type="text/css" href="${ctxStatic}/adminlte/css/AdminLTE.min.css"
	rel="stylesheet" />
<link type="text/css"
	href="${ctxStatic}/adminlte/css/skins/skin-blue.min.css"
	rel="stylesheet" />
<link type="text/css" href="${ctxStatic}/morris/morris.css"
	rel="stylesheet" />
<link type="text/css"
	href="${ctxStatic}/jvectormap/jquery-jvectormap.css" rel="stylesheet" />

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="login-box">
		<div class="login-logo" title="JeeSite Demo">
			<a href="${ctx }/sins/demo/index"><b>JeeSite Demo</b> <small>V4.0</small></a>
		</div>
		<div class="login-box-body">
			<form id="loginForm" action="${ctx }/sins/login" method="post">
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-user form-control-feedback"
						title="登录账号"></span> <input type="text" id="username"
						name="username" value="system" class="form-control required"
						data-msg-required="请填写登录账号." placeholder="登录账号" />
				</div>
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-lock form-control-feedback"
						title="登录密码，鼠标按下显示密码"
						onmousedown="$('#password').attr('type','text')"
						onmouseup="$('#password').attr('type','password')"></span> <input
						type="password" id="password" name="password" value=""
						class="form-control required" data-msg-required="请填写登录密码."
						placeholder="登录密码" autocomplete="off" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block btn-flat"
						id="btnSubmit" data-loading="登录验证成功，正在进入..."
						data-login-valid="正在验证登录，请稍后...">立即登录</button>
				</div>
			</form>
			<div class="row">
				<div class="col-xs-12">

					<a href="/js/account/forgetPwd" class="pull-left">忘记密码</a>
				</div>
			</div>
		</div>
		<div class="login-copyright">
			&copy; 2018 JeeSite Demo - Powered By <a href="http://jeesite.com">JeeSite</a>.
		</div>
	</div>
	</div>

	<a id="scroll-up" href="#" class="btn btn-sm"><i
		class="fa fa-angle-double-up"></i></a>

</body>
</html>