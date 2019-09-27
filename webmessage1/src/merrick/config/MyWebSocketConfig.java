package merrick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import merrick.util.SockHandler;

@EnableWebSocket
public class MyWebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry whr) {
		whr.addHandler(sockhdl(), "/sock");
	}
	
	@Bean
	public SockHandler sockhdl() {
		return new SockHandler();
	}

}
