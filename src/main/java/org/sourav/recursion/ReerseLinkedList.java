package org.sourav.recursion;

public class ReerseLinkedList {
    static MyNode head;

    public static void main(String[] args) {
        MyNode n = new MyNode(1);
        n = n.insert(n, 2);
        n = n.insert(n, 3);
        n = n.insert(n, 4);
        n = n.insert(n, 5);
        n = n.insert(n, 6);
        System.out.println("Before Reverse");
        printList(n);
        n = reverseList(n);
        System.out.println("After Reverse");
        printList(n);
    }

    private static void printList(MyNode n) {
        MyNode t = n;
        while (t != null) {
            System.out.println(t.data);
            t = t.next;
        }
    }

    private static MyNode reverseList(MyNode n) {
        System.out.println("Current Stack: " + n.data);
        MyNode temp = n;
        if (temp.next == null) {
            head = temp;
            return head;
        } else {
            MyNode t = reverseList(temp.next);
            MyNode x = t;
            while (x.next != null) {
                x = x.next;
            }
            x.next = n;
            n.next = null;
            head = t;
            return head;
        }

    }


}
