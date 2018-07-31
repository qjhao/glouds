<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GooFlow测试</title>

<link href="${ctxStatic}/gooflow/codebase/GooFlow.css" type="text/css"
	rel="stylesheet" />
<link href="${ctxStatic}/gooflow/default.css" type="text/css"
	rel="stylesheet" />

<script src="${ctxStatic}/gooflow/GooFunc.js" type="text/javascript"></script>
<script src="${ctxStatic}/gooflow/json2.js" type="text/javascript"></script>
<script src="${ctxStatic}/layer-v1.9.2/layer/layer.js"
	type="text/javascript"></script>
<script src="${ctxStatic}/gooflow/codebase/GooFlow.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		var demo = $.createGooFlow($("#demo"), {
			width : $(window).width(),
			height : $(window).height(),
			initNum : 1001,
			haveHead : true,
			initLabbelText : "新建流程图",
			haveTool : true,
			useOperStack : true,
			toolBtns : [ "start", "end", "task", "node", "state", "chat", "plug" ],
			headBtns : [ "new", "open", "save", "undo", "redo", "reload" ],
			haveGroup : true
		})
		demo.setTitle("工艺路线绘制");
		//设置左边的按钮
		demo.setNodeRemarks(remark);

		//添加数据
		demo.loadData({});
	})
	var remark = {
		cursor : "选择指针",
		direct : "转换连线",
		start : "开始结点",
		end : "结束结点",
		task : "任务结点",
		node : "自动结点",
		chat : "决策结点",
		state : "状态结点",
		plug : "附加插件",
		fork : "分支结点",
		"join" : "联合结点",
		complex : "复合结点",
		group : "组织划分框编辑开关"
	};
</script>

</head>
<body>
	<div id="demo"></div>
</body>
</html>