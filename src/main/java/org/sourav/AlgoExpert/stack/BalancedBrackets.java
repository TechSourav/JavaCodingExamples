package org.sourav.AlgoExpert.stack;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(balancedBrackets("(a)"));
    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> chStack = new Stack<>();
        for (char c : str.toCharArray()) {
            switch(c) {
            case '(' :
                chStack.push(')');
                break;
            case '{' :
                chStack.push('}');
                break;
            case '[' :
                chStack.push(']');
                break;
            default:
                if (c != ')' && c != '}' && c != ']')
                    break;
                if (chStack.isEmpty())
                    return false;
                if (chStack.pop() != c)
                    return false;
            }

        }
        return chStack.isEmpty();
    }
}
