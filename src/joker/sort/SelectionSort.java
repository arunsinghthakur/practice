package joker.sort;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelectionSort {

	public static void main(String[] args) {
		Integer[] ar = new Integer[] { 122, 1, 3, 2, 5, 6, 4, 4, 8, 9 };
		new SelectionSort().selectionSort(ar);
		System.out.println(Stream.of(ar).map(String::valueOf).collect(Collectors.joining(", ")));
	}

	void selectionSort(Integer[] a) {

		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					a[j] = a[i];
					a[i] = min;
					// break;
				}
			}
		}
	}

}
