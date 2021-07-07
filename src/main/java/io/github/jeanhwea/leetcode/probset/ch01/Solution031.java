package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 下一个排列
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution031 {

  public static void nextPermutation(int[] a) {
    int n = a.length;

    int i = n - 2;
    while (i >= 0 && a[i] >= a[i + 1]) i--;
    if (i >= 0) {
      int j = n - 1;
      while (j >= 0 && a[j] <= a[i]) j--;
      if (j >= 0) swap(a, i, j);
    }

    reverse(a, i + 1, n - 1);
  }

  public static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void reverse(int[] a, int i, int j) {
    while (i < j) {
      swap(a, i++, j--);
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 2};
    // int[] a = {1, 1};
    nextPermutation(a);
    System.out.println(Arrays.toString(a));
  }
}
