package org.sourav.AlgoExpert.linkedlist;

public class FindLoop {

    public static void main(String[] args) {
        FindLoop.LinkedList l = new FindLoop.LinkedList(0);
        l.next = new FindLoop.LinkedList(1);
        l.next.next = new FindLoop.LinkedList(2);
        l.next.next.next = new FindLoop.LinkedList(3);
        l.next.next.next.next = new FindLoop.LinkedList(4);
        l.next.next.next.next.next = new FindLoop.LinkedList(5);
        l.next.next.next.next.next.next = new FindLoop.LinkedList(6);
        l.next.next.next.next.next.next.next = new FindLoop.LinkedList(7);
        l.next.next.next.next.next.next.next.next = new FindLoop.LinkedList(8);
        l.next.next.next.next.next.next.next.next.next = new FindLoop.LinkedList(9);
        l.next.next.next.next.next.next.next.next.next.next = l.next.next.next.next;

        LinkedList node = findLoop(l);
        System.out.println(node);
    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
