package org.sourav.Leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    int K = 0;
    int nums = 0;

    public List<List<Integer>> combine(int n, int k) {
        this.K = k;
        this.nums = n;

        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<>(), 1);
        return ans;
    }

    void backtracking(List<List<Integer>> ans, List<Integer> tempList, int index) {
        if (tempList.size() == this.K) {
            ans.add(new ArrayList<>(tempList));
            return;
        }

        int need = this.K - tempList.size();
        int remain = this.nums - index + 1;
        int available = remain - need;

        for (int start = index; start <= index + available; start++) {
            tempList.add(start);
            backtracking(ans, tempList, start+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combine(4, 2));
    }

}
