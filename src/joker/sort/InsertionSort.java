package joker.sort;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InsertionSort {

	public static void main(String[] args) {
		Integer[] ar = new Integer[] { 122, 100, 1, 3, 2, 5, 77, 6, 4, 4, 8, 9, 1222 };
		// Integer[] ar = new Integer[] { 1,2,3,4,5 };
		new InsertionSort().insertionSort(ar);
		System.out.println(Stream.of(ar).map(String::valueOf).collect(Collectors.joining(", ")));
	}

	void insertionSort(Integer[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				} else {
					break;
				}
			}
		}
	}

}
