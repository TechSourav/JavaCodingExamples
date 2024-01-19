package org.sourav.practice;

public class LL5 {

    public static void main(String[] args) {
        LL5.LinkedList l = new LL5.LinkedList(0);
        l.next = new LL5.LinkedList(1);
        l.next.next = new LL5.LinkedList(2);
        l.next.next.next = new LL5.LinkedList(3);
        l.next.next.next.next = new LL5.LinkedList(4);
        l.next.next.next.next.next = new LL5.LinkedList(5);
        l.next.next.next.next.next.next = new LL5.LinkedList(6);
        l.next.next.next.next.next.next.next = new LL5.LinkedList(7);
        l.next.next.next.next.next.next.next.next = new LL5.LinkedList(8);
        l.next.next.next.next.next.next.next.next.next = new LL5.LinkedList(9);

        System.out.println(reverseLinkedList(l));
    }

    public static LL5.LinkedList reverseLinkedList(LL5.LinkedList head) {
        LL5.LinkedList s = head;
        while (s != null || s.next != null ) {
            LL5.LinkedList temp = s.next;
            LL5.LinkedList p = temp.next;
            s.next.next = s;
            s = s.next;
            s.next.next = p;
        }


        return null;
    }

    static class LinkedList {
        int value;
        LL5.LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
