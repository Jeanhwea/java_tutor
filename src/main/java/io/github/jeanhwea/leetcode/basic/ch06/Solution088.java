package io.github.jeanhwea.leetcode.basic.ch06;

import java.util.*;

/**
 * 合并两个有序数组
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution088 {

  // 双指针，添加临时数组
  public static void merge0(int[] a, int n, int[] b, int m) {
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

  // 逆序查找，避免额外申请数组空间
  public static void merge(int[] a, int n, int[] b, int m) {
    int i = n - 1, j = m - 1, k = n + m - 1;

    while (i >= 0 && j >= 0) {
      if (a[i] > b[j]) a[k--] = a[i--];
      else a[k--] = b[j--];
    }

    if (j >= 0) {
      while (j >= 0) a[k--] = b[j--];
    } else {
      while (i >= 0) a[k--] = a[i--];
    }
  }

  public static void main(String args[]) {
    int[] a = {1, 2, 3, 0, 0, 0};
    int[] b = {2, 5, 6};
    merge(a, 3, b, 3);
    System.out.println(Arrays.toString(a));
  }
}
