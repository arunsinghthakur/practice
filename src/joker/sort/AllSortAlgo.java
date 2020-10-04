package joker.sort;

import java.util.Arrays;

public class AllSortAlgo {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 4, 2, 6};
        selectionSort(a1);
        print("Selection sort -", a1);
        System.out.println("\n");
        int[] a2 = new int[]{1, 4, 2, 6};
        bubbleSort(a2);
        print("Bubble sort -", a2);
        System.out.println("\n");
        int[] a3 = new int[]{1, 4, 2, 6};
        insertionSort(a3);
        print("Insertion sort -", a3);
        System.out.println("\n");
        int[] a4 = new int[]{1, 4, 2, 6};
        print("Merge sort -", mergeSort(a4));
        System.out.println("\n");
        int[] a5 = new int[]{5656,233,5656,1, 4, 2, 6};
        quickSort(a5);
        print("Quick sort -", a5);
    }

    static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min_index]) {
                    min_index = j;
                }
            }
            swap(nums, i, min_index);
        }
    }

    static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean swap = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j >= 0 && nums[j - 1] > nums[j]) {
                swap(nums, j - 1, j);
            }
        }
    }

    static int[] mergeSort(int[] nums) {
        if (nums.length <= 1) return nums;
        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[mid + nums.length % 2];
        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[i + mid];
        }

        mergeSort(left);
        mergeSort(right);

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k++] = left[i++];
            } else if (left[i] > right[j]) {
                res[k++] = right[j++];
            } else {
                res[k++] = left[i++];
                res[k++] = right[j++];
            }
        }
        while (i < left.length) {
            res[k++] = left[i++];
        }
        while (j < right.length) {
            res[k++] = right[j++];
        }
        return res;
    }

    static void quickSort(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    static void quickSort(int[] nums, int l, int h) {
        if(l < h) {
            int pIndex = partition(nums, l , h );
            quickSort(nums, l, pIndex-1);
            quickSort(nums,pIndex+1,h);
        }
    }
    static int partition(int[] nums, int l, int h) {
        int pivtol = nums[h];
        int pIndex=l-1;
        for(int j=l;j<h;j++) {
            if(nums[j] <= pivtol) {
                pIndex++;
                swap(nums, j, pIndex);
            }
        }
        swap(nums, pIndex+1, h);
        return pIndex+1;
    }
    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    static void print(String s, int[] a) {
        System.out.print(s);
        Arrays.stream(a).boxed().forEach(System.out::print);
    }
}
