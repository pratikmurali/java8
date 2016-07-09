package com.pratik.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyRunnableExecutor implements Runnable {

	private long sumCounter = 0L;

	/**
	 * @param sumCounter
	 */
	public MyRunnableExecutor(long sumCounter) {
		super();
		this.sumCounter = sumCounter;
	}

	@Override
	public void run() {

		long sum = 0;
		for (long i = 1; i < sumCounter; i++) {
			sum += i;
		}

		System.out.println(sum);
	}

	public static void main(String[] args) {
		// Get number of cores, I have a 2.4 GHz Intel Core i7 supporting
		// Hyperthreading (8 cores)
		int cores = Runtime.getRuntime().availableProcessors();
		// Use the Executor framework to create a pool of threads.
		ExecutorService pool = Executors.newFixedThreadPool(cores);

		try {

			for (int i = 0; i < 500; i++) {
				Runnable worker = new MyRunnable(10000000L + i);
				pool.execute(worker);
			}

			// Wait a while for existing tasks to terminate
			if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
				pool.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!pool.awaitTermination(60, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
			
			System.out.println("Finished all threads");
			
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			pool.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}

	}

}
