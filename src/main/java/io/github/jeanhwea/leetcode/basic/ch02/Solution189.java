package io.github.jeanhwea.leetcode.basic.ch02;

import java.util.*;

/**
 * 旋转数组
 *
 * @author Jinghui Hu
 * @since 2021-06-07, JDK1.8
 */
public class Solution189 {

  public static void rotate(int[] a, int k) {
    int n = a.length;
    int[] b = new int[n];
    k %= n;
    for (int i = 0; i < n; i++) {
      b[i] = a[i];
    }
    for (int i = 0; i < n; i++) {
      a[i] = b[(i - k + n) % n];
    }
  }

  public static void rotate0(int[] a, int k) {
    int count = 0, start = 0, n = a.length;
    k %= n;
    while (true) {
      if (count >= n) break;
      int t = a[start], c = start;
      do {
        int p = (c - k + n) % n;
        boolean closed = p == start;
        a[c] = closed ? t : a[p];
        ++count;
        if (closed) {
          ++start;
          break;
        }
        c = p;
      } while (true);
    }
  }

  public static void main(String args[]) {
    int[] a = {1, 2, 3, 4, 5};
    System.out.println(Arrays.toString(a));
    System.out.println("========================================");
    rotate(a, 2);
    System.out.println(Arrays.toString(a));

    System.out.println("");
    a = new int[] {1, 2, 3, 4};
    System.out.println(Arrays.toString(a));
    System.out.println("========================================");
    rotate(a, 2);
    System.out.println(Arrays.toString(a));
  }
}
