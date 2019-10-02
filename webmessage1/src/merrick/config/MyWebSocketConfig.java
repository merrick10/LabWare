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
//		whr.addHandler(sockhdl(), "/sock");//OK//����jackson��
		
		whr.addHandler(sockhdl(), "/sockjs/**").withSockJS();
		/**
		 * 
		 * ����Spring4.2.5��Ҫʹ��SockJS��������ʹ��Jackson2��jar���汾�����ǵͰ汾2.7����ʹ��2.8�汾�����³���
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
