package io.github.jeanhwea.leetcode.interview.ch06;

import java.util.*;

/**
 * 数组中的第K个最大元素
 *
 * @author Jinghui Hu
 * @since 2021-06-16, JDK1.8
 */
public class Solution215 {

  public static int findKthLargest(int[] a, int k) {
    int n = a.length;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      if (i < k) {
        pq.offer(a[i]);
      } else if (pq.peek() < a[i]) {
        pq.poll();
        pq.offer(a[i]);
      }
    }

    return pq.peek();
  }

  public static void main(String args[]) {
    int[] a = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(a, 2));
  }
}
