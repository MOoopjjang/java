package com.mooop.m;

import java.util.HashSet;
import java.util.Set;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;


@Component("wsHandler")
public class WsHandler implements ChannelInterceptor{
	
	Set<String> sessionSet = new HashSet<>();

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		StompCommand command = StompHeaderAccessor.wrap(message).getCommand();
		System.out.println(">>> preSend[command: " + command + "]");
		return message;
	}

	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String sessionId = accessor.getSessionId();
		StompCommand command = accessor.getCommand();

		System.out.println(">>> postSend[command: " + command + "]");

		switch (command) {
		case CONNECT:
			sessionSet.add(sessionId);
			System.out.println(sessionId + "(" + accessor.getHost() + ") 접속 시작");
			System.out.println("message: " + message.toString());
			System.out.println("accessor: " + accessor.toString());
			System.out.println("channel: " + channel.toString());
			break;
		case DISCONNECT:
			sessionSet.remove(sessionId);
			System.out.println(sessionId + "(" + accessor.getHost() + ") 접속 종료");
			break;
		case SEND:
			System.out.println(sessionId + "(" + accessor.getHost() + ") send: " + message.toString());
		default:
			break;
		}

		System.out.println("session count: " + sessionSet.size());

	}

}
