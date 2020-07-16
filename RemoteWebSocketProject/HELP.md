
# Architecture
### Server[ SpringBoot | P:8080 | Publisher] --> (31313)RabbitMQ(15674) --> WebClient[ SpringBoot + Thymeleaf | P:9080 | Subscriber ]


# RabbitMQ ( Docker ) 설치및 실행
1. rabbitmp + stomp image 다운로드 및 실행

    - docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -p 31313:31313 -p 15674:15674 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=test -e RABBITMQ_DEFAULT_PASS=test rabbitmq:management
              
2. rabbitmq shell접속

    - docker exec -it rabbitmq /bin/bash

3. plugin list 에서 rabbitmq_stomp , rabbitmq_web_stomp 확인

    - rabbitmq-plugins list

4. 기능 활성화

    - rabbitmq-plugins enable rabbitmq_stomp
    - rabbitmq-plugins enable rabbitmq_web_stomp

5. rabbitmq STOMP 포트 외부접근 허용

    - vi /etc/rabbitmq/rabbitmq.conf
    - stomp.listeners.tcp.1 = 31313 추가


# Project 구조
WebSocketDemoProject

* Publisher 
* port : 8080
* url : http://localhost:8080/wsc/main_page

WebSocketDemoClient

* Subscriber
* port : 9080
* url : http://localhost:9080/wsc/main

# TEST
Postman

* Method : GET
* http://localhost:8080/wsc/socket?text=1
* http://localhost:8080/wsc/socket?text=2
* http://localhost:8080/wsc/socket?text=3
* ...
