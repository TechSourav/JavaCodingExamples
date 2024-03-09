package org.sourav.Leetcode.KWayMerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HireWorkers {

    public static class worker {

        int q;
        int w;
        double ratio;

        worker(int q, int w) {
            this.q = q;
            this.w = w;
            this.ratio = this.w * 1.0 / this.q;
        }
    }

    public double mincostToHireWorkers(int[] q, int[] w, int k) {
        ArrayList<worker> arr = new ArrayList<>();

        int n = q.length;
        for (int i = 0; i < n; i++) {
            arr.add(new worker(q[i], w[i]));
        }

        Collections.sort(arr, Comparator.comparingDouble(a -> a.ratio));

        PriorityQueue<worker> pq = new PriorityQueue<>((a, b) -> (b.q - a.q));

        double ans = Double.MAX_VALUE;
        double sum = 0;

        for (worker a : arr) {
            pq.add(a);
            sum += a.q;

            if (pq.size() == k) {
                ans = Math.min(ans, sum * a.ratio);
                sum = sum - pq.remove().q;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        HireWorkers workers = new HireWorkers();
        int[] w = { 70, 50, 30 };
        int[] q = { 10, 20, 5 };
        System.out.println(workers.mincostToHireWorkers(q, w, 2));
    }

}
