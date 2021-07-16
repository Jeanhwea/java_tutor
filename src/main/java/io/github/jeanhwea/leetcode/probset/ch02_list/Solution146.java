package io.github.jeanhwea.leetcode.probset.ch02_list;

import java.util.*;

/**
 * LRU 缓存机制
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution146 {

  static class LRUCache {

    Map<Integer, int[]> cache;
    Deque<int[]> deque;
    int capacity;

    public LRUCache(int capacity) {
      cache = new HashMap<>();
      deque = new LinkedList<>();
      this.capacity = capacity;
    }

    public int get(int key) {
      int[] e = cache.get(key);
      if (e == null) return -1;
      moveToFirst(e);
      return e[1];
    }

    public void put(int key, int value) {
      int[] e = cache.get(key);
      if (e == null) {
        e = new int[] {key, value};
        cache.put(e[0], e);
        deque.addFirst(e);
        if (deque.size() > capacity) {
          int[] p = deque.peekLast();
          cache.remove(p[0]);
          deque.removeLast();
        }
      } else {
        e[1] = value;
        moveToFirst(e);
      }
    }

    private void moveToFirst(int[] e) {
      deque.remove(e);
      deque.addFirst(e);
    }
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 0); // 缓存是 {1=0}
    lRUCache.put(2, 2); // 缓存是 {1=0, 2=2}
    System.out.println(lRUCache.get(1)); // 返回 0
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=0, 3=3}
    System.out.println(lRUCache.get(2)); // 返回 -1 (未找到)
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    System.out.println(lRUCache.get(1)); // 返回 -1 (未找到)
    System.out.println(lRUCache.get(3)); // 返回 3
    System.out.println(lRUCache.get(4)); // 返回 4
  }
}
