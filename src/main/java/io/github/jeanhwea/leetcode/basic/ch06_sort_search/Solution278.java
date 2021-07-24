package io.github.jeanhwea.leetcode.basic.ch06_sort_search;

/**
 * 第一个错误的版本
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution278 {

  private static boolean isBadVersion(int version) {
    return version > 3;
  }

  // 单向缩紧区间
  public static int firstBadVersion(int n) {
    int i = 1, j = n;

    while (i < j) {
      int k = i + (j - i) / 2;
      if (isBadVersion(k)) j = k;
      else i = k + 1;
    }

    return i;
  }

  // 二分查找
  public static int firstBadVersion0(int n) {
    int i = 1, j = n;

    while (i <= j) {
      int k = i + (j - i) / 2;
      if (!isBadVersion(k - 1) && isBadVersion(k)) return k;
      else if (isBadVersion(k)) j = k - 1;
      else i = k + 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(firstBadVersion(6));
  }
}
