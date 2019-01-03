package joker.thread;

public class ThreadDemo extends Thread{

	public static void main(String[] args) {
		Thread t1 = new Thread("t1");
		Thread t2 = new Thread("t2");
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("JOKER");
	}
}
