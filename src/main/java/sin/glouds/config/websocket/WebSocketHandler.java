package sin.glouds.config.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
	
	private static Logger logger = Logger.getLogger(WebSocketSession.class);
	private static List<WebSocketSession> users = new ArrayList<>();

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("=====================");
		logger.info("HandleTextMessage");
		logger.info(message);
		System.out.println(sendMessage(session, message));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		if(users.contains(session))
			users.remove(session);
		logger.info("关闭WebSocket连接");
		Map<String, Object> map = session.getAttributes();
		map.keySet().forEach(key -> System.out.println(key + " : " + map.get(key)));
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		logger.info("建立WebSocket连接");
		Map<String, Object> map = session.getAttributes();
		map.keySet().forEach(key -> System.out.println(key + " : " + map.get(key)));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if(users.contains(session))
			users.remove(session);
		logger.info("WebSocket连接异常");
		Map<String, Object> map = session.getAttributes();
		map.keySet().forEach(key -> System.out.println(key + " : " + map.get(key)));
	}
	
	private static boolean sendMessage(WebSocketSession session, TextMessage message) throws IOException {
		if(session.isOpen()) {
			session.sendMessage(message);
			return true;
		}
		return false;
	}
	
	private static boolean sendMessage(WebSocketSession session, String message) throws IOException {
		TextMessage textMessage = new TextMessage(message, false);
		return sendMessage(session, textMessage);
	}

	public static boolean sendMessage(String message, String username) throws IOException {
		for(WebSocketSession session : users) {
			if(username.equals(session.getAttributes().get("WEBSOCKET_USERNAME"))) {
				TextMessage textMessage = new TextMessage(message, false);
				return sendMessage(session, textMessage);
			}
		}
		return false;
	}
	
	public static boolean sendMessage(String message) throws IOException {
		for(WebSocketSession session : users) {
			sendMessage(session, message);
		}
		return true;
	}
}
