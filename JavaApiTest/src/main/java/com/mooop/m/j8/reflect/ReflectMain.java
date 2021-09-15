package com.mooop.m.j8.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectMain {
	
	
	
	private static void print(QueueComponent qccomponent) {
		System.out.println("=============================================");
		System.out.println("all size : "+qccomponent.size());
		System.out.println("person size : "+qccomponent.get("person").size());
		System.out.println("job size : "+qccomponent.get("job").size());
		System.out.println("=============================================");
	}
	
	
	private static<T> void tst1( Class<T> cls) {
		
		System.out.println(cls.getSimpleName());
		System.out.println("=============================================");
		Arrays.asList(cls.getDeclaredMethods()).stream().forEach(m->{System.out.println(m.getName());});
	}
	
	
	
	
	
	private static void tst2() {
		QueueComponent qccomponent = new QueueComponent();
		qccomponent.registry("person", Person.class);
		qccomponent.registry("job", Job.class);
		print(qccomponent);
		
		
		qccomponent.add("person", new Person("cwkim" , 20));
		qccomponent.add("job", new Job("it" , 20000L , "programmer"));
		qccomponent.add("person", new Person("bhkim" , 40));
		print(qccomponent);
		Person p = qccomponent.pop("person");
		System.out.println(p.toString());
		Job j = qccomponent.pop("job");
		System.out.println(j.toString());
		print(qccomponent);
	}


	/**
	 *  method set 테스트...
	 */
	private static void tst3()  {

		try{
			String methodName = "setT2";
			UserInfo ui = new UserInfo();
			Method[] methods = ui.getClass().getDeclaredMethods();
			for(Method m : methods){
				if(methodName.equals(m.getName())){
					m.setAccessible(true);
					m.invoke(ui , 10);
					break;
				}
			}

			System.out.println("getT2 : "+ui.getT2());
		}catch(Exception e){
			e.printStackTrace();
		}


	}
	
	
	public static void main(String[] args) {
//		print();
		
//		tst1(Person.class);
		
//		tst2();

		tst3();
	}

}
