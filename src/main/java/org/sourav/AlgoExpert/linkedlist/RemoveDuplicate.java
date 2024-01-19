package org.sourav.AlgoExpert.linkedlist;

public class RemoveDuplicate {

    public static void main(String[] args) {
        LinkedList l = new LinkedList(1);
        l.next = new LinkedList(1);
        l.next.next = new LinkedList(1);
        l.next.next.next = new LinkedList(3);
        l.next.next.next.next = new LinkedList(4);
        l.next.next.next.next.next = new LinkedList(4);
        l.next.next.next.next.next.next = new LinkedList(4);
        l.next.next.next.next.next.next.next = new LinkedList(5);
        l.next.next.next.next.next.next.next.next = new LinkedList(6);
        l.next.next.next.next.next.next.next.next.next = new LinkedList(6);

        final LinkedList res = removeDuplicatesFromLinkedList(l);
        System.out.println(res);
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

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList tmp = linkedList;
        while (tmp.next != null) {
            if (tmp.value == tmp.next.value) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }

        return linkedList;
    }
}
