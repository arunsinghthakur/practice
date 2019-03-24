package joker;

public class StaticConcurrency {
	private static int count = 0;
	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (StaticConcurrency.class) {
					Thread.currentThread();
					System.out.println(Thread.currentThread().getName() + "-" + count++);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "static thread").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (this) {
					System.out.println(Thread.currentThread().getName() + "-" + count++);
				}
			}
		}, "instance thread").start();
		
		System.out.println("main thread - " + count++);
	}

}
