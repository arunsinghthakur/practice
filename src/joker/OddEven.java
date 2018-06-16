package joker;

public class OddEven {
	int i = 1;
	int max = 100;

	public static void main(String[] args) {
		OddEven oe = new OddEven();
		Thread oddt = new Thread(new Odd(oe), "Odd thread- ");
		Thread event = new Thread(new Even(oe), "Even thread- ");

		event.start();
		oddt.start();
	}

}

class Odd implements Runnable {
	OddEven oe;

	public Odd(OddEven oe) {
		this.oe = oe;
	}

	@Override
	public void run() {
		while (oe.i < oe.max) {
			synchronized (oe) {
				if (oe.i % 2 == 1) {
					System.out.println(Thread.currentThread().getName() + oe.i);
					++oe.i;
					oe.notify();
				} else {
					try {
						oe.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class Even implements Runnable {

	OddEven oe;

	public Even(OddEven oe) {
		this.oe = oe;
	}

	@Override
	public void run() {
		while (oe.i < oe.max) {
			synchronized (oe) {
				if (oe.i % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + oe.i);
					++oe.i;
					oe.notify();
				} else {
					try {
						oe.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
