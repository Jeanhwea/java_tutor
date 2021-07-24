package io.github.jeanhwea.leetcode.interview.ch10_sort_search;

/**
 * 寻找峰值
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution162 {

  // 暴露搜索法
  public static int findPeakElement0(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      long left = i > 0 ? a[i - 1] : Long.MIN_VALUE;
      long right = i < n - 1 ? a[i + 1] : Long.MIN_VALUE;
      if (a[i] > left && a[i] > right) return i;
    }
    return -1;
  }

  // 二分查找
  public static int findPeakElement(int[] a) {
    int n = a.length, beg = 0, end = n - 1;
    while (beg < end) {
      int mid = beg + (end - beg) / 2;
      if (a[mid] > a[mid + 1]) { // 处于下坡
        end = mid;
      } else {
        beg = mid + 1;
      }
    }
    return beg;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 1};
    System.out.println(findPeakElement(a));
  }
}
