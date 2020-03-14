package joker.ds.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] res = new int[nums.length - (k - 1)];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1, i2) -> (i1 - i2));
        for (int i = 0; i < res.length; i++) {

            for (int j = i; j < (i + k); j++) {
                pq.add(nums[j]);
            }
            res[i] = pq.poll();
            pq.clear();
        }
        /*int max = Integer.MIN_VALUE;
        int slow = 0;
        int j = 0;
        int count = 0;
        while (j < res.length) {
            max = Math.max(max, nums[count + slow]);
            ++count;
            if (count == k) {
                ++slow;
                count = 0;
                res[j] = max;
                max = Integer.MIN_VALUE;
                ++j;
            }
        }*/
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMax s = new SlidingWindowMax();
        int k = 1;
        int[] arr = new int[]{1, -1};
        int[] res = s.maxSlidingWindow(arr, k);
        System.out.println(res);
    }
}
