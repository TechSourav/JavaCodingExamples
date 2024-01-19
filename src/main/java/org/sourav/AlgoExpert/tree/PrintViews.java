package org.sourav.AlgoExpert.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.sourav.practice.LL1;

public class PrintViews {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(topView(root));
        System.out.println(bottomView(root));
        System.out.println(leftSideView(root));
        System.out.println(rightSideView(root));
    }

    private static List<Integer> topView(final Node root) {
        List<Integer> list = new LinkedList<>();
        Queue<QueueObject> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();

        if (root == null) {
            return list;
        } else {
            queue.add(new QueueObject(root, 0));
        }

        while (!queue.isEmpty()) {
            QueueObject obj = queue.poll();
            if (!map.containsKey(obj.hd)) {
                map.put(obj.hd, obj.node);
            }
            if (obj.node.left != null) {
                queue.add(new QueueObject(obj.node.left, obj.hd - 1));
            }
            if (obj.node.right != null) {
                queue.add(new QueueObject(obj.node.right, obj.hd + 1));
            }
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            list.add(entry.getValue().data);
        }

        return list;
    }

    private static List<Integer> bottomView(final Node root) {
        List<Integer> list = new LinkedList<>();
        Queue<QueueObject> q = new LinkedList<>();
        Map<Integer, Node> m = new TreeMap<>();

        if (root == null)
            return list;

        q.add(new QueueObject(root, 0));

        while (!q.isEmpty()) {
            QueueObject obj = q.poll();
            m.put(obj.hd, obj.node);
            if (obj.node.left != null) {
                q.add(new QueueObject(obj.node.left, obj.hd - 1));
            }
            if (obj.node.right != null) {
                q.add(new QueueObject(obj.node.right, obj.hd + 1));
            }
        }

        for (Map.Entry<Integer, Node> entry : m.entrySet()) {
            list.add(entry.getValue().data);
        }

        return list;
    }

    private static List<Integer> leftSideView(final Node root) {
        final List<Integer> list = new LinkedList<>();
        final Queue<Node> q = new LinkedList<>();

        if (root == null)
            return list;

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 1; i <= n; i++) {
                final Node nd = q.poll();

                if (i == 1)
                    list.add(nd.data);
                if (nd.left != null)
                    q.add(nd.left);
                if (nd.right != null)
                    q.add(nd.right);
            }
        }

        return list;
    }

    private static List<Integer> rightSideView(final Node root) {
        final List<Integer> list = new LinkedList<>();
        final Queue<Node> q = new LinkedList<>();

        if (root == null)
            return list;

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 1; i <= n; i++) {
                final Node nd = q.poll();

                if (i == n)
                    list.add(nd.data);
                if (nd.left != null)
                    q.add(nd.left);
                if (nd.right != null)
                    q.add(nd.right);
            }
        }

        return list;
    }

    static class QueueObject {
        Node node;
        int hd;

        QueueObject(final Node root, final int hd) {
            this.node = root;
            this.hd = hd;
        }
    }

}
