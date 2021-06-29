package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 旋转数组
 *
 * @author Jinghui Hu
 * @since 2021-06-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution189 {

  // 临时中转数组
  public static void rotate(int[] a, int k) {
    int n = a.length;
    int[] b = Arrays.copyOf(a, n);
    for (int i = 0; i < n; i++) {
      a[(i + k) % n] = b[i];
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    rotate(a, 2);
    System.out.println(Arrays.toString(a));
  }
}
