package org.sourav.AlgoExpert.linkedlist;

public class SumOfLL {
    public static void main(String[] args) {
        SumOfLL.LinkedList ll1 = new SumOfLL.LinkedList(1);
        ll1.next = new SumOfLL.LinkedList(1);
        ll1.next.next = new SumOfLL.LinkedList(1);
        //ll1.next.next.next = new SumOfLL.LinkedList(1);

        SumOfLL.LinkedList ll2 = new SumOfLL.LinkedList(9);
        ll2.next = new SumOfLL.LinkedList(9);
        ll2.next.next = new SumOfLL.LinkedList(9);

        LinkedList finalLL = sumOfLinkedLists(ll1, ll2);

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

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList finalList = null;
        LinkedList temp = null;
        int reminder = 0;
        while (linkedListOne !=null || linkedListTwo !=null) {
            int newVal = (linkedListOne == null ? 0 : linkedListOne.value) + (linkedListTwo == null ? 0 : linkedListTwo.value) + reminder;
            if (newVal - 10 >= 0) {
                reminder = 1;
            } else {
                reminder = 0;
            }
            if (finalList == null) {
                finalList = new LinkedList(newVal % 10);
                temp = finalList;
            } else {
                temp.next = new LinkedList(newVal % 10);
            }
            if(linkedListOne !=null) {
                linkedListOne = linkedListOne.next;
            }
            if (linkedListTwo!=null) {
                linkedListTwo = linkedListTwo.next;
            }
            if (temp.next !=null) {
                temp = temp.next;
            }
        }
        if (reminder == 1) {
            temp.next = new LinkedList(reminder);
        }
        return finalList;
    }

}
