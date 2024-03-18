package org.sourav.Leetcode.KWayMerge;

import java.util.*;

public class HireWorkers {

    static class Worker {
        double ratio;
        int quality;

        Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] expWage, int k) {
        int n = expWage.length;

        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            double ratio = (double) expWage[i] / quality[i];
            workers[i] = new Worker(ratio, quality[i]);
        }

        Arrays.sort(workers, Comparator.comparingDouble(w -> w.ratio));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sumHeap = 0;
        for (int i = 0; i < k; i++) {
            maxHeap.offer(workers[i].quality);
            sumHeap += workers[i].quality;
        }
        double captainRatio = workers[k - 1].ratio;
        double minCost = captainRatio * sumHeap;

        for (int captain = k; captain < n; captain++) {
            captainRatio = workers[captain].ratio;

            if (!maxHeap.isEmpty() && workers[captain].quality < maxHeap.peek()) {
                sumHeap -= maxHeap.poll();
                maxHeap.offer(workers[captain].quality);
                sumHeap += workers[captain].quality;
            }
            double cost = captainRatio * sumHeap;
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public static void main(String[] args) {
        HireWorkers workers = new HireWorkers();
        int[] quality = {10, 20, 5};
        int[] expWage = {70, 50, 30};
        System.out.println(workers.mincostToHireWorkers(quality, expWage, 2));
    }
}
