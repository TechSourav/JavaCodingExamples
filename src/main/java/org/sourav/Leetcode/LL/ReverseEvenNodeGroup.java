package org.sourav.Leetcode.LL;

import java.util.Arrays;
import java.util.List;

public class ReverseEvenNodeGroup {
    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {

        //  if LL has 1 or 2 nodes only
        if (head.next == null || head.next.next == null)
            return head;
        LinkedListNode node = head;
        int group = 1;

        while (node != null && node.next != null) {
            group++;

            //first check number of nodes
            int countNodes = 0;
            LinkedListNode temp = node.next;
            while (temp != null && countNodes < group) {
                temp = temp.next;
                countNodes++;
            }

            //now we have count now we will check if it is even then do reverse else skip
            if (countNodes % 2 == 0) {
                LinkedListNode curr = node.next, prev = null, next = null;
                for (int i = 0; i < countNodes; i++) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                LinkedListNode tail = node.next;
                tail.next = curr;
                node.next = prev;
                node = tail;
            } else {
                for (int i = 0; i < countNodes; i++)
                    node = node.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {

        // Declaring and creating a linked list
        LinkedList obj1 = new LinkedList();
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> inputList1 = Arrays.asList(10, 11, 12, 13, 14);
        List<Integer> inputList2 = Arrays.asList(15);
        List<Integer> inputList3 = Arrays.asList(16, 17);

        LinkedList inputLinkList1 = new LinkedList();
        inputLinkList1.createLinkedList(inputList);

        LinkedList inputLinkList2 = new LinkedList();
        inputLinkList2.createLinkedList(inputList1);

        LinkedList inputLinkList3 = new LinkedList();
        inputLinkList3.createLinkedList(inputList2);

        LinkedList inputLinkList4 = new LinkedList();
        inputLinkList4.createLinkedList(inputList3);

        List<LinkedListNode> listHeads = Arrays.asList(inputLinkList1.head, inputLinkList2.head, inputLinkList3.head, inputLinkList4.head);
        for (int i = 0; i< listHeads.size(); i++)
        {
            System.out.println(i+1 + ".\tIf we reverse the even length groups of the linked list:");
            PrintList.printListWithForwardArrow(listHeads.get(i));
            System.out.println("\n\n\twe will get: \t");
            PrintList.printListWithForwardArrow(reverseEvenLengthGroups(listHeads.get(i)));
            System.out.print("\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

// Template for the linked list
class LinkedList {
    public LinkedListNode head;
    // LinkedList() will be used to make a LinkedList type object.
    public LinkedList() {
        this.head = null;
    }
    // insert_node_at_head method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // create_linked_list method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(List<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst.get(i));
            insertNodeAtHead(newNode);
        }
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // LinkedListNode() will be used to make a LinkedListNode type object.
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class PrintList
{
    public static void printListWithForwardArrow(LinkedListNode head)
    {
        LinkedListNode temp = head;
        System.out.print("\t");
        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }
}
