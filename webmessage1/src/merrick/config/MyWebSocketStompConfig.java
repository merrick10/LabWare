package merrick.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages= {"merrick.control"})//注意相关controller的配置
public class MyWebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stompsockjs").setAllowedOrigins("*").withSockJS();
	}
	
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {		
		
//		registry.enableSimpleBroker("/queue","/topic");//
		
		registry.enableStompBrokerRelay("/topic","/queue")
				.setRelayHost("localhost")
				.setRelayPort(61613)
				.setClientLogin("admin")
				.setClientPasscode("password")
				.setSystemHeartbeatSendInterval(0)
				.setSystemHeartbeatReceiveInterval(0);
		//broker为activemq为什么没有立即转发订阅的问题，待研究。。。。。。
		
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	
	
	

}
