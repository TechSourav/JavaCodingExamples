package org.sourav.AlgoExpert.stack;

import java.util.Stack;

public class MyMinMaxStack {

    public static void main(String[] args) {
        MinMaxStack stk = new MinMaxStack();
        stk.push(10);
        stk.push(5);
        System.out.println("min: " + stk.getMin());
        System.out.println("max: " + stk.getMax());
        stk.push(7);
        stk.push(2);
        stk.push(12);
        stk.push(11);
        stk.pop();
        System.out.println("min: " + stk.getMin());
        System.out.println("max: " + stk.getMax());
        stk.pop();
        System.out.println("min: " + stk.getMin());
        System.out.println("max: " + stk.getMax());
    }

    static class MinMaxStack {

        private int max = Integer.MIN_VALUE;
        private int min = Integer.MAX_VALUE;
        private Stack<Integer> stackArr = new Stack<>();
        private Stack<Integer[]> minMaxArr = new Stack<>();

        public int peek() {
            return stackArr.peek();
        }

        public int pop() {
            Integer[] minMax = minMaxArr.pop();
            this.min = minMax[0];
            this.max = minMax[1];
            return this.stackArr.pop();
        }

        public void push(Integer number) {
            this.stackArr.push(number);
            this.minMaxArr.push(new Integer[] {min, max});
            this.min = Math.min(min, number);
            this.max = Math.max(max, number);
        }

        public int getMin() {
            return this.min;
        }

        public int getMax() {
            return this.max;
        }
    }

}
