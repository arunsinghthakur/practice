package joker;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Executor {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		Future<Integer> rr = es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

		});
		Future<?> r = es.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});

		FutureTask f = new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		Thread t = new Thread(f);
	}

}
