package com.agile.developer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {
	
	Runnable task1 = () -> {
		this.task1();
	};
	
	Callable<Integer> task2 = () -> {
		return this.task2();
	};

	public ExecutorServiceSample() {
		
	}
	
	private Integer task2() {
		System.out.println("--Task : "+Thread.currentThread().getName());
		return 1;
	}

	private void task1() {
		System.out.println("Task : "+Thread.currentThread().getName());
	}
	
	private ExecutorService runningTaskWithFixedThreadPool() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			executorService.submit(task1);
		}
		return executorService;
	}
	
	private ExecutorService runningTaskWithSingleThreadPool() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			Future<Integer> result = executorService.submit(task2);
			System.out.println(result.get());
		}
		return executorService;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorServiceSample executorService = new ExecutorServiceSample();
		
		executorService.runningTaskWithSingleThreadPool().shutdown();
		
		executorService.runningTaskWithFixedThreadPool().shutdown();
	}

}
