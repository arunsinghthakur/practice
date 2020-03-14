package joker.ds.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMedium {

    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null) return new double[0];
        int n = nums.length;
        double[] res = new double[n-k+1];
        PriorityQueue<Double> pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++) {
            pq.add((double)nums[i]);

            if(i+1 >= k) {
                Object[] ret = pq.toArray();
                Arrays.sort(ret);

                int idx = k/2;
                if(k%2 == 0){
                    double v1 = (double)ret[idx-1];
                    double v2 = (double)ret[idx];
                    res[i-k+1] = (v1+v2)/2.0;
                } else {
                    res[i-k+1] = (double)ret[idx];
                }
                pq.remove((double)nums[i+1-k]);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMedium s = new SlidingWindowMedium();
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        double[] res = s.medianSlidingWindow(arr, 3);
        System.out.println(res);
    }
}
