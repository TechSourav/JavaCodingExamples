package org.sourav.AlgoExpert.linkedlist;

public class MyDoublyLinkedList {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (this.head == null) {
                this.head = node;
                this.tail = node;
                return;
            }
            this.insertBefore(this.head, node);
        }

        public void setTail(Node node) {
            if (this.tail == null) {
                this.head = node;
                this.tail = node;
                return;
            }
            this.insertAfter(this.tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (node.value == this.head.value) {
                nodeToInsert.next = this.head;
                this.head = nodeToInsert;
                return;
            }
            node.prev.next = nodeToInsert;
            nodeToInsert.prev = node.prev;
            node.prev = nodeToInsert;
            nodeToInsert.next = node;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (node.value == this.head.value) {
                nodeToInsert.prev = this.head;
                nodeToInsert.next = this.head.next;
                this.head.next = nodeToInsert;
                return;
            }
            if (node.value == this.tail.value) {
                nodeToInsert.prev = this.tail;
                nodeToInsert.next = null;
                this.tail.next = nodeToInsert;
                this.tail = nodeToInsert;
                return;
            }
            nodeToInsert.next = node.next;
            node.next.prev = nodeToInsert;
            nodeToInsert.prev = node;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            int c = 1;
            Node curr = this.head;
            while (c != position) {
                curr = curr.next;
                c++;
            }
            this.insertAfter(curr, nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            Node curr = this.head;
            while (curr.value != value) {
                curr = curr.next;
            }
            this.remove(curr);
        }

        public void remove(Node node) {
            if (this.head == node) {
                this.head = this.head.next;
                this.head.prev = null;
            }
            if (this.tail == node) {
                this.tail.prev.next = null;
            }
            if (node.prev !=null) {
                node.prev.next = node.next;
            }
            if (node.next !=null) {
                node.next.prev = node.prev;
            }
            node.next = null;
            node.prev = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node curr = this.head;
            while (curr !=null) {
                if (curr.value == value) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
