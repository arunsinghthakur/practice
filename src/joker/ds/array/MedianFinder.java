package joker.ds.array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        } // maxHeap will never be smaller size than minHeap
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(3);
        m.addNum(5);
        m.addNum(1);
        m.addNum(4);
        m.addNum(2);
        m.addNum(6);
        System.out.println(m.findMedian());
    }
}
