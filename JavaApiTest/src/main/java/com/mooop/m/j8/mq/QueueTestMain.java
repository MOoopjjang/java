package com.mooop.m.j8.mq;


/**
 * Multi Queue 테스트코드
 *   - Multi Queue 개발시 Class에 종속되지 않는 T  , P type의 QueueComponent 개발을 위한 테스트
 *   - 각각의 Queue에 저장할 type을 interface로 받아서 , 동적으로 Queue를 생성하는 방향으로 개선 예정
 *   
 * @author MOoop
 *
 */
public class QueueTestMain {
	
	
	public static void main(String[] args) {
		QueueComponent<Person , Monster > qc = new QueueComponent<>();
		
		qc.load(QueueComponent.Q1_TAG).push(new Person("cwkim" , 20));
		qc.load(QueueComponent.Q2_TAG).push(new Monster("animal", "knee", "asia"));
		
		
		Person p = (Person) qc.load(QueueComponent.Q1_TAG).pop();
		System.out.println(p.toString());
		
		Monster m = (Monster) qc.load(QueueComponent.Q2_TAG).pop();
		System.out.println(m.toString());
	}

}
