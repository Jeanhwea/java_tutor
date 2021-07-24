package io.github.jeanhwea.leetcode.interview.ch11_dp;

import java.util.*;

/**
 * 最长连续序列
 *
 * @author Jinghui Hu
 * @since 2021-06-24, JDK1.8
 */
@SuppressWarnings("all")
public class Solution128 {

  public static int longestConsecutive0(int[] a) {
    Arrays.sort(a);
    int n = a.length, i = 0, prev = 0, len = 0, ans = 0;
    // System.out.println(Arrays.toString(a));

    while (i < n) {
      while (i == 0 || (i < n && a[i] <= prev + 1)) {
        if (i == 0 || a[i] != prev) len++;
        prev = a[i++];
      }
      ans = Math.max(ans, len);
      if (i < n) {
        len = 1;
        prev = a[i++];
      }
    }

    return ans;
  }

  public static int longestConsecutive(int[] a) {
    int ans = 0;
    Set<Integer> nums = new HashSet<>();
    for (int i = 0; i < a.length; i++) nums.add(a[i]);

    for (int num : nums) {
      if (nums.contains(num - 1)) continue;

      int count = 0;
      while (nums.contains(num++)) count++;
      ans = Math.max(ans, count);
    }
    return ans;
  }

  public static void main(String[] args) {
    // int[] a = {100, 4, 200, 1, 3, 2};
    // int[] a = {0, 1, 0, 3, 2};
    int[] a = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    // int[] a = {};
    System.out.println(longestConsecutive(a));
  }
}
