package io.github.jeanhwea.leetcode.interview.ch10;

import java.util.*;

/**
 * 寻找重复数
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution287 {

  // 桶排
  public static int findDuplicate0(int[] a) {
    int n = a.length;
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
      if (c[a[i] - 1] > 0) return a[i];
      c[a[i] - 1] = 1;
    }
    return -1;
  }

  // 二分法
  public static int findDuplicate(int[] a) {
    int n = a.length, beg = 0, end = n - 1;
    while (beg < end) {
      int mid = beg + (end - beg) / 2;
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (a[i] <= mid) count++;
      }
      if (count <= mid) {
        beg = mid + 1;
      } else {
        end = mid;
      }
    }
    return beg;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 4, 2, 2};
    System.out.println(findDuplicate(a));
  }
}
