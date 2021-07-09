package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 只出现一次的数字 II
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution137 {

  public static int singleNumber(int[] a) {
    Map<Integer, Integer> count = new HashMap<>();
    int n = a.length;
    for (int i = 0; i < n; i++) {
      count.put(a[i], count.getOrDefault(a[i], 0) + 1);
    }
    for (Map.Entry<Integer, Integer> e : count.entrySet()) {
      if (e.getValue() == 1) return e.getKey();
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {2, 2, 3, 2};
    System.out.println(singleNumber(a));
  }
}
