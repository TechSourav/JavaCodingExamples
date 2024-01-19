package org.sourav.AlgoExpert.linkedlist;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyDoublyLinkedListTest {
    private List<Integer> getNodeValuesHeadToTail(MyDoublyLinkedList.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        MyDoublyLinkedList.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(MyDoublyLinkedList.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        MyDoublyLinkedList.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void bindNodes(MyDoublyLinkedList.Node nodeOne, MyDoublyLinkedList.Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        MyDoublyLinkedList.DoublyLinkedList linkedList = new MyDoublyLinkedList.DoublyLinkedList();
        MyDoublyLinkedList.Node one = new MyDoublyLinkedList.Node(1);
        MyDoublyLinkedList.Node two = new MyDoublyLinkedList.Node(2);
        MyDoublyLinkedList.Node three = new MyDoublyLinkedList.Node(3);
        MyDoublyLinkedList.Node three2 = new MyDoublyLinkedList.Node(3);
        MyDoublyLinkedList.Node three3 = new MyDoublyLinkedList.Node(3);
        MyDoublyLinkedList.Node four = new MyDoublyLinkedList.Node(4);
        MyDoublyLinkedList.Node five = new MyDoublyLinkedList.Node(5);
        MyDoublyLinkedList.Node six = new MyDoublyLinkedList.Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        linkedList.setHead(four);

        linkedList.setTail(six);

        linkedList.insertBefore(six, three);

        linkedList.insertAfter(six, three2);

        linkedList.insertAtPosition(1, three3);

        linkedList.removeNodesWithValue(3);

        linkedList.remove(two);
    }
}

