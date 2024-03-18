package org.sourav.Leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

    final static Map<Character, Character> mappings = new HashMap<>();
    static {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public static void main(String[] args) {
        System.out.println(isValid("{()}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c= s.charAt(i);
            if(mappings.containsKey(c)) {
                char topElement = brackets.isEmpty()? '#' : brackets.pop();
                if(topElement!= mappings.get(c)) {
                    return false;
                }
            } else {
                brackets.push(c);
            }
        }
        return brackets.isEmpty();
    }

}
