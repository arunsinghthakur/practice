package joker;

public class StaticConcurrency implements Runnable {
	
	private /*static*/ String STATIC_OBJ = "JOKER";
	private static Dummy STATIC_OBJ2 = new Dummy();
	
	public static void main(String[] args) {
		StaticConcurrency obj1 = new StaticConcurrency();
		StaticConcurrency obj2 = new StaticConcurrency();
		
		new Thread(obj1).start();
		new Thread(obj2).start();
	}

	@Override
	public void run() {
		try {
			task();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void task() throws InterruptedException {
		synchronized (STATIC_OBJ2) {
			System.out.println(Thread.currentThread().currentThread().getName());
			Thread.sleep(5000);
		}
	}

}
class Dummy{
	
}