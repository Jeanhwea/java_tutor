package io.github.jeanhwea.leetcode.interview.ch02_warmup;

import java.util.*;

/**
 * 多数元素
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution169 {

  public static int majorityElement(int[] a) {
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
