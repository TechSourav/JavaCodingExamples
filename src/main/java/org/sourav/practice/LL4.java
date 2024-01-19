package org.sourav.practice;

public class LL4 {

    public static void main(String[] args) {
        LL4.LinkedList l = new LL4.LinkedList(0);
        l.next = new LL4.LinkedList(1);
        l.next.next = new LL4.LinkedList(2);
        l.next.next.next = new LL4.LinkedList(3);
        l.next.next.next.next = new LL4.LinkedList(4);
        l.next.next.next.next.next = new LL4.LinkedList(5);
        l.next.next.next.next.next.next = new LL4.LinkedList(6);
        l.next.next.next.next.next.next.next = new LL4.LinkedList(7);
        l.next.next.next.next.next.next.next.next = new LL4.LinkedList(8);
        l.next.next.next.next.next.next.next.next.next = new LL4.LinkedList(9);
        l.next.next.next.next.next.next.next.next.next.next = l.next.next.next.next;

        LL4.LinkedList node = findLoop(l);
        System.out.println(node);
    }

    public static LL4.LinkedList findLoop(LL4.LinkedList head) {
        LL4.LinkedList slow = head;
        LL4.LinkedList fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


    static class LinkedList {
        int value;
        LL4.LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
