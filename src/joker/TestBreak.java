package joker;

public class TestBreak {

	public static void main(String[] args) {

		testBreak(1);
	}

	private static void testBreak(Integer i) {
		switch (i) {
		case 1: {
			System.out.println(i);
		}
		case 2: {
			System.out.println(i);
		}
		case 3: {
			System.out.println(i);
		}
		default:
			System.out.println(i);
		}
	}

}
