package joker.lock;

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
		OddEvenLock obj = new OddEvenLock();
		Thread t1 = new Thread(new Odd(lock, obj, oddCondition, evenCondition), "odd");
		Thread t2 = new Thread(new Even(lock, obj, oddCondition, evenCondition), "even");

		t1.start();
		t2.start();

	}
}

class Odd implements Runnable {
	Lock lock;
	Condition oddCondition;
	Condition evenCondition;
	OddEvenLock evenLock;

	public Odd(Lock lock, OddEvenLock evenLock, Condition oddCondition, Condition evenCondition) {
		this.lock = lock;
		this.evenLock = evenLock;
		this.oddCondition = oddCondition;
		this.evenCondition = evenCondition;
	}

	public void run() {
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
	}

}

class Even implements Runnable {
	Lock lock;
	Condition oddCondition;
	Condition evenCondition;
	OddEvenLock evenLock;

	public Even(Lock lock, OddEvenLock evenLock, Condition oddCondition, Condition evenCondition) {
		this.lock = lock;
		this.evenLock = evenLock;
		this.oddCondition = oddCondition;
		this.evenCondition = evenCondition;
	}

	public void run() {
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
	}

}
