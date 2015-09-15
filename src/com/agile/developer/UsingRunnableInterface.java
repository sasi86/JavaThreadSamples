package com.agile.developer;

class Process implements Runnable {
	public void run() {
		for(int i=1; i<=10 ;i++){
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
}

public class UsingRunnableInterface {
	
	public static void main(String[] args) {
		Process p1 = new Process();
		Thread t1= new Thread(p1);
		t1.start();
		
		Process p2 = new Process();
		Thread t2= new Thread(p2);
		t2.start();
	}
}
