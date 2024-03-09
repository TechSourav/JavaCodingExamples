package org.sourav.AlgoExpert.linkedlist;

import java.util.Objects;

import static org.sourav.AlgoExpert.linkedlist.ShiftLL.*;

public class ShiftLL {

    public static class LinkedList {

        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ShiftLL.LinkedList ll2 = new ShiftLL.LinkedList(1);
        ll2.next = new ShiftLL.LinkedList(2);
        ll2.next.next = new ShiftLL.LinkedList(3);
        ll2.next.next.next = new ShiftLL.LinkedList(4);
        ll2.next.next.next.next = new ShiftLL.LinkedList(5);
        //ll2.next.next.next.next.next = new ShiftLL.LinkedList(10);

        int k = 2;

        ShiftLL.LinkedList l = shiftList(ll2, k);
    }

    private static ShiftLL.LinkedList shiftList1(ShiftLL.LinkedList head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ShiftLL.LinkedList slow = head;
        ShiftLL.LinkedList fast = head;
        ShiftLL.LinkedList temp = head;

        if (k > 0) {
            int c = k;
            while (c > 0 && fast != null) {
                c--;
                fast = fast.next;
            }
            if (fast == null)
                return head;

            while (Objects.requireNonNull(fast).next != null) {
                k--;
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = head;
            head = slow.next;
            slow.next = null;

        } else if (k < 0) {
            while (k + 1 < 0) {
                k++;
                temp = temp.next;
            }
            if (temp == null)
                return head;

            while (fast != null && fast.next != null) {
                fast = fast.next;
            }
            fast.next = head;
            head = temp.next;
            temp.next = null;

            return head;
        } else {
            return head;
        }

        return head;

    }

    private static ShiftLL.LinkedList shiftList(ShiftLL.LinkedList head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ShiftLL.LinkedList elem = head;
        int size = 1;

        while (elem.next != null) {
            size++;
            elem = elem.next;
        }

        int normK = Math.abs(k) % size;
        if (normK == 0)
            return head;
        elem.next = head;

        LinkedList newHead = null;
        int newEndIndex = k > 0 ? size - normK : normK;

        for (int i = 0; i <= newEndIndex; i++) {
            if (i == newEndIndex) {
                newHead = elem.next;
                elem.next = null;
                break;
            }
            elem = elem.next;
        }

        return newHead;
    }

}
