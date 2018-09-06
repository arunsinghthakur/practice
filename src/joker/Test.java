package joker;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test extends AbstractTest{
	 public Test() {
		// TODO Auto-generated constructor stub
		 System.out.println("test");
	}
	public static void main(String[] args) {
		new Test();
		System.out.println("AT809809".substring(0, 2));
		List<String> l = new CopyOnWriteArrayList<>();

	}
}

abstract class AbstractTest {
	public AbstractTest() {
		System.out.println("abstart test");
	}
}
