package org.general;

import java.util.Arrays;

public class MinRangeOfFountains {

    public static int minRangeOfFountains(int[] plants, int[] fountains) {
        Arrays.sort(plants);
        Arrays.sort(fountains);

        int numFountains = fountains.length;

        int minRange = Integer.MIN_VALUE;
        int fountainIndex = 0;

        for (int plant : plants) {
            while (fountainIndex < numFountains - 1 &&
                Math.abs(plant - fountains[fountainIndex]) >= Math.abs(plant - fountains[fountainIndex + 1])) {
                fountainIndex++;
            }

            minRange = Math.max(minRange, Math.abs(plant - fountains[fountainIndex]));
        }

        return minRange;
    }

    public static void main(String[] args) {
        int[] plants = {6,7,8,9};
        int[] fountains = {5,9};
        System.out.println("Minimum range of fountains: " + minRangeOfFountains(plants, fountains));
    }
}
