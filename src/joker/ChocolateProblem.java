package joker;

public class ChocolateProblem {

	public static void main(String[] args) {
		System.out.println(count(15, 1, 3));
	}

	static int count(int money, int price, int wrapCount) {
		int choko = money / price;
		int wrap = choko;
		int result = choko;
		while (wrap >= wrapCount) {
			choko = wrap / wrapCount;
			wrap = choko + (wrap % wrapCount);
			result += choko;
		}

		return result;
	}

}
