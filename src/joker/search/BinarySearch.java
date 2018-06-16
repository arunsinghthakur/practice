package joker.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 100, 200, 350 };

		System.out.println("Index of 6 : " + binarySearch(a, 6));
		System.out.println("Index of 350 : " + binarySearch(a, 350));
		System.out.println("Index of 4 : " + binarySearch(a, 4));
		System.out.println("Index of 12212 : " + binarySearch(a, 12212));
	}

	static int binarySearch(int[] a, int n) {
		int s = 0;
		int e = a.length - 1;
		int m = (s + e) / 2;

		while (s <= e) {
			if (a[m] == n) {
				return m;
			} else if (a[m] < n) {
				s = m + 1;
			} else if (a[m] > n) {
				e = m - 1;
			}
			m = (s + e) / 2;
		}

		return -1;
	}
}
