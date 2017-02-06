package com.example.java.learn.util.queue.threadsafe;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

	static class DelayedImpl implements Delayed {

		/** Base of nanosecond timings, to avoid wrapping */
		static final long NANO_ORIGIN = System.nanoTime();

		final int id;
		final long time;

		public DelayedImpl(int id, long timeout, TimeUnit unit) {
			this.id = id;
			this.time = now() + TimeUnit.NANOSECONDS.convert(timeout, unit);
		}

		/**
		 * Returns nanosecond time offset by origin
		 */
		final static long now() {
			return System.nanoTime() - NANO_ORIGIN;
		}

		@Override
		public int compareTo(Delayed other) {
			if (other == this) // compare zero ONLY if same object
				return 0;
			if (other instanceof DelayedImpl) {
				DelayedImpl x = (DelayedImpl) other;
				long diff = time - x.time;
				if (diff < 0) {
					return -1;
				} else if (diff > 0) {
					return 1;
				} else {
					return 0;
				}
			}
			long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
			return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
		}
		
		@Override
		public long getDelay(TimeUnit unit) {
			long d = unit.convert(time - now(), TimeUnit.NANOSECONDS);
			return d;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<DelayedImpl> c = new DelayQueue<DelayedImpl>();
		c.add(new DelayedImpl(3, 3, TimeUnit.SECONDS));
		c.add(new DelayedImpl(2, 2, TimeUnit.SECONDS));
		c.add(new DelayedImpl(1, 1, TimeUnit.SECONDS));
		int count = 0;
		final long deltaMillis = 1000L;
		while (count < 4) {
			Thread.sleep(deltaMillis);
			System.out.print("another " + deltaMillis + "ms passed, ");
			DelayedImpl first = c.poll();
			if (first != null) {
				count += 1;
				System.out.println("and we got " + first.id + " " + first);
			} else {
				System.out.println("and we got null");
			}
		}

		c.add(null);
	}

}
