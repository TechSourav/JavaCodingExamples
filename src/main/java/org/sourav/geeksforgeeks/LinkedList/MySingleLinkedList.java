package org.sourav.geeksforgeeks.LinkedList;

//import org.sourav.recursion.MyNode;

public class MySingleLinkedList implements ILinkedList{

    private Node node;

    // Below main is just a test code. All the methods should be called via Boot.java
    public static void main(String[] args) {
        MySingleLinkedList msll = new MySingleLinkedList();
        Node nd = new Node();
        Node.SLL sll = nd.new SLL(2);
        System.out.println(sll.getData());
        System.out.println(sll.getNext());
        msll.insertAtEnd(sll,3);
    }


    public void insertInBegining(Node.SLL sll , int val) {

    }

    @Override
    public void insertAtEnd(Node.SLL sll, int val) {

    }

    /*public void insertAtEnd(Node.SLL sll ,int val) {
        sll temp = nd;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new MyNode(c);
        return nd;
    }*/

    public void insertAtMiddle(Node nd, int val) {

    }

    public void deleteInBegining(int val) {

    }

    public void deleteAtEnd(int val) {

    }

    public void deleteAtMiddle(Node nd, int val) {

    }

    public Node search(int data) {
        return null;
    }
}
