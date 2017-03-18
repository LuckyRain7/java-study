package com.example.java.learn.util.concurrent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

	public MyThreadPoolExecutor() {
		this(Runtime.getRuntime().availableProcessors() / 2 + 1, Runtime.getRuntime().availableProcessors(), 30,
				TimeUnit.SECONDS, new ArrayBlockingQueue<>(Runtime.getRuntime().availableProcessors(), true));
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(Runtime.getRuntime().availableProcessors() + " availableProcessors");
		final MyThreadPoolExecutor executor = new MyThreadPoolExecutor();

		// prepare tasks
		List<Callable<Long>> tasks = Lists.newArrayList();
		for (int i = 0; i < 2 * Runtime.getRuntime().availableProcessors(); ++i) {
			final int j = 100 + i;
			Callable<Long> task = new Callable<Long>() {
				@Override
				public Long call() throws Exception {
					final long millis = (long) (Math.random() * 1000L);
					Thread.sleep(millis);
					System.out.printf("%s: Step 2: %d active threads\n", LocalDateTime.now(),
							executor.getActiveCount());
					long sum = 0;
					for (int k = 1; k <= j; ++k) {
						sum += k;
					}
					return sum;
				}
			};
			tasks.add(task);
		}

		// calculate
		System.out.printf("Step 1: %d active threads\n", executor.getActiveCount());
		List<Future<Long>> futures = executor.invokeAll(tasks);
		for (Future<Long> future : futures) {
			System.out.println(future.get());
		}
		System.out.printf("Step 3: %d active threads\n", executor.getActiveCount());

		// shutdown
		executor.shutdown();
		System.out.printf("Step 4: %d active threads\n", executor.getActiveCount());
	}

}
