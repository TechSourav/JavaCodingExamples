package org.sourav.AlgoExpert.linkedlist;

public class SwapNode {

    public static void main(String[] args) {
        LinkedList ll2 = new LinkedList(0);
        ll2.next = new LinkedList(1);
        ll2.next.next = new LinkedList(2);
        ll2.next.next.next = new LinkedList(3);
        ll2.next.next.next.next = new LinkedList(4);
        ll2.next.next.next.next.next = new LinkedList(5);

        nodeSwap(ll2);

    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList nodeSwap(LinkedList head) {
        LinkedList temp = new LinkedList(-1);
        temp.next = head;

        LinkedList prev = temp;

        while (prev.next != null && prev.next.next != null) {
            LinkedList first = prev.next;
            LinkedList second = prev.next.next;

            LinkedList secNext = second.next;
            first.next = secNext;
            second.next = first;

            prev.next = second;

            prev = first;
        }
        return temp.next;
    }

}
