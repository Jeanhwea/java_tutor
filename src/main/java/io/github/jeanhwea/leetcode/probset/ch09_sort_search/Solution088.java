package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 合并两个有序数组
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution088 {

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = n + m - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
    while (j >= 0) nums1[k--] = nums2[j--];
  }

  public static void main(String[] args) {
    // pass
  }
}
