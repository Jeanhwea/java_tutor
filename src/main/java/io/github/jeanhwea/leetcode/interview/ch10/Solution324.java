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

  // 荷兰旗问题（通过 mid 三分数组，左端小于 mid ，右端大于 mid）
  private static int[] threeWayPart(int[] a, int mid) {
    int n = a.length;
    int[] b = Arrays.copyOf(a, n);
    int i = 0, j = 0, k = n - 1;
    while (j < k) {
      // System.out.printf("i=%d,j=%d,k=%d\n", i, j, k);
      // System.out.println(Arrays.toString(b));
      if (b[j] < mid) {
        swap(b, i, j);
        i++;
        j++;
      } else if (b[j] > mid) {
        swap(b, j, k);
        k--;
      } else {
        j++;
      }
    }
    return b;
  }

  // O(nlog(n)) 解法，TODO: 添加 O(n) 的解法
  public static void wiggleSort(int[] a) {
    Arrays.sort(a);
    int n = a.length, i = 0;
    int[] smaller = new int[n % 2 == 0 ? n / 2 : (n / 2 + 1)], bigger = new int[n / 2];

    System.arraycopy(a, 0, smaller, 0, smaller.length);
    System.arraycopy(a, smaller.length, bigger, 0, n / 2);

    for (; i < n / 2; i++) {
      a[2 * i] = smaller[smaller.length - 1 - i];
      a[2 * i + 1] = bigger[n / 2 - 1 - i];
    }

    if (n % 2 != 0) {
      a[2 * i] = smaller[smaller.length - 1 - i];
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 2, 1, 2, 2, 1, 1};
    System.out.println(Arrays.toString(a));
    wiggleSort(a);
    System.out.println(Arrays.toString(a));
  }
}
