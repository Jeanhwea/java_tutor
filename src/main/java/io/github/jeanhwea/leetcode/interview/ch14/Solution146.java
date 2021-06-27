package io.github.jeanhwea.leetcode.interview.ch14;

import java.util.*;

/**
 * LRU 缓存机制
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution146 {

  public static class LRUCache {

    public static class Node {
      int key, val;
      Node prev, next;

      public Node(int key, int val) {
        this.key = key;
        this.val = val;
      }
    }

    private final HashMap<Integer, Node> cache;
    private Node head, tail;
    private int size;
    private final int capacity;

    public LRUCache(int capacity) {
      cache = new HashMap<>();
      this.capacity = capacity;
      this.size = 0;
    }

    public int get(int key) {
      Node p = cache.get(key);
      if (p == null) return -1;
      moveToFirst(p);
      return p.val;
    }

    public void put(int key, int value) {
      Node p = cache.get(key);
      if (p == null) {
        cache.put(key, addFirst(new Node(key, value)));
        size++;
        if (size > capacity) {
          Node e = removeLast();
          cache.remove(e.key);
          size--;
        }
        // System.out.println("size=" + size + ",capacity=" + capacity);
      } else {
        p.val = value;
        moveToFirst(p);
      }
    }

    private Node addFirst(Node p) {
      if (head == null) {
        head = tail = p;
      } else {
        p.next = head;
        head.prev = p;
        head = p;
      }
      return head;
    }

    private Node removeLast() {
      if (tail == null) return null;
      Node p = tail;
      tail = tail.prev;
      tail.next = null;
      return p;
    }

    private Node moveToFirst(Node p) {
      if (p == head) return head;
      if (p == tail) tail = tail.prev;
      if (p.prev != null) p.prev.next = p.next;
      if (p.next != null) p.next.prev = p.prev;
      return addFirst(p);
    }
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 0); // 缓存是 {1=1}
    lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    System.out.println(lRUCache.get(1)); // 返回 1
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    System.out.println(lRUCache.get(2)); // 返回 -1 (未找到)
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    System.out.println(lRUCache.get(1)); // 返回 -1 (未找到)
    System.out.println(lRUCache.get(3)); // 返回 3
    System.out.println(lRUCache.get(4)); // 返回 4
  }

  public static void main2(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // 缓存是 {1=1}
    lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    System.out.println(lRUCache.get(1)); // 返回 1
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    System.out.println(lRUCache.get(2)); // 返回 -1 (未找到)
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    System.out.println(lRUCache.get(1)); // 返回 -1 (未找到)
    System.out.println(lRUCache.get(3)); // 返回 3
    System.out.println(lRUCache.get(4)); // 返回 4
  }
}
