package com.springbootlearnings.app.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableStompBrokerRelay("/topic").setRelayHost("localhost").setRelayPort(61613).setClientLogin("user")
				.setClientPasscode("user").setSystemLogin("user").setSystemPasscode("user");

		// config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/app").setAllowedOrigins("*").withSockJS();
	}
}

/*
 * package com.springbootlearnings.app.chatapp.config;
 * 
 * @Configuration
 * 
 * @EnableWebSocketMessageBroker public class WebSocketConfig implements
 * WebSocketMessageBrokerConfigurer {
 * 
 * @Override public void registerStompEndpoints(StompEndpointRegistry registry)
 * { registry.addEndpoint("/ws").withSockJS(); }
 * 
 * @Override public void configureMessageBroker(MessageBrokerRegistry registry)
 * { registry.setApplicationDestinationPrefixes("/app");
 * registry.enableSimpleBroker("/topic"); // Enables a simple in-memory broker
 * 
 * 
 * // Use this for enabling a Full featured broker like RabbitMQ
 * 
 * 
 * registry.enableStompBrokerRelay("/topic") .setRelayHost("localhost")
 * .setRelayPort(61613) .setClientLogin("guest") .setClientPasscode("guest");
 * 
 * } }
 */