package org.sourav.AlgoExpert.array;

import java.util.Arrays;

public class NonConstructibleChang {

    public static void main(String[] args) {
        int[] coins = {5,7,1,1,2,3,22};
        System.out.println(nonConstructibleChange(coins));
    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int change = 0;
        for (int coin : coins) {
            if (coin > change + 1) {
                return change + 1;
            } else {
                change = change + coin;
            }
        }
        return change + 1;
    }

}
