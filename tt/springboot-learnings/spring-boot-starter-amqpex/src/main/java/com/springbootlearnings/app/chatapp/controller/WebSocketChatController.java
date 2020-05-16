package com.springbootlearnings.app.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.springbootlearnings.app.chatapp.model.WebSocketChatMessage;

@Controller
public class WebSocketChatController {

	/*
	 * @MessageMapping("/chat.sendMessage")
	 * 
	 * @SendTo("/topic/chatuse") public WebSocketChatMessage sendMessage(@Payload
	 * WebSocketChatMessage webSocketChatMessage) { return webSocketChatMessage; }
	 */

	@MessageMapping("/chat.newUser")
	@SendTo("/topic/chatuse")
	public WebSocketChatMessage newUser(@Payload WebSocketChatMessage webSocketChatMessage,
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", webSocketChatMessage.getSender());
		return webSocketChatMessage;
	}

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public WebSocketChatMessage sendMessag(@Payload WebSocketChatMessage chatMessage) {
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public WebSocketChatMessage addUser(@Payload WebSocketChatMessage chatMessage,
			SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

}