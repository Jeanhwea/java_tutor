package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 颜色分类
 *
 * @author Jinghui Hu
 * @since 2021-08-04, JDK1.8
 */
@SuppressWarnings("all")
public class Solution075 {

  public static void sortColors(int[] a) {
    int i = -1, k = 0, j = a.length;
    while (k < j) {
      if (a[k] < 1) {
        swap(a, k++, ++i);
      } else if (a[k] > 1) {
        swap(a, k, --j);
      } else {
        k++;
      }
    }
  }

  private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void main(String[] args) {
    int[] nums = {2, 0, 2, 1, 1, 0};
    sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}
