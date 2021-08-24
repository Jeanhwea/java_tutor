package io.github.jeanhwea.leetcode.probset.ch01_array;

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

    // Step1: 从右向左扫描得到递减的数值
    int i = n - 2;
    while (i >= 0 && a[i] >= a[i + 1]) i--;

    // Step2: 如果找到递减值 a[i], 则从右向左扫描得到比 a[i] 大的值
    if (i >= 0) {
      int j = n - 1;
      while (j >= 0 && a[j] <= a[i]) j--;
      // 找到后交换 a[i], a[j]
      if (j >= 0) swap(a, i, j);
    }

    // Step3: 整体翻转列表 a[i+1:]
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
