package com.agile.developer;

import java.util.Scanner;

class DemonProcess extends Thread {
	private volatile static boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Running...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ShutdownThread(){
		running=false;
	}
}

public class UsingVolatileKeyword {
	public static void main(String[] args) throws InterruptedException {
		DemonProcess dp = new DemonProcess();
		dp.start();
		
		Scanner sc =new Scanner(System.in);
		sc.nextLine();
		dp.ShutdownThread();
		
		
	}
}
