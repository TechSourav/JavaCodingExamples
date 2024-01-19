package org.sourav.practice;

public class LL2 {

    public static void main(String[] args) {
        LL2.LinkedList l = new LL2.LinkedList(0);
        l.next = new LL2.LinkedList(1);
        l.next.next = new LL2.LinkedList(2);
        l.next.next.next = new LL2.LinkedList(3);
        l.next.next.next.next = new LL2.LinkedList(4);
        l.next.next.next.next.next = new LL2.LinkedList(5);
        l.next.next.next.next.next.next = new LL2.LinkedList(6);
        l.next.next.next.next.next.next.next = new LL2.LinkedList(7);
        l.next.next.next.next.next.next.next.next = new LL2.LinkedList(8);
        l.next.next.next.next.next.next.next.next.next = new LL2.LinkedList(9);
        LL2.LinkedList list = RemoveKthNodeFromEnd(l, 4);
    }

    public static LL2.LinkedList RemoveKthNodeFromEnd(LL2.LinkedList head, int k) {

        LL2.LinkedList slow = head;
        LL2.LinkedList fast = head;

        int i = 0;
        while(fast.next != null) {
            fast = fast.next;
            i++;
            if (i > k) {
                slow = slow.next;
            }
        }

        if (k-i == 1) {
            // edge case
            head.value = head.next.value;
            head.next = head.next.next;
        } else {
            slow.next = slow.next.next;
        }

        return head;
    }
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
