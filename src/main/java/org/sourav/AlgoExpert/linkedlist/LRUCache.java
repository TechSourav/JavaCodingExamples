package org.sourav.AlgoExpert.linkedlist;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LRUCache {

    public static void main(String[] args) {
        MyLRUCache lruCache = new MyLRUCache(3);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("c", 3);
        assertTrue(lruCache.getMostRecentKey() == "c");
        assertTrue(lruCache.getValueFromKey("a").value == 1);
        assertTrue(lruCache.getMostRecentKey() == "a");
        lruCache.insertKeyValuePair("d", 4);
        LRUResult evictedValue = lruCache.getValueFromKey("b");
        assertTrue(evictedValue == null || evictedValue.found == false);
        lruCache.insertKeyValuePair("a", 5);
        assertTrue(lruCache.getValueFromKey("a").value == 5);

        /*MyLRUCache cache = new MyLRUCache(4);
        cache.insertKeyValuePair("b", 2);
        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("c", 3);

        String k1 = cache.getMostRecentKey();
        System.out.println("key - " + k1);

        LRUResult res = cache.getValueFromKey("a");
        System.out.println("key-val - " + res);

        String k2 = cache.getMostRecentKey();
        System.out.println("key - " + k2);

        cache.insertKeyValuePair("d", 4);

        LRUResult res2 = cache.getValueFromKey("b");
        System.out.println("key-val - " + res2);

        cache.insertKeyValuePair("a", 5);

        LRUResult res3 = cache.getValueFromKey("a");
        System.out.println("key-val - " + res3);*/
    }

    static class MyLRUCache {
        int maxSize;
        Map<String, Node> hm;
        Node head = new Node();
        Node tail = new Node();

        public MyLRUCache(int maxSize) {
            this.maxSize = Math.max(maxSize, 1);
            hm = new HashMap<>(maxSize);
            head.next = tail;
            tail.prev = head;
        }

        public void insertKeyValuePair(String key, int value) {
            Node newNode = new Node(value, key);
            Node nd = hm.get(key);
            if (nd != null) {
                remove(nd);
                add(newNode);
                hm.put(key, newNode);
            } else {
                add(newNode);
                hm.put(key, newNode);
            }
        }

        public LRUResult getValueFromKey(String key) {
            Node nd = hm.get(key);
            if(nd == null) {
                return null;
            } else {
                LRUResult res = new LRUResult(true, nd.val);
                remove(nd);
                add(nd);
                return res;
            }
        }

        public String getMostRecentKey() {
            // Write your code here.
            return head.key;
        }

        private Node add(Node nd) {
            nd.next = head;
            head.prev = nd;

            head = nd;
            return nd;
        }

        private void remove(Node nd) {
            if (nd == head) {
                head = nd.next;
                nd.next.prev = null;
                return;
            }
            nd.prev.next = nd.next;
            nd.next.prev = nd.prev;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    static class Node {

        String key;
        int val;
        Node next;
        Node prev;

        Node(){
            this.next = null;
            this.prev = null;
        }

        Node(int val, String key) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

}
