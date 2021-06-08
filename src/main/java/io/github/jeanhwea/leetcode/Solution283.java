package io.github.jeanhwea.leetcode;

import java.util.*;

/**
 * 移动零
 *
 * @author Jinghui Hu
 * @since 2021-06-08, JDK1.8
 */
public class Solution283 {
  public static void moveZeroes(int[] a) {
    int n = a.length, h = 0;

    for (int i = 0; i < n; i++) {
      if (a[i] != 0) a[h++] = a[i];
    }

    while (h < n) a[h++] = 0;
  }

  public static void main(String args[]) {
    int[] a = {0, 3, 2, 0, 0, 2, 3, 9};
    System.out.println(Arrays.toString(a));
    moveZeroes(a);
    System.out.println(Arrays.toString(a));
  }
}
