package io.github.jeanhwea.leetcode.interview.ch10;

import java.util.*;

/**
 * 摆动排序 II
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution324 {

  private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static int findKth(int[] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
    for (int i = 0; i < a.length; i++) {
      pq.offer(a[i]);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();
  }

  public static void wiggleSort(int[] a) {
    int n = a.length;
    int mid = findKth(a, n / 2);
    System.out.println(mid);

    // 荷兰旗问题（通过 mid 三分数组）
    int[] b = Arrays.copyOf(a, n);
    int i = 0, j = 0, k = n - 1;
    while (i < k) {
      if (b[i] < mid) {
        i++;
        j++;
      } else if (b[i] > mid) {
        swap(b, i, k--);
      } else {
        swap(b, i++, j++);
      }
    }

    System.out.println(Arrays.toString(b));
    for (i = 0; i < n; i++) {}
  }

  public static void main(String[] args) {
    int[] a = {1, 5, 1, 1, 6, 4};
    System.out.println(Arrays.toString(a));
    wiggleSort(a);
    System.out.println(Arrays.toString(a));
  }
}
