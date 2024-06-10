package org.product2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        Map<String, List<Integer>> map = new HashMap<>();

        Arrays.stream(arr).forEach(n -> {
            if (n % 2 == 0) {
                List<Integer> val = map.computeIfAbsent("even",v ->  new ArrayList<>());
                val.add(n);
            } else {
                List<Integer> v1 = map.computeIfAbsent("odd",v ->  new ArrayList<>());
                v1.add(n);
            }
        });

        System.out.println(map);
    }

}
