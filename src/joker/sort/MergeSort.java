package joker.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] ar = new int[] { 122, 100, 1, 3, 2, 5, 77, 6, 4, 4, 8, 9, 1222 };
		ar = MergeSort.mergeSort(ar);

		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}

	}

	public static int[] mergeSort(int[] a) {
		if (a.length <= 1) {
			return a;
		}
		int mid = a.length / 2;
		int left = mid;
		int right = mid + a.length % 2;

		int[] leftA = new int[left];
		int[] rightA = new int[right];

		for (int i = 0; i < mid; i++) {
			leftA[i] = a[i];
		}
		int x = 0;
		for (int j = mid; j < a.length; j++) {
			rightA[x] = a[j];
			++x;
		}
		leftA = mergeSort(leftA);
		rightA = mergeSort(rightA);

		int[] res = merge(leftA, rightA);
		return res;
	}

	public static int[] merge(int[] leftA, int[] rightA) {
		int l = 0;
		int r = 0;
		int res = 0;
		int[] a = new int[leftA.length + rightA.length];
		while (l < leftA.length || r < rightA.length) {
			if (l < leftA.length && r < rightA.length) {
				if (leftA[l] <= rightA[r]) {
					a[res] = leftA[l];
					res++;
					l++;
				} else {
					a[res] = rightA[r];
					res++;
					r++;
				}
			} else if (l < leftA.length) {
				a[res] = leftA[l];
				res++;
				l++;
			} else if (r < rightA.length) {
				a[res] = rightA[r];
				res++;
				r++;
			}
		}
		return a;
	}

}
