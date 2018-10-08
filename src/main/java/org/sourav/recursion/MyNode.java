package org.sourav.recursion;

class MyNode {
    int data;
    MyNode next;

    MyNode(int v) {
        this.data = v;
        this.next = null;
    }

    public MyNode insert(MyNode nd, int c) {
        MyNode temp = nd;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new MyNode(c);
        return nd;
    }
}