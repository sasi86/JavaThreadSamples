package com.agile.developer;

class Runner extends Thread{
	@Override
	public void run() {
		for(int i=1; i<=10 ;i++){
			System.out.println(i+" "+this.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

public class UsingThreadClass  {
	public static void main(String[] args) {
		Runner r1= new Runner();
		r1.setName("T1");
		r1.start();
		
		Runner r2= new Runner();
		r2.setName("T2");
		r2.start();
		
	}
	
}
