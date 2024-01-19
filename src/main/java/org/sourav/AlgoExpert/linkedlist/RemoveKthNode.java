package org.sourav.AlgoExpert.linkedlist;

import org.sourav.practice.LL2;

public class RemoveKthNode {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList temp = head;
        int len = 0;
        while (temp!=null) {
            len++;
            temp = temp.next;
        }
        int toBeDeleted = len - k;
        int count = 1;
        // if head node to be deleted
        if (toBeDeleted == 0) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        LinkedList temp2 = head;
        while (count != toBeDeleted) {
            count++;
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
    }

    // Sol 2
    /*public static LinkedList RemoveKthNodeFromEnd(LL2.LinkedList head, int k) {

        LinkedList slow = head;
        LinkedList fast = head;

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
    }*/

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        RemoveKthNode.LinkedList l = new RemoveKthNode.LinkedList(0);
        l.next = new RemoveKthNode.LinkedList(1);
        l.next.next = new RemoveKthNode.LinkedList(2);
        l.next.next.next = new RemoveKthNode.LinkedList(3);
        l.next.next.next.next = new RemoveKthNode.LinkedList(4);
        l.next.next.next.next.next = new RemoveKthNode.LinkedList(5);
        l.next.next.next.next.next.next = new RemoveKthNode.LinkedList(6);
        l.next.next.next.next.next.next.next = new RemoveKthNode.LinkedList(7);
        l.next.next.next.next.next.next.next.next = new RemoveKthNode.LinkedList(8);
        l.next.next.next.next.next.next.next.next.next = new RemoveKthNode.LinkedList(9);
        removeKthNodeFromEnd(l, 4);
    }

}
