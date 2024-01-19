package org.sourav.practice;

public class LL3 {

    public static void main(String[] args) {
        LL3.LinkedList ll1 = new LL3.LinkedList(2);
        ll1.next = new LL3.LinkedList(4);
        ll1.next.next = new LL3.LinkedList(7);
        ll1.next.next.next = new LL3.LinkedList(1);

        LL3.LinkedList ll2 = new LL3.LinkedList(9);
        ll2.next = new LL3.LinkedList(4);
        ll2.next.next = new LL3.LinkedList(5);

        LL3.LinkedList finalLL = sumOfLinkedLists(ll1, ll2);

        System.out.println(finalLL);
    }

    public static LL3.LinkedList sumOfLinkedLists(LL3.LinkedList linkedListOne, LL3.LinkedList linkedListTwo) {
        LL3.LinkedList finalListHead = null;
        LL3.LinkedList finalListTail = null;
        LL3.LinkedList newList = null;
        int carry = 0;
        while (linkedListOne != null && linkedListTwo != null) {
            int sum = linkedListOne.value + linkedListTwo.value + carry;
            carry = 0;
            if (sum / 10 > 0) {
                carry = sum / 10;
                newList = new LL3.LinkedList(sum % 10);
            } else
                newList = new LL3.LinkedList(sum);

            if (finalListHead == null) {
                finalListHead = newList;
                finalListTail = newList;
            } else {
                finalListTail.next = newList;
                finalListTail = newList;
            }

            linkedListOne = linkedListOne.next;
            linkedListTwo = linkedListTwo.next;
        }

        if (linkedListTwo != null) {
            int sum = linkedListTwo.value + carry;
            carry = 0;
            if (sum / 10 > 0) {
                carry = sum / 10;
                newList = new LL3.LinkedList(sum % 10);
            } else
                newList = new LL3.LinkedList(sum);
            finalListTail.next = newList;
            finalListTail = newList;
        } else if (linkedListOne != null) {
            int sum = linkedListOne.value + carry;
            carry = 0;
            if (sum / 10 > 0) {
                carry = sum / 10;
                newList = new LL3.LinkedList(sum % 10);
            } else
                newList = new LL3.LinkedList(sum);
            finalListTail.next = newList;
            finalListTail = newList;
        }

        return finalListHead;

    }

    public static class LinkedList {
        public int value;
        public LL3.LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
