package org.sourav.Leetcode.TwoHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindRightInterval {

    public static void main(String[] args) {
        int[][] intervals = {{3,4}, {1,2}, {2,3}}; // [[1,3],[2,6],[8,10],[15,18]]
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> minheapStart = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minheapEnd = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Build the 2 minHeaps
        for(int i=0; i < intervals.length; i++){
            minheapStart.add(new int[]{intervals[i][0], i});
            minheapEnd.add(new int[]{intervals[i][1], i});
        }

        // Define the final result[]
        int[] result = new int[intervals.length];

        // Initialize the result[] with -1
        Arrays.fill(result, -1);

        while(!minheapEnd.isEmpty()){
            // Fetch the smallest end index
            int[] currEnd = minheapEnd.poll();
            int currEndVal = currEnd[0];
            int currEndIdx = currEnd[1];

            // Find the first start idx which is greater than or equal to the current end
            while(!minheapStart.isEmpty() && currEndVal > minheapStart.peek()[0])
                minheapStart.poll();

            // Since there are no more elements left in minheapStart, that means rest all indices in result[] will be
            // mapped to -1
            if(minheapStart.isEmpty())
                return result;

            // When minheapStart is not empty, then the top most element of minheapStart must be >= currEndVal
            // So we place the corresponding index of the top most element of minheapStart in the corresponding
            // currEndIdx of the result[]
            result[currEndIdx] = minheapStart.peek()[1];
        }
        return result;
    }

}
