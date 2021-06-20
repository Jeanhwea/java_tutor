package io.github.jeanhwea.leetcode.soulmachine.ch02;

import java.util.*;

/**
 * 搜索旋转排序数组
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution033 {

  /**
   * 将数组一分为二，必定一个子数组有序，判断 k 是否在有序组中来进行二分查找
   *
   * @author Jinghui Hu
   * @since 2021-06-20, JDK1.8
   */
  public static int search(int[] a, int k) {
    int n = a.length, lo = 0, hi = n - 1, mid;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      // System.out.printf("lo=%d,hi=%d\n", lo, hi);
      if (a[mid] == k) return mid;

      if (a[lo] <= a[mid]) {
        if (a[lo] <= k && k < a[mid]) {
          hi = mid;
        } else {
          lo = mid + 1;
        }
      } else {
        if (a[mid] < k && k <= a[hi]) {
          lo = mid + 1;
        } else {
          hi = mid;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {5, 1, 3};
    System.out.println(search(a, 3));
  }
}
