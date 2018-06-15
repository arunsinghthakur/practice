package joker.sort;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BubbleSort {

	public static void main(String[] args) {
		//Integer[] ar = new Integer[] { 122, 100, 1, 3, 2, 5, 77, 6, 4, 4, 8, 9, 1222 };
		Integer[] ar = new Integer[] { 1,2,3,4,5 };
		new BubbleSort().bubbleSort(ar);
		System.out.println(Stream.of(ar).map(String::valueOf).collect(Collectors.joining(", ")));
	}

	void bubbleSort(Integer[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			boolean swap = false;
			++count;
			for (int j = 0; j < a.length-i-1; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] =temp;
					swap = true;
				}
			}
			
			if(!swap) {
				System.out.println(count);
				break;
			}
		}
	}

}
