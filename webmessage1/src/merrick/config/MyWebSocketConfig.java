package merrick.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import merrick.util.SockHandler;


@Configuration
@EnableWebSocket
public class MyWebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry whr) {
//		whr.addHandler(sockhdl(), "/sock");//OK//无需jackson库
		
		whr.addHandler(sockhdl(), "/sockjs/**").withSockJS();
		/**
		 * 
		 * 对于Spring4.2.5，要使用SockJS，还必须使用Jackson2的jar，版本必须是低版本2.7，若使用2.8版本会如下出错：
		 *java.lang.IllegalStateException:  A SockJsMessageCodec is required but not available: Add Jackson 2 to the classpath, or configure a c
		 * 
		 * 
		 * */

	}
	
	@Bean
	public SockHandler sockhdl() {
		return new SockHandler();
	}

}
