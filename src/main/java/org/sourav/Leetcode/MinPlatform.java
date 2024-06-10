package org.sourav.Leetcode;

import java.util.PriorityQueue;

public class MinPlatform {

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minPlatform(arr, dep));
    }

    private static int minPlatform(int[] arr, int[] dep) {
        if (arr.length == 0 || dep.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(dep[0]);

        for (int i = 1; i < arr.length; i++) {
            if (!pq.isEmpty()) {
                if (arr[i] > pq.peek()) {
                    pq.poll();
                }
                pq.offer(dep[i]);
            }
        }

        return pq.size();
    }


}
