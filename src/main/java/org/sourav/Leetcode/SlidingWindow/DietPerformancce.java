package org.sourav.Leetcode.SlidingWindow;

public class DietPerformancce {

    public static void main(String[] args) {
        int[] calories = {1,2,3,4,5};
        dietPlanPerformance(calories, 1, 3, 3);
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        //double maxSum;
        int count = 1;
        for(int i=0; i<k; i++){
            sum += calories[i];
        }

        if (sum < lower) {
            count--;
        } else if (sum > upper) {
            count++;
        }
        //maxSum = sum;

        for(int i=0; i<calories.length-k; i++){
            sum = sum - calories[i] + calories[i+k];
            //maxSum = Math.max(maxSum, sum);
            if (sum < lower) {
                count--;
            } else if (sum > upper) {
                count++;
            }
        }

        return count;
    }

}
