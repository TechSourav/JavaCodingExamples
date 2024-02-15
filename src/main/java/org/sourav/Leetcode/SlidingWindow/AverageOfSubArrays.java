package org.sourav.Leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class AverageOfSubArrays {

    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;

        System.out.println(averageSubArray(nums, k));
        System.out.println(findMaxAverage(nums, k));
    }

    private static List<Double> averageSubArray(final int[] arr, final int k) {
        final List<Double> ans = new ArrayList<>();
        double windowAvg = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        windowAvg = (double)sum / k;
        ans.add(windowAvg);

        for (int j = 0; j < arr.length - k; j++) {
            sum = sum - arr[j] + arr[j + k];
            windowAvg = (double)sum / k;
            ans.add(windowAvg);
        }
        return ans;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxSum;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        //double avg = sum/k;
        //maxAverage = Math.max(maxAverage, avg);
        maxSum = sum;

        for(int i=0; i<nums.length-k; i++){
            sum = sum - nums[i] + nums[i+k];
            // avg = sum/k;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum/ k;
    }

}
