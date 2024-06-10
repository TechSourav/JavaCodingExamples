package org.product2;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        String str = "Vy name is sourav";
        getLastRepeatingCharacter(str);

    }

    private static void getLastRepeatingCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        } // a 2, s 2, n 2, v 1

        for (int i = str.length() - 1; i > 0; i--) {
            char curr = str.charAt(i);
            if (map.containsKey(curr) && map.get(curr) > 1) {
                System.out.println(curr);
                break;
            }
        }

    }

}
