package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 二分查找旋转数组
 *
 * @author Jinghui Hu
 * @since 2021-08-04, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0804 {

  public static void main(String[] args) {
    int[] a = {4, 5, 6, 7, 1, 2, 3};
    for (int i = 1; i <= 7; i++) {
      System.out.println(search(a, i));
    }
  }

  public static int search(int[] a, int k) {
    int beg = 0, end = a.length - 1;
    while (beg <= end) {
      int mid = beg + (end - beg) / 2;
      if (a[mid] == k) return mid;
      if (a[beg] < a[mid]) {
        if (a[beg] <= k && k < a[mid]) {
          end = mid - 1;
        } else {
          beg = mid + 1;
        }
      } else {
        if (a[end] <= k && k < a[mid]) {
          beg = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }
}
