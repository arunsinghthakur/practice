package joker.thread;

public class Semaphore {

	public static void main(String[] args) throws InterruptedException {
		java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(2);
		Runnable r = () -> {
			try {
				try {
					semaphore.acquire();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} finally {
				semaphore.release();
			}

		};

		Thread t1 = new Thread(r, "T1");
		Thread t2 = new Thread(r, "T2");
		Thread t3 = new Thread(r, "T3");
		t1.start();
		t2.start();
		t3.start();

	}

}
