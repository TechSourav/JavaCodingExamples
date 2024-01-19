package org.sourav.AlgoExpert.linkedlist;

public class MergeLinkedLists {

    public static void main(String[] args) {
        MergeLinkedLists.LinkedList ll1 = new MergeLinkedLists.LinkedList(2);
        ll1.next = new MergeLinkedLists.LinkedList(6);
        ll1.next.next = new MergeLinkedLists.LinkedList(7);
        ll1.next.next.next = new MergeLinkedLists.LinkedList(8);

        MergeLinkedLists.LinkedList ll2 = new MergeLinkedLists.LinkedList(1);
        ll2.next = new MergeLinkedLists.LinkedList(3);
        ll2.next.next = new MergeLinkedLists.LinkedList(4);
        ll2.next.next.next = new MergeLinkedLists.LinkedList(5);
        ll2.next.next.next.next = new MergeLinkedLists.LinkedList(9);
        ll2.next.next.next.next.next = new MergeLinkedLists.LinkedList(10);

        mergeLinkedLists(ll1, ll2);
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList mergedList = headOne.value >= headTwo.value ? headTwo : headOne; // 1 - 3 - 4 - 5 - 9 - 10
        LinkedList secondList = headOne.value >= headTwo.value ? headOne : headTwo; // 2 - 6 - 7 - 8

        LinkedList firstPrev = new MergeLinkedLists.LinkedList(-1);
        LinkedList firstCurr = mergedList;
        LinkedList secondCurr = secondList;

        while (firstCurr!=null && secondCurr!=null) {
            if (firstCurr.value <= secondCurr.value) {
                firstPrev = firstCurr;
                firstCurr = firstCurr.next;
            } else {
                LinkedList insertedElement = secondCurr;
                secondCurr = secondCurr.next;
                insertedElement.next = firstCurr;
                if (firstPrev != null) {
                    firstPrev.next = insertedElement;
                }
                firstPrev = insertedElement;
            }
        }

        if (secondCurr != null) {
            firstPrev.next = secondCurr;
        }

        return mergedList;

        /*while(true) {
            if (firstCurr == null) {
                firstPrev.next = secondCurr;
                break;
            }
            if (secondCurr == null) {
                firstPrev.next = firstCurr;
                break;
            }

            if (firstCurr.value <= secondCurr.value) {
                firstPrev.next = firstCurr;
                firstCurr = firstCurr.next;
            } else {
                firstPrev.next = secondCurr;
                secondCurr = secondCurr.next;
            }

            //Advance the tail
            firstPrev = firstPrev.next;
        }

        return mergedList;*/
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }


}
