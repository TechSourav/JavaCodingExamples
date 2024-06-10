package org.sourav.Leetcode.KWay;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {

    public static void main(String[] args) {
        List<List<Integer>> nums = List.of(List.of(4,10,15,24,26), List.of(0,9,12,20), List.of(5,18,22,30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000, 100000};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            pq.offer(new int[]{nums.get(i).get(0), 0, i});
        }

        while (true) {
            int[] min = pq.poll();
            if (res[1] - res[0] > max - min[0]) {
                res[0] = min[0];
                res[1] = max;
            }
            min[1]++;

            List<Integer> currList = nums.get(min[2]);
            if (currList.size() == min[1]) {
                break;
            } else {
                max = Math.max(max, currList.get(min[1]));
                min[0] =  currList.get(min[1]);
                pq.offer(min);
            }
        }
        return res;
    }

}
