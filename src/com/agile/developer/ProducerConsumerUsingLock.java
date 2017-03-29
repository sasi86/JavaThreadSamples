package com.agile.developer;

import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLock {

	static Stack<Integer> product = new Stack<>();
	static Integer count = 0;
	static Lock lock = new ReentrantLock();
	static Condition emptyNot = lock.newCondition();
	static Condition empty = lock.newCondition();

	static class Producer implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {

			return produce();
		}

		public int produce() throws InterruptedException {
			try {
				lock.lock();
				if (!product.isEmpty()) {
					emptyNot.await();
				}
				product.push(count++);
				empty.signalAll();
			} finally {
				lock.unlock();
			}

			return count;
		}

	}

	static class Consumer implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			return consume();
		}

		public int consume() throws InterruptedException {
			try {
				lock.lock();
				if (product.isEmpty()) {
					empty.await();
				}
				product.pop();
				emptyNot.signalAll();
			} finally {
				lock.unlock();
			}

			return count;
		}
	}

	public static void main(String[] args) {

		Consumer consumer = new Consumer();
		Producer producer = new Producer();
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(2);

			for (int i = 1; i <=100; i++) {
				Future<Integer> res1 =service.submit(consumer);
				Future<Integer> res = service.submit(producer);
				try {
					System.out.println("Produced : "+res.get());
					System.out.println("Consumed : "+res1.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} finally {
			service.shutdown();
		}

	}

}
