package com.mooop.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@EnableWebSocketMessageBroker
@Configuration
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Autowired
	WsHandler wsHandler;
	
	@Autowired
	WsHandshakeInterceptor wsHandshakeInterceptor;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")
//				.addInterceptors(wsHandshakeInterceptor)
				.setAllowedOrigins("*")
				.withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
//		registry.enableSimpleBroker("/subscribe");
		registry.enableStompBrokerRelay("/topic/")
				.setVirtualHost("/")
				.setRelayHost("localhost")
				.setRelayPort(31313)
				.setClientLogin("test")
				.setClientPasscode("test123")
				.setSystemLogin("test")
				.setSystemPasscode("test123")
				.setSystemHeartbeatSendInterval(5000)
				.setSystemHeartbeatReceiveInterval(5000)
				.setAutoStartup(true)
				;
	}
	
	
	
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(wsHandler);
	}

}
