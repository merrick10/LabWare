package merrick.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


@Configuration
@EnableWebSocketMessageBroker
public class MyWebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stompsockjs").withSockJS();
	}
	
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {		
		
		//registry.enableSimpleBroker("/stompqueue","/stomptopic");//
		
		registry.enableStompBrokerRelay("/topic","/queue")
				.setRelayHost("localhost")
				.setRelayPort(61613)
				.setClientLogin("admin")
				.setClientPasscode("password");
		
		registry.setApplicationDestinationPrefixes("/stompapp");
	}
	
	
	
	

}