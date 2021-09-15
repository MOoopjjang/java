package com.mooop.m.j8.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface Shop {
	
	int convertSyncToAsyncStep1();
	
	CompletableFuture<Integer> convertSyncToAsyncStep2();
	
	CompletableFuture<Integer> convertSyncToAsyncStep3();

}
