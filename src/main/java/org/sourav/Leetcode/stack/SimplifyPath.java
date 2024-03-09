package org.sourav.Leetcode.stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/../"));
    }

    public static String simplifyPath(String s) {
        Stack<String> stack = new Stack<>();
        String[] components = s.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }

        // Construct simplified path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }

}
