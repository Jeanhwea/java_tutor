package io.github.jeanhwea.leetcode.interview.ch06;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * @author Jinghui Hu
 * @since 2021-06-18, JDK1.8
 */
@SuppressWarnings("all")
public class Solution347 {

  public static int[] topKFrequent(int[] a, int k) {
    int n = a.length;
    int[] b = new int[k];
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < n; i++) {
      count.put(a[i], count.getOrDefault(a[i], 0) + 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(count::get));
    for (Integer key : count.keySet()) {
      if (pq.size() < k) {
        pq.offer(key);
      } else if (count.get(pq.peek()) < count.get(key)) {
        pq.poll();
        pq.offer(key);
      }
    }

    for (int i = 0; i < k; i++) {
      b[i] = pq.poll();
    }

    return b;
  }

  public static void main(String[] args) {
    int[] a = {4, 1, -1, 2, -1, 2, 3};
    System.out.println(Arrays.toString(topKFrequent(a, 2)));
  }
}
