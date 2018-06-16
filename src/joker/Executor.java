package joker;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Executor {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return null;
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
