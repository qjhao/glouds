<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主子表测试</title>
<script type="text/javascript">
	function showName() {
		var api = frameElement.api;
		var opener = api.opener;
		alert(opener.getName());
	}
	
	function showAge() {
		var api = frameElement.api;
		var opener = api.opener;
		alert(opener.getAge());
	}
</script>

</head>
<body>
	<button class="btn btn-primary" onclick="showName()">name</button>
	<button class="btn btn-default" onclick="showAge()">age</button>
</body>
</html>