<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主子表测试</title>
<script type="text/javascript">
	function openDialog1() {
		var api = frameElement.api;
		$.dialog({id:"dialog1",parent:api,lock:true,"title" : "title", "content" : "url:${ctx}/sins/demo/demo?name=lhgDemo", width:100, height: 100, zIntex: 300});
	}
	function openDialog2() {
		var api = frameElement.api;
		$.dialog({id:"dialog2",parent:api,lock:true,"title" : "title", "content" : "url:${ctx}/sins/demo/demo?name=lhgDemo", width: 200, height: 200, zIndex: 200});
	}
	function openDialog3() {
		$.dialog({id:"dialog3","title" : "title", "lock" : true, "content" : "url:${ctx}/sins/demo/demo?name=lhgDemo", width: 400, height : 400, zIndex: 100, close : function() {lock();}});
	}
	var dialog;
	function showDialog() {
		if(dialog) {
			dialog.show();
		}else {
			dialog = $.dialog({"title" : "title", "lock" : true, "content" : "url:${ctx}/sins/demo/demo?name=lhgDemo", width: 200, height : 200, zIndex: 200, close : function() {lock();}})
		}
	}
	
	function hideDialog() {
		if(dialog) {
			dialog.hide();
			var api = frameElement.api;
			api.lock();
		}else {
			var api = frameElement.api;
			var opener = api.opener
			opener.hideDialog();
		}
	}
	
	function lock() {
		if(frameElement) {
			var api = frameElement.api;
			api.lock();
		}
	}
</script>

</head>
<body>
	<button class="btn btn-primary" onclick="openDialog1()">添加</button>
	<button class="btn btn-default" onclick="openDialog2()">添加</button>
	<button class="btn btn-info" onclick="openDialog3()">添加</button>
	<button class="btn btn-success" onclick="showDialog()">显示</button>
	<button class="btn btn-warning" onclick="hideDialog()">隐藏</button>
</body>
</html>