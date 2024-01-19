package org.sourav.AlgoExpert.linkedlist;

public class ReverseList {

    public static void main(String[] args) {
        ReverseList.LinkedList l = new ReverseList.LinkedList(0);
        l.next = new ReverseList.LinkedList(1);
        l.next.next = new ReverseList.LinkedList(2);
        l.next.next.next = new ReverseList.LinkedList(3);
        l.next.next.next.next = new ReverseList.LinkedList(4);
        l.next.next.next.next.next = new ReverseList.LinkedList(5);
        l.next.next.next.next.next.next = new ReverseList.LinkedList(6);
        l.next.next.next.next.next.next.next = new ReverseList.LinkedList(7);
        l.next.next.next.next.next.next.next.next = new ReverseList.LinkedList(8);
        l.next.next.next.next.next.next.next.next.next = new ReverseList.LinkedList(9);

        System.out.println(reverseLinkedList(l));
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList aux = head;
        LinkedList next = null;
        while(aux != null) {
            LinkedList temp = aux.next;
            aux.next = next;
            next = aux;
            aux = temp;
        }
        head = next;
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
