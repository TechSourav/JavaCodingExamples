package org.sourav.Leetcode.TwoHeap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetcodeIPO {

    public static void main(String[] args) {
        int[] profit = {1,2,3};
        int[] capital = {0,1,1};
        int k = 2;
        int w = 0;
        System.out.println(findMaximizedCapital(k,w,profit,capital));

    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        // PriorityQueue is a min heap, but we need a max heap, so we use
        // Collections.reverseOrder()
        PriorityQueue<Integer> q = new PriorityQueue<>(n, Collections.reverseOrder());
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            while (ptr < n && projects[ptr].capital <= w) {
                q.add(projects[ptr++].profit);
            }
            if (q.isEmpty()) {
                break;
            }
            w += q.poll();
        }
        return w;
    }

    static class Project implements Comparable<Project> {
        int capital, profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project project) {
            return this.capital - project.capital;
        }
    }

}
