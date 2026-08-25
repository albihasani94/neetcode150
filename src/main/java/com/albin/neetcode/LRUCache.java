package com.albin.neetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Category: Linked List
 * <p>
 * <a href="https://neetcode.io/problems/lru-cache/question?list=neetcode150">NeetCode: LRU Cache</a>
 */
public class LRUCache {

    Map<Integer, Node> backingMap;
    Node left;
    Node right;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        backingMap = new HashMap<>();

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        var node = backingMap.get(key);
        if (node != null) {
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        var node = backingMap.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            insert(node);
        } else {
            insert(new Node(key, value));
        }


        if (backingMap.size() > capacity) {
            var lru = left.next;
            remove(lru);
        }
    }

    private void insert(Node node) {
        var lastMru = right.prev;

        right.prev = node;
        node.next = right;

        lastMru.next = node;
        node.prev = lastMru;

        backingMap.put(node.key, node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        backingMap.remove(node.key);
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
