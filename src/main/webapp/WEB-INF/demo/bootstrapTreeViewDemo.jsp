<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../sitemesh/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bootstrap树形测试</title>
<script src="${ctxStatic}/bootstrap-treeview/bootstrap-treeview.js" type="text/javascript"></script>

<link href="${ctxStatic}/bootstrap-treeview/bootstrap-treeview.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	$(function() {
		$("#tree").treeview({
			data: getTree(), //data属性是必须的，是一个对象数组    Array of Objects.
		    color: "", //所有节点使用的默认前景色，这个颜色会被节点数据上的backColor属性覆盖.        String
		    backColor: "#FFFFFF", //所有节点使用的默认背景色，这个颜色会被节点数据上的backColor属性覆盖.     String
		    borderColor: "#000000", //边框颜色。如果不想要可见的边框，则可以设置showBorder为false。        String
		    nodeIcon: "glyphicon glyphicon-stop", //所有节点的默认图标
		    checkedIcon: "glyphicon glyphicon-check", //节点被选中时显示的图标         String
		    collapseIcon: "glyphicon glyphicon-minus", //节点被折叠时显示的图标        String
		    expandIcon: "glyphicon glyphicon-plus", //节点展开时显示的图标        String
		    emptyIcon: "glyphicon", //当节点没有子节点的时候显示的图标              String
		    enableLinks: true, //是否将节点文本呈现为超链接。前提是在每个节点基础上，必须在数据结构中提供href值。        Boolean
		    highlightSearchResults: true, //是否高亮显示被选中的节点        Boolean
		    levels: 3, //设置整棵树的层级数  Integer
		    multiSelect: false, //是否可以同时选择多个节点      Boolean
		    onhoverColor: "#F5F5F5", //光标停在节点上激活的默认背景色      String
		    selectedIcon: "glyphicon glyphicon-stop", //节点被选中时显示的图标     String

		    searchResultBackColor: "", //当节点被选中时的背景色
		    searchResultColor: "", //当节点被选中时的前景色

		    selectedBackColor: "", //当节点被选中时的背景色
		    selectedColor: "#AAAAAA", //当节点被选中时的前景色

		    showBorder: true, //是否在节点周围显示边框
		    showCheckbox: false, //是否在节点上显示复选框
		    showIcon: true, //是否显示节点图标
		    showTags: true, //是否显示每个节点右侧的标记。前提是这个标记必须在每个节点基础上提供数据结构中的值。
		    uncheckedIcon: "glyphicon glyphicon-unchecked", //未选中的复选框时显示的图标，可以与showCheckbox一起使用
		})
	})
	
	function getTree() {
		//节点上的数据遵循如下的格式：
	    var tree = [{
	        text: "Node 1", //节点显示的文本值  string
	        state: { //描述节点的初始状态    Object
	            checked: true, //是否选中节点
	            /*disabled: true,*/ //是否禁用节点
	            expanded: true, //是否展开节点
	            selected: true //是否选中节点
	        },
	        tags: ['标签信息1', '标签信息2'], //向节点的右侧添加附加信息（类似与boostrap的徽章）    Array of Strings
	        nodes: [{
	            text: "Child 1",
	            nodes: [{
	                text: "Grandchild 1",
	                href: "#http://www.baidu.com"
	            }, {
	                text: "Grandchild 2"
	            }]
	        }, {
	            text: "Child 2"
	        }]
	    }, {
	        text: "Parent 2",
	        nodes: [{
	            text: "Child 2",
	            nodes: [{
	                text: "Grandchild 3"
	            }, {
	                text: "Grandchild 4"
	            }]
	        }, {
	            text: "Child 2"
	        }]
	    }, {
	        text: "Parent 3"
	    }, {
	        text: "Parent 4"
	    }, {
	        text: "Parent 5"
	    }];

	    return tree;
	}
</script>

</head>
<body>
	<div id="tree" style="width:30%"></div>
</body>
</html>