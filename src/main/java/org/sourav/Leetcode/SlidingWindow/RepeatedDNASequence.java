package org.sourav.Leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequence {

    public static void main(String[] args) {
        //System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", 10));
    }

    // Leetcode approach
    public static List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n <= L)
            return new ArrayList<>();

        // rolling hash parameters: base a -> a is number of nucleotides which can be only 4 : A, C, G, T
        int a = 4, aL = (int)Math.pow(a, L);

        // convert string to array of integers
        final Map<Character, Integer> toInt = new
            HashMap<>() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};

        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int hash = 0;
        final Set<Integer> seen = new HashSet<>();
        final Set<String> output = new HashSet<>();

        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute hash of the current sequence in O(1) time
            if (start != 0)
                hash = hash * a - nums[start - 1] * aL + nums[start + L - 1];

                // compute hash of the first sequence in O(L) time
            else
                for(int i = 0; i < L; ++i) {
                    hash = hash * a + nums[i];
                }

            // update output and hashset of seen sequences
            if (seen.contains(hash)) {
                output.add(s.substring(start, start + L));
            }
            seen.add(hash);
        }
        return new ArrayList<>(output);
    }

    // Educative approach
    public static Set<String> findRepeatedSequences(String s, int k) {
        int n = s.length();
        if (n < k) {
            return new HashSet<>();
        }

        final Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        // 'a' is number of nucleotides which can be only 4 : A, C, G, T
        int a = 4;

        // This is an array storing the integer form of the string s based on the mapping defined above.
        final List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));

        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < n; i++) {
            numbers.set(i, mapping.get(s.charAt(i)));
        }

        int hashValue = 0;

        final Set<Integer> seen = new HashSet<>();
        final Set<String> output = new HashSet<>();

        for (int i = 0; i < n - k + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(a, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(a, k - 1)) * a) + numbers.get(i + k - 1);
            }

            if (seen.contains(hashValue)) {
                output.add(s.substring(i, i + k));
            }

            seen.add(hashValue);
        }
        return output;
    }
}
