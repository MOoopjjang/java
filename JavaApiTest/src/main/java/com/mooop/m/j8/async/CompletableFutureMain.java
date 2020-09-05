package com.mooop.m.j8.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMain {
	
	/**
	 * 1. Executor를 통해 비동기 타스크가 수행될 쓰레드를 생성하고
	 * 2. CompletableFuture.runAsync를 통해 다른 쓰레드에서 비동기 식으로 동작할 로직을 선언하고
	 * 3. CompletableFuture.thenRun 를 통해 첫번째 타스크가 완료된 이후에 연속적으로 동작할 로직을 선언했다.
	 * 
	 * @throws Exception
	 */

	private static void tst_1() throws Exception{
		
		ExecutorService executors = Executors.newCachedThreadPool();
		
		CompletableFuture.runAsync(()->{
			try{
				System.out.println("Hello~~");
				Thread.sleep(5000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		} , executors)
		.thenRun(()->System.out.println("World"));
		
		System.out.println("Main End!!!");
	}
	
	/**
	 * Pattern 1 -  연속적 연결
	 * thenApply
	 * public <U> CompletionStage<U> thenApply (Function<? super T, ? extends U> fn);
	 * 
	 *  then 이라는 접두어는 앞의 타스크들은 모두 반드시 완료되어야 한다는 의미이다. 앞의 타스크들은 하나혹은 두개일수 있다.
	 *  Apply라는 동사는 뒤에 Function형 람다식이 올거라는 것을 의미한다
	 *  Function형은 첫번째 임의의 형태<T>의 입력값을 받아 처리한후 두번째 임의의 형태<R>의 값으로 출력하는 람다식이다.
	 * 
	 * @throws Exception
	 */

	private static void tst_2() throws Exception{ 
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			return "result A on thread "+Thread.currentThread().getId();
		} , executor)
		.thenApply(str->str+"+ tailed")
		.thenAccept(System.out::println);
		System.out.println("Task execution requested on on thread "+Thread.currentThread().getId());
	}
	
	/**
	 * Pattern 1 -  연속적 연결
	 * thenRunAsync
	 * public CompletionStage<void> thenRunAsync(Runnable action, Executor executor);
	 * Run이라는 동사의 의미는 인자를 받지 않고 결과를 리턴하지 않는 타스크입력값을 받는 다는 의미이다. 
	 * 
	 * @throws Exception
	 */

	private static void tst_3() throws Exception{
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletableFuture.runAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("runAsync on thread "+Thread.currentThread().getId());
		} , executor)
		.thenRunAsync(()->System.out.println("thenRunAsync on thread "+Thread.currentThread().getId()));
		
		System.out.println("Task execution requested on thread "+Thread.currentThread().getId());
	}
	
	/**
	 * Pattern 2 - 타스크 간의 조합
	 * ComletableFuture 의 수행중 완전히 다른 CompletableFuture 를 조합하여 실행할수 있다
	 * thenComposeAsync
	 * public CompletionStage<void>  thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn);
	 * 
	 * 실행되고 있는 타스크안에서 람다식을 통해 다른 CompletionStage 타스크를 조합할수 있다. 여기서 조합이라는 의미는 완료시점을 하나로 맞출수 있다는
	 * 뜻이다. thenComposeAsync 는 중복적으로 사용되어 여러 타스크를 조합할수가 있다. 예를 들어 웹서버에서 하나의 리퀴스트를 받아 4개의 내부 리퀘스트를
	 * 
	 * 보낸후 결과를 모두 취합하여 최초 리퀘스트에 리턴해줄 필요가 있을때 적당하다
	 * 
	 * 결과분석 )
	 * 
	 * cf1,  cf2, cf3 3개의 타스크가 supplyAsync 메소드를 통해 동시에 실행되었다.
	   cf1은 5초, cf2는 1초, cf3는 3초가 각각소요되었다. 모두 다른 타이밍에 결과값이 도출되었고 이중 가장 오래걸린것은 cf1으로 5초인데,
	   thenComposeAsync를 사용해 cf3,cf2,cf1이 조합되었고, join을 통해 동시점에 완료가 되는 타스크 조합이 만들어졌다.
	   join()이 호출된 후에는 세 타스크 모두 결과값이 완료되었기 때문에  get을 통해 값을 호출해 사용할수 있다.

	 * @throws Exception
	 */

	private static void tst_4() throws Exception{
		ExecutorService es = Executors.newCachedThreadPool();
		long startTime = System.nanoTime();
		
		CompletableFuture cf1 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf1 supplyAsync on thread "+Thread.currentThread().getId()+" now="+(System.nanoTime() - startTime));
			return 100;
		} , es);
		
		CompletableFuture cf2 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf2 supplyAsync on thread "+Thread.currentThread().getId()+" now="+(System.nanoTime() - startTime));
			return 200;
		},es);
		
		CompletableFuture cf3 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf3 supplyAsync on thread "+Thread.currentThread().getId()+" now="+(System.nanoTime() - startTime));
			return 300;
		} , es);
		
		cf3.thenComposeAsync((data1)->cf2).thenComposeAsync((data2)->cf1).join();
		System.out.println("final cf1.get() = " + cf1.get()+ " cf2.get()="+cf2.get()+" cf3.get()="+cf3.get()+" now="+(System.currentTimeMillis()-startTime));

	}
	
	/**
	* 
	* Pattern 3 -  두 타스크들 결과를 모두 사용한 타스크간 결합 
		: 두 타스크의 결과를 모두 기다렸다가 결과들을 조합하여 그다음 일을 하는것)
	* thenCombineAsync
			public <U,V> CompletionStage<V> thenCombineAsync(CompletionStage<U> other, BiFunction<T,U,V> function);
			=> 앞의 타스크와 파라미터로 받은 타스크의 결과를 입력값으로 받아서 새로운 결과를 리턴한다. get으로서 결과를 얻을수 있다.

	* 
	* 
	*/

	private static void tst_5() throws Exception{
		ExecutorService es = Executors.newCachedThreadPool();
		
		CompletableFuture cf1 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println("cf1 supplyAsync on thread :"+Thread.currentThread().getId());
			return 100;
		} , es);
		
		CompletableFuture cf2 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf2 supplyAsync on thread : "+Thread.currentThread().getId());
			return 200;
		} , es)
		.thenCombineAsync(cf1 ,  (Integer x , Integer y)->{
			System.out.println("x :"+x+" , y : "+y);
			return x*y;
		});
		System.out.println("Task Execution rquested on thread :"+Thread.currentThread().getId());
		System.out.println("final result = "+cf2.get());
	}
	
	/**
	* 
	* * thenAcceptBoth
		public <U> CompletionStage<Void> thenAcceptBoth(CompletionStage<U> other, BiConsumer<T,U> action);
			=> 앞의 타스크의 결과, 파라미터로 받은 타스크의 결과를 받아 리턴은 하지않고 결과를 소비하는 패턴이다.
	* 
	* @throws Exception
	*/

	public static void tst_6() throws Exception{
		ExecutorService executor = Executors.newCachedThreadPool();
		
		CompletableFuture cf1 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(3000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf1 supplyAsync on Thread :"+Thread.currentThread().getId());
			return 500;
		},executor );
		
		
		CompletableFuture cf2 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf2 supplyAsync on Thread :"+Thread.currentThread().getId());
			return 300;
		},executor)
		.thenAcceptBothAsync(cf1, (x,y)->System.out.println("x:"+x+" , y:"+y));
		System.out.println("Task execution requested on Thread :"+Thread.currentThread().getId());
		System.out.println("cf2 result :"+cf2.get());
		
	}
	
	/**
	* 
	* 
	* * runAfterBothAsync
		public CompletionStage<Void> runAfterBothAsync
	   	 (CompletionStage<?> other, Runnable action, Executor executor);
			=> 앞의 타스크의 완료, 파라미터로 받은 타스크의 완료이후에 아무런 파라미터를 받지 않고 로직을 수행한다. 리턴은 하지 않는다.
	* 
	* 
	* @throws Exception
	*/

	private static void tst_7() throws Exception{
		ExecutorService es = Executors.newCachedThreadPool();
		
		CompletableFuture cf1 = CompletableFuture.supplyAsync(()->{
			
			try{
				Thread.sleep(5000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf1 supplyAsync on Thread :"+Thread.currentThread().getId());
			return 100;
		},es);
		
		CompletableFuture cf2 = CompletableFuture.supplyAsync(()->{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("cf2 supplyAsync on Thread :"+Thread.currentThread().getId());
			return 200;
		},es)
		.runAfterBothAsync(cf1, ()->System.out.println("runAfterBothAsync on thread "+Thread.currentThread().getId()));
		System.out.println("Task execution request on thread "+Thread.currentThread().getId());
		System.out.println("final result = "+cf2.get());
	}
	
	
	
	
	private static void tst_8() throws Exception{
		
	}
	
	
	public static void main(String[] args) {
		
		try{
//			tst_1();
			
//			tst_2();
			
//			tst_3();
			
//			tst_4();
			
//			tst_5();
			
//			tst_6();
			
			tst_7();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
