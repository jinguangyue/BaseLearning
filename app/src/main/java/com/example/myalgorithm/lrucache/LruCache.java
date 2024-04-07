package com.example.myalgorithm.lrucache;


import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {
    public int capacity;
    private Map<K, ListNode<K ,V>> cache;

    private ListNode<K, V> head;
    private ListNode<K, V> tail;

    LruCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode<>(null, null);
        tail = new ListNode<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            ListNode<K, V> node = cache.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (cache.size() == capacity) {
                ListNode<K, V> removed = removeTail();
                cache.remove(removed.key);
            }

            ListNode<K, V> node = new ListNode<>(key, value);
            cache.put(key, node);
            addToHead(node);
        }
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            ListNode<K, V> node = cache.get(key);
            moveToHead(node);
            return node.val;
        }

        return null;
    }

    private void moveToHead(ListNode<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(ListNode<K, V> node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private ListNode<K, V> removeTail() {
        ListNode<K, V> removed = tail.prev;
        removeNode(removed);
        return removed;
    }

    private void removeNode(ListNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public class ListNode<K, V> {
        ListNode<K, V> next;
        ListNode<K, V> prev;
        V val;
        K key;

        public ListNode( K key, V val) {
            this.val = val;
            this.key = key;
        }
    }
}
