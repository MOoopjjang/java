package com.mooop.m.demo.fmg;

public class FmgTestMain {
	
	
	static class T1 extends UiSubscriber<Object>{
		
		public T1() {
			FmgEventManager.getInstance().registry(this , FMG_ACTION_EVENT.SEARCH_END,FMG_ACTION_EVENT.TMP);
		}
		
		@Override
		public void onNext(Object t) {
			System.out.println("T1");
		}
	}
	
	static class T2 extends UiSubscriber<Object>{
		
		public T2() {
			FmgEventManager.getInstance().registry(this , FMG_ACTION_EVENT.SEARCH_END);
		}
		
		@Override
		public void onNext(Object t) {
			System.out.println("T2");
		}
	}

	static class T3 extends UiSubscriber<Object>{
		
		public T3() {
			FmgEventManager.getInstance().registry(this , FMG_ACTION_EVENT.SAVE,FMG_ACTION_EVENT.TMP);
		}
	
		@Override
		public void onNext(Object t) {
			System.out.println("T3");
		}
	}
	
	
	public static void main(String[] args) {
		FmgEventManager.getInstance();
		
		
		
		T1 t1 = new T1();
		T2 t2 = new T2();
		T3 t3 = new T3();
		
		FmgEventManager.getInstance().printRegistryInformation();
		
	}

}
