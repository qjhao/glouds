<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mc</title>
<link href="${ctxStatic}/mycss/mymusic.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ctxStatic}/myjs/mymusic.js"></script>
</head>
<body>
	<div id="sin-audio"></div>
	<script type="text/javascript">
		$(function() {
			initAudio($("#sin-audio"));
		})
	</script>
</body>
</html>