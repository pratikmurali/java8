package com.pratik.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Long> {

	private long sum = 0L;
	private long counter = 0L;

	public MyCallable(long counter) {
		this.counter = counter;
	}

	@Override
	public Long call() throws Exception {

		for (long i = 1; i <= counter; i++) {
			sum += i;
		}

		return sum;

	}

	public static void main(String[] args) {

		int cores = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(cores);
		// Create a list of futures
		List<Future<Long>> list = new ArrayList<>();
		// Submit 2000 callables and add to list of futures.
		for (long i = 0; i < 2000; i++) {
			Future<Long> future = pool.submit(new MyCallable(1000L + i));
			list.add(future);
		}

		// Poll the futures and print the output, note that the 
		// sums won't be ordered. This stuff is async 
		try {
			for (Future<Long> f : list) {
				System.out.println(f.get());
			}
		} catch (InterruptedException | ExecutionException ie) {
			/**
			 * NOTE:Bytecode generated by compiling a catch block that handles
			 * multiple exception types will be smaller (and thus superior) than
			 * compiling many catch blocks that handle only one exception type
			 * each. A catch block that handles multiple exception types creates
			 * no duplication in the bytecode generated by the compiler; the
			 * bytecode has no replication of exception handlers.
			 * http://docs.oracle.com/javase/7/docs/technotes/guides/language/
			 * catch-multiple.html
			 */
			pool.shutdown();
			// Preserve the interrupted status.
			Thread.currentThread().interrupt();
		} finally {
			pool.shutdownNow();
		}

	}

}
