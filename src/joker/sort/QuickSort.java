package joker.sort;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

	public static void main(String[] args) {
		//Integer[] ar = new Integer[] { 122, 1, 3, 2, 5, 6, 4, 4, 8, 9 };
		Integer[] ar = new Integer[]{1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};
		new QuickSort().quickSort(ar);
		System.out.println(Stream.of(ar).map(String::valueOf).collect(Collectors.joining(", ")));
	}

	void quickSort(Integer[] a) {
		quickSort(a, 0, a.length - 1);
	}

	void quickSort(Integer[] a, int l, int h) {
		if (l < h) {
			int pi = partition(a, l, h);
			quickSort(a, l, pi - 1);
			quickSort(a, pi + 1, h);
		}
	}

	int partition(Integer[] a, int l, int h) {
		int pi = a[h];
		int i = l - 1;
		for (int j = l; j < h; j++) {
			if (a[j] <= pi) {
				++i;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		int temp = a[i + 1];
		a[i + 1] = a[h];
		a[h] = temp;

		return i + 1;
	}

}
