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
<script type="text/javascript">
		var ws;
		$(function() {
			//initWs();
			$("#send").click(function send() {
				if(ws)
					ws.send($("#message").val());
			});
			$("#open").click(function open() {
				initWs();
			});
			$("#close").click(function close() {
				if(ws)
					ws.close();
			});
		})
		
		function initWs() {
			if ("WebSocket" in window) {
				alert("您的浏览器支持 WebSocket!");

				// 打开一个 web socket
				ws = new WebSocket("ws://localhost:8082/sins/websocket");

				ws.onmessage = function(evt) {
					$("#textarea").text($("#textarea").text() + "\n" + evt.data);
					alert("数据已接收...");
				};

				ws.onclose = function() {
					// 关闭 websocket
					alert("连接已关闭...");
				};
				
				ws.onerror = function(e) {
					alert("发生异常");
					console.log(e);
				}
			} else {
				// 浏览器不支持 WebSocket
				alert("您的浏览器不支持 WebSocket!");
			}
		}
		
	</script>
	
</head>
<body>
	<div id="sin-audio"></div>
	<script type="text/javascript">
		$(function() {
			initAudio($("#sin-audio"));
		})
	</script>
	<input id="open" type="button" value="连接"/><input id="close" type="button" value="断开"/><br/>
	<input id="message" type="text"/><input id="send" type="button" value="发送"/><br/>
	<textarea rows="10" cols="100" id="textarea" enabled></textarea>
</body>
</html>