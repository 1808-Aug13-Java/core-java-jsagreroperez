package com.revature.threads;

public class StringTestRunnable implements Runnable {

	StringBuilder sbuild;
	StringBuffer sbuffer;
	
	public StringTestRunnable() {
		super();
	}
	
	public StringTestRunnable( StringBuilder sbuild, StringBuffer sbuffer) {
		super();
		this.sbuild = sbuild;
		this.sbuffer = sbuffer;
		
	}
	
	@Override
	public synchronized void run() { //synchronized allows only one thread to access this method instead of letting more than one thread to access the method at the same time.
		for (int i =0; i<50; i++ ) {
			sbuild = sbuild.append("~");
			sbuffer = sbuffer.append("~");
		}
	}
	
	
}
