package org.sourav.practice;

import org.sourav.AlgoExpert.linkedlist.RemoveDuplicate;

public class LL1 {

    public static void main(String[] args) {
        RemoveDuplicate.LinkedList l = new RemoveDuplicate.LinkedList(1);
        l.next = new RemoveDuplicate.LinkedList(1);
        l.next.next = new RemoveDuplicate.LinkedList(1);
        l.next.next.next = new RemoveDuplicate.LinkedList(3);
        l.next.next.next.next = new RemoveDuplicate.LinkedList(4);
        l.next.next.next.next.next = new RemoveDuplicate.LinkedList(4);
        l.next.next.next.next.next.next = new RemoveDuplicate.LinkedList(4);
        l.next.next.next.next.next.next.next = new RemoveDuplicate.LinkedList(5);
        l.next.next.next.next.next.next.next.next = new RemoveDuplicate.LinkedList(6);
        l.next.next.next.next.next.next.next.next.next = new RemoveDuplicate.LinkedList(6);

        final RemoveDuplicate.LinkedList res = removeDuplicatesFromLinkedList(l);
        System.out.println(res);
    }

    private static RemoveDuplicate.LinkedList removeDuplicatesFromLinkedList(RemoveDuplicate.LinkedList head) {

        RemoveDuplicate.LinkedList slow = head;
        RemoveDuplicate.LinkedList fast = head.next;

        while (fast != null) {
            // 1. if two consecutive integers are same
            if (slow.value == fast.value) {
                fast = fast.next;
                if (fast == null) {
                    slow.next = fast;
                }
            } else {
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            }

        }

        return head;
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public RemoveDuplicate.LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
