package joker.lock.j8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenLock {
	volatile int i = 0;
	volatile int max = 100;

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition oddCondition = lock.newCondition();
		Condition evenCondition = lock.newCondition();
		OddEvenLock evenLock = new OddEvenLock();

		Runnable odd = () -> {
			while (evenLock.i < evenLock.max) {
				lock.lock();
				if (evenLock.i % 2 == 1) {
					System.out.println(Thread.currentThread().getName() + " - " + evenLock.i);
					++evenLock.i;
				} else {
					try {
						oddCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				evenCondition.signalAll();
				lock.unlock();
			}
		};

		Runnable even = () -> {
			while (evenLock.i < evenLock.max) {
				lock.lock();
				if (evenLock.i % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + " - " + evenLock.i);
					++evenLock.i;
				} else {
					try {
						evenCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				oddCondition.signalAll();
				lock.unlock();
			}
		};

		Thread t1 = new Thread(odd, "odd");
		Thread t2 = new Thread(even, "even");

		t1.start();
		t2.start();
	}
	
	
}
