package com.pratik.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Manually create a pool of 5000 threads.
 *
 */
public class MyRunnable implements Runnable {

	private long val = 0;

	MyRunnable(long val) {

		this.val = val;
	}

	@Override
	public void run() {
		long sum = 0;
		for (long i = 1; i < val; i++) {
			sum += 1;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		
		List<Thread> runnables = new ArrayList<>();
		
		for (long i = 1; i < 5000; i++) {

			MyRunnable task = new MyRunnable(10000000L + i);
			Thread worker = new Thread(task);
			worker.setName("~~~~~~~" + String.valueOf(i));
			worker.start();
			runnables.add(worker);

		}
		
		long runningThreads = 0;
		do {
			runningThreads = runnables.stream().parallel().filter(t -> t.isAlive()).count();
			// for (Thread thread : runnables) {
			// if (thread.isAlive()) {
			// runningThreads++;
			// }
			// }
			System.out.println("We have " + runningThreads + " running threads");
		} while (runningThreads > 0);

	}

}
