package org.sourav.AlgoExpert.linkedlist;

public class FindIntersectionLinkedLists {

    public static void main(String[] args) {
        FindIntersectionLinkedLists.LinkedList ll1 = new FindIntersectionLinkedLists.LinkedList(1);
        ll1.next = new FindIntersectionLinkedLists.LinkedList(9);
        ll1.next.next = new FindIntersectionLinkedLists.LinkedList(4);
        ll1.next.next.next = new FindIntersectionLinkedLists.LinkedList(5);

        //FindIntersectionLinkedLists.LinkedList ll2 = ll1.next.next;
        FindIntersectionLinkedLists.LinkedList ll2 = new FindIntersectionLinkedLists.LinkedList(1);
        ll2.next = new FindIntersectionLinkedLists.LinkedList(3);
        ll2.next.next = new FindIntersectionLinkedLists.LinkedList(4);
        ll2.next.next.next = new FindIntersectionLinkedLists.LinkedList(5);
        ll2.next.next.next.next = new FindIntersectionLinkedLists.LinkedList(9);
        ll2.next.next.next.next.next = new FindIntersectionLinkedLists.LinkedList(10);

        FindIntersectionLinkedLists.LinkedList finalLL = mergingLinkedLists(ll1, ll2);

        System.out.println(finalLL);
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList temp1 = linkedListOne;
        LinkedList temp2 = linkedListTwo;

        /*int len1 = 0;
        int len2 = 0;

        while (temp1 != null) {
            temp1 = temp1.next;
            len1++;
        }
        while (temp2 != null) {
            temp2 = temp2.next;
            len2++;
        }

        if (len1 == 1 && len2 == 1) {
            if (linkedListOne.value == linkedListTwo.value) {
                return linkedListOne;
            } else {
                return null;
            }
        } else if (len1 > len2) {
            int diff1 = len1 - len2;
            while (diff1 > 0) {
                linkedListOne = linkedListOne.next;
                diff1--;
            }
        } else if (len1 < len2) {
            int diff2 = len2 - len1;
            while (diff2 > 0) {
                linkedListTwo = linkedListTwo.next;
                diff2--;
            }
        }
        while (linkedListOne != null || linkedListTwo != null) {
            if (linkedListOne.value == linkedListTwo.value) {
                return linkedListOne;
            }
            linkedListOne = linkedListOne.next;
            linkedListTwo = linkedListTwo.next;
        }*/

        while (temp1 !=temp2) {
            temp1 = (temp1 == null) ? linkedListTwo : temp1.next;
            temp2 = (temp2 == null) ? linkedListOne : temp2.next;;
        }
        return temp1;
    }

}
