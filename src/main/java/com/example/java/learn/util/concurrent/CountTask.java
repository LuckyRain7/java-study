package com.example.java.learn.util.concurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import com.google.common.collect.Lists;

public class CountTask extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6388582091622532141L;
	private static final int THRESHOLD = 10000;
	private static final int SUB_TASK_COUNT = 100;

	private final int startInclusive;
	private final int endInclusive;

	public CountTask(int startInclusive, int endInclusive) {
		this.startInclusive = startInclusive;
		this.endInclusive = endInclusive;
	}

	@Override
	public Long compute() {
		long sum = 0L;
		boolean canCompute = (endInclusive - startInclusive) < THRESHOLD;
		if (canCompute) {
			for (int i = startInclusive; i <= endInclusive; ++i) {
				sum += i;
			}
		} else {
			// 分成 100 个小任务
			final int step = (endInclusive - startInclusive) / SUB_TASK_COUNT;
			List<CountTask> subTasks = Lists.newArrayListWithCapacity(SUB_TASK_COUNT);
			int pos = startInclusive;
			for (int i = 0; i < SUB_TASK_COUNT; ++i) {
				int lastOne = pos + step;
				if (lastOne > endInclusive) {
					lastOne = endInclusive;
				}
				CountTask subTask = new CountTask(pos, lastOne);
				subTasks.add(subTask);
				subTask.fork();
				pos += step + 1;
			}
			for (int i = SUB_TASK_COUNT - 1; i >= 0; --i) {
				sum += subTasks.get(i).join();
			}
			return sum;
		}
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(1, THRESHOLD * 100);
		ForkJoinTask<Long> result = forkJoinPool.submit(task);
		long res = result.get();
		System.out.println("sum = " + res);
	}

}
