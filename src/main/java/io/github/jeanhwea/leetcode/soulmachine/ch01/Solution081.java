package io.github.jeanhwea.leetcode.soulmachine.ch01;

import java.util.*;

/**
 * 搜索旋转排序数组 II
 *
 * @author Jinghui Hu
 * @since 2021-06-28, JDK1.8
 */
public class Solution081 {

  public static boolean search(int[] a, int target) {
    int n = a.length, beg = 0, end = n - 1;
    while (beg <= end) {
      int mid = beg + (end - beg) / 2;
      if (a[mid] == target) return true;

      if (a[beg] < a[mid]) {
        if (a[beg] <= target && target < a[mid]) {
          end = mid - 1;
        } else {
          beg = mid + 1;
        }
      } else if (a[beg] > a[mid]) {
        if (a[mid] < target && target <= a[end]) {
          beg = mid + 1;
        } else {
          end = mid - 1;
        }
      } else {
        beg++;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = {1, 0, 1, 1, 1};
    System.out.println(search(a, 0));
  }
}
