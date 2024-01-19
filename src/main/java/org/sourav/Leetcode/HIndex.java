package org.sourav.Leetcode;

public class HIndex {

    public static void main(String[] args) {
        int[] arr = {1,5,1,1,5,2};
        System.out.println(hIndex(arr));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // finding the h-index
        int k = n;

        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }

}
