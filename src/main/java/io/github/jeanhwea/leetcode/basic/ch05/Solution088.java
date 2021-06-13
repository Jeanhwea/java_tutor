package io.github.jeanhwea.leetcode.basic.ch05;

import java.util.*;

/**
 * 合并两个有序数组
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution088 {

  public static void merge(int[] a, int n, int[] b, int m) {
    int[] c = new int[n + m];
    int i = 0, j = 0, k = 0;
    while (i < n && j < m) {
      if (a[i] < b[j]) c[k++] = a[i++];
      else c[k++] = b[j++];
    }

    if (i < n) {
      while (i < n) c[k++] = a[i++];
    } else {
      while (j < m) c[k++] = b[j++];
    }

    for (int p = 0; p < n + m; p++) a[p] = c[p];
  }

  public static void main(String args[]) {
    int[] a = {1, 2, 4, 0, 0, 0, 0};
    int[] b = {2, 2, 4, 5};
    merge(a, 3, b, 4);
    System.out.println(Arrays.toString(a));
  }
}
