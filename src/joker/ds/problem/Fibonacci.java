package joker.ds.problem;

public class Fibonacci {

	public static void main(String[] args) {
		// System.out.println(fibo(9));
		for (int i = 0; i <= 9; i++) {
			System.out.print(fibo(i) + ", ");
		}
	}

	static int fibo(int n) {
		if (n > 1) {
			return fibo(n - 1) + fibo(n - 2);
		}

		return n;
	}

}
