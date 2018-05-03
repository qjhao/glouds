<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>mc</title>
	<script type="text/javascript" src="/sins/common/js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="/sins/common/js/bootstrap.min.js"></script>
	<link href="/sins/common/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="/sins/common/mycss/common.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/sins/common/js/bootstrap-table.js"></script>
	<link href="/sins/common/css/bootstrap-table.css" rel="stylesheet" type="text/css" />
	<link href="/sins/common/mycss/mymusic.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/sins/common/myjs/mymusic.js"></script>
</head>
<body>
<div id="sin-audio" style="display:none"></div>
<script type="text/javascript">
$(function() {
	initAudio($("#sin-audio"));
})
</script>
</body>
</html>