package io.github.jeanhwea.leetcode.probset.ch12_dnc;

import java.util.*;

/**
 * 多数元素
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution169 {

  // 选举法
  public static int majorityElement(int[] a) {
    int n = a.length, candiate = 0, count = 0;

    for (int i = 0; i < n; i++) {
      if (count <= 0) {
        candiate = a[i];
        count++;
      } else {
        if (a[i] == candiate) {
          count++;
        } else {
          count--;
        }
      }
    }

    count = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == candiate) count++;
      if (count > n / 2) return candiate;
    }
    return -1;
  }

  // 统计法
  public static int majorityElement0(int[] a) {
    int n = a.length;
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int c = count.getOrDefault(a[i], 0) + 1;
      if (c + c >= n) return a[i];
      count.put(a[i], c);
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a1 = {1, 2, 3, 4, 2, 2, 2};
    System.out.println(majorityElement(a1));
  }
}
