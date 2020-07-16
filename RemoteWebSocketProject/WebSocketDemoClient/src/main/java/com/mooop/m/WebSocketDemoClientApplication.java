package com.mooop.m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 
 * 서로다른 서버간에 WebSocket을 이용한 통신기능 제공 ( 
 *  - Clinet + Subscriber
 * 
 * 구조 :
 * 	- Publisher(8080) --> (31316 )RabbitMQ(15674) --> Subscriber(9080 )
 * 
 * @author MOoop
 *
 */
@SpringBootApplication
public class WebSocketDemoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketDemoClientApplication.class, args);
	}

}
