package org.sourav.Leetcode;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4,4,4};
       //removeDuplicate(a);
        removeTwoDuplicates(a);
    }

    static int removeDuplicate(int[] nums) {
        int n = nums.length;
        int count = 1;
        int duplicateCounter = 1;
        int r = 1, w = 0;

        while (r < n) {
            if (nums[w] == nums[r]) { // duplicate found
                duplicateCounter--;
                r++;
                while (duplicateCounter >= 0 && nums[w] == nums[r]) {
                    r++;
                }

            } else {
                nums[w+1] = nums[r];
                w++;
                r++;
                count++;
            }
        }
        return count;
    }

    static int removeTwoDuplicates(final int[] nums) {

        TreeMap<Integer, String> m = new TreeMap<Integer, String>();
        m.put(1,"India");
        m.put(2,"US");
        m.put(3,"Australia");
        m.put(4,"Netherlands");
        m.put(5,"Canada");
        for(Map.Entry e:m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        System.out.println("First Entry in Map is "+m.lastEntry().getKey());

        Collections.max(m.entrySet(), Map.Entry.comparingByValue()).getKey();


        int i = 0;

        for (final int num : nums)
            if (i < 2 || num > nums[i - 2])
                nums[i++] = num;

        return i;
    }
}
