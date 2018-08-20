package com.revature.threads;

public class SyncDemoDriver {

	public static void main(String[] args) {
		
		StringBuilder sbuild = new StringBuilder();
		StringBuffer sbuffer = new StringBuffer();
		Runnable job = new StringTestRunnable();
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
		t1.start();
		t2.start();
		
		System.out.println("StringBuilder result:");
		System.out.println(sbuild);
		System.out.println();
		System.out.println("StringBuffer result:");
		System.out.println(sbuffer);
		System.out.println();
		
		
	}
}
