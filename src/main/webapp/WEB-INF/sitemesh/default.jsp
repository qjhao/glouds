<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="./taglib.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: auto; overflow-y: auto;">
<head>
<title><sitemesh:write property="title"/> ---asdfas</title>
<link rel="icon" type="image/x-icon" href="${ctxStatic}/icons/wang.ico" />
<%@include file="./head.jsp"%>
<sitemesh:write property="head"/>
</head>
<body>
	<sitemesh:write property="body"/>
</body>
</html>