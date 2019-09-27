package merrick.util;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;



public class SockHandler extends AbstractWebSocketHandler {
	private static Logger log =  LogManager.getLogger(SockHandler.class);	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("[Received text:]"+  message.getPayload());
		Thread.sleep(2000);
		
		session.sendMessage(new TextMessage("[ServerSide]["+LocalDateTime.now().toString()+"]OK"));
	}
	

}
