package org.sourav.Leetcode.TwoHeap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] arr = { 1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(medianSlidingWindow(arr, 3)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // this is very tricky
        // (a,b) -> b-a will overflow
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        final HashMap<Integer, Integer> removed = new HashMap<>();

        // initialize the heaps
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        // To balance the two heaps
        for (int j = 0; j < k / 2; j++) {
            minHeap.offer(maxHeap.poll());
        }

        for (int i = k; i <= nums.length; i++) {
            ans[i - k] = (k % 2 == 0) ? (minHeap.peek() + maxHeap.peek()) / 2.0 : maxHeap.peek();

            // stop condition
            if (i == nums.length) {
                break;
            }

            int outNum = nums[i - k];
            int inNum = nums[i];

            removed.put(outNum, removed.getOrDefault(outNum, 0) + 1);

            // balance only takes -2, 0, 2
            // we need to balance the heap using the real size, cuz removed element might still in the heaps
            int balance = 0;
            if (outNum <= maxHeap.peek()) {
                balance--;
            } else {
                balance++;
            }

            if (inNum <= maxHeap.peek()) {
                balance++;
                maxHeap.offer(inNum);
            } else {
                balance--;
                minHeap.offer(inNum);
            }

            // rebalance the heap
            if (balance < 0) {
                maxHeap.offer(minHeap.poll());
            }
            if (balance > 0) {
                minHeap.offer(maxHeap.poll());
            }
            // lazy remove the out of window element
            // remove from the maxHeap first, because we use <= when calculating balance in outNum
            while (!maxHeap.isEmpty() && removed.getOrDefault(maxHeap.peek(), 0) > 0) {
                int removeNum = maxHeap.poll();
                removed.put(removeNum, removed.get(removeNum) - 1);
            }
            while (!minHeap.isEmpty() && removed.getOrDefault(minHeap.peek(), 0) > 0) {
                int removeNum = minHeap.poll();
                removed.put(removeNum, removed.get(removeNum) - 1);
            }
        }
        return ans;
    }

}
