package org.sourav.AlgoExpert.linkedlist;

public class palindromeList {

    public static void main(String[] args) {
        LinkedList ll2 = new LinkedList(0);
        ll2.next = new LinkedList(1);
        ll2.next.next = new LinkedList(3);
        ll2.next.next.next = new LinkedList(2);
        ll2.next.next.next.next = new LinkedList(1);
        ll2.next.next.next.next.next = new LinkedList(0);

        System.out.println(linkedListPalindrome(ll2));
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static boolean linkedListPalindrome(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList reversedSecondHalfNode = reverseList(slow);
        slow = head;

        while (reversedSecondHalfNode != null) {
            if (slow.value != reversedSecondHalfNode.value) {
                return false;
            }
            slow = slow.next;
            reversedSecondHalfNode = reversedSecondHalfNode.next;
        }

        return true;
    }

    private static LinkedList reverseList(LinkedList head) {
        LinkedList prev = null;
        LinkedList curr = head;
        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
