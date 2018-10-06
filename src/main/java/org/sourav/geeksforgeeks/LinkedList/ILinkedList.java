package org.sourav.geeksforgeeks.LinkedList;

public interface ILinkedList {
    public void insertInBegining(int val);
    public void insertAtEnd(int val);
    public void insertAtMiddle(Node nd,int val);
    public void deleteInBegining(int val);
    public void deleteAtEnd(int val);
    public void deleteAtMiddle(Node nd,int val);
    public Node search(int data);
}
