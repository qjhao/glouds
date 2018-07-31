<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主子表测试</title>
<script type="text/javascript">
	var datas = [];
	/* for(var i=1;i<6;i++) {
		var data = {
				name : "name" + i,
				desc : "desc" + i
		}
		datas.push(data);
	} */
	
	$(function() {
		$("#table").bootstrapTable({
			data : datas,
			striped : true, //是否显示行间隔色
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性(*)
			pagination : true, //是否显示分页(*)
			sortable : true, //是否启用排序
			sortOrder : "desc", //排序方式
			sidePagination : "client", //分页方式：client客户端分页，server服务端分页(*)
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 10, //每页的记录行数(*)
			pageList : [ 20, 50, 100 ], //可供选择的每页的行数(*)
			search : true, //是否显示表格搜索，此搜索是客户端搜索
			strictSearch : true, //精确查找
			showColumns : true, //是否显示所有的列
			showRefresh : false, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			height : 800,
			uniqueId : "name", //每一行的唯一标识，一般为主键列
			showToggle : true, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			showExport : true,//按格式导出
			exportDataType : "basic",
			exportTypes : [ 'txt', 'doc', 'excel', 'xlsx' ],
			queryParamsType : "limit",
			//              toolbar: tb, //工具按钮用哪个容器
			checkboxHeader : true,
			singleSelect : true,
			showColumns : true, // 开启自定义列显示功能
			onCheck : function(row) {

			},
			queryParams : function queryParams(params) { //设置查询参数
				return params;
			},
			onLoadSuccess : function() { //加载成功时执行 
				console.log("数据加载成功!");
			},
			onLoadError : function() { //加载失败时执行  
				console.log("加载数据失败");
			},
			//注册加载子表的事件。注意下这里的三个参数！
			onExpandRow : function(index, row, $detail) {
				console.log("lala");
			},
			columns : [ {
				field : "name",
				title : "名称",
				width: 200,
				editable : {
					type : "number",
					mode : "inline",
					placement : "top",
					validate : function(value) {
						if(isNaN(value))
							return "只能输入数字";
					},
					clear : true,
					defaultValue : "1"
				}
			}, {
				field : "desc",
				title : "描述",
				width:200,
				editable : {
					type : "text",
					placement : "top",
					validate : function(value) {
						if(isNaN(value))
							return "只能输入数字";
					},
					clear : true,
					defaultValue : "1"
				}
			}, {
				field : "desc",
				title : "描述",
				width:200,
				editable : {
					type : "number",
					placement : "top",
					validate : function(value) {
						
					},
					clear : true,
					defaultValue : "1"
				}
			}, {
				field : "desc",
				title : "描述",
				width:200,
				editable : {
					type : "number",
					placement : "top",
					validate : function(value) {
						
					},
					clear : true,
					defaultValue : "1"
				}
			}, {
				field : "desc",
				title : "描述",
				width:200,
				editable : {
					type : "number",
					placement : "top",
					validate : function(value) {
						
					},
					clear : true,
					defaultValue : "1"
				}
			}, {
				field : "desc",
				title : "描述",
				width:200,
				editable : {
					type : "number",
					placement : "top",
					validate : function(value) {
						
					},
					clear : true,
					defaultValue : "1"
				}
			}, {
				field : "desc",
				title : "描述",
				width:200,
				editable : {
					type : "number",
					placement : "top",
					validate : function(value) {
						
					},
					clear : true,
					defaultValue : "1"
				}
			} ]
		});
	})
	
	function addData() {
		var data = {
				name : "dataadd",
				desc : "datadesc"
		}
		datas.push(data);
		$("#table").bootstrapTable("load", datas);
		console.log($("#table").bootstrapTable("getData"));
	}
</script>

</head>
<body>
	<button class="btn btn-primary" onclick="addData()">添加</button>
	<table id="table"></table>
</body>
</html>