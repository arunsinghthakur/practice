package joker.ds.problem;

public class Palidrome {

	public static void main(String[] args) {
		System.out.println(check(12321));
	}

	static boolean check(int n) {
		return String.valueOf(n).equals(new StringBuilder(String.valueOf(n)).reverse().toString());
	}

}
