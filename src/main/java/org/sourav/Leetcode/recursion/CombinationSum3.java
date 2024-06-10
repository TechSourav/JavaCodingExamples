package org.sourav.Leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        System.out.println(cs3.combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), k, n, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() > k)
            return; /** no solution */
        else if (tempList.size() == k && remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(list, tempList, k, remain - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
