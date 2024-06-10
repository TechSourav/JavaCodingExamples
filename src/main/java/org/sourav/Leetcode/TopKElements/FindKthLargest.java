package org.sourav.Leetcode.TopKElements;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] ar = {1,9,3,6,5,4,7,2,8};
        System.out.println(findKthLargest(ar, 3));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int j = k; j < nums.length; j++) {
            if (nums[j] > pq.peek()) {
                pq.poll();
                pq.offer(nums[j]);
            }
        }

        return pq.peek();
    }

}
