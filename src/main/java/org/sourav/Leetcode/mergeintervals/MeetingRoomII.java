package org.sourav.Leetcode.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public static void main(String[] args) {
        int[][] arr = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(arr));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;

        for(int[] interval : intervals){
            while(!pq.isEmpty() && pq.peek()<= interval[0])
                pq.poll();
            pq.offer(interval[1]);
            ans = Math.max(ans, pq.size());
        }

        return ans;
    }

}
