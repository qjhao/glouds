<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主子表测试</title>
<script type="text/javascript">

	var data = {
			name : "JohnSin",
			age : 18
	}
	$(function() {
		$("#name").val(data.name);
		$("#age").val(data.age);
	})
	function openDialog1() {
		$.dialog({id:"dialog1",lock:true,"title" : "title", "content" : "url:${ctx}/sins/demo/demo?name=lhgChildFunctionDemo", width:400, height: 400, zIntex: 300});
	}
	
	function getName() {
		return $("#name").val();
	}
	
	function getAge() {
		return $("#age").val();
	}
	
</script>

</head>
<body>
	<input type="text" name="name" id="name"/><br>
	<input type="text" name="age" id="age"/><br>
	<button class="btn btn-primary" onclick="openDialog1()">打开子页面</button>
</body>
</html>