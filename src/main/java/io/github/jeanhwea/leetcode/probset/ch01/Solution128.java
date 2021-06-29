package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 最长连续序列
 *
 * @author Jinghui Hu
 * @since 2021-06-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution128 {

  // public static int longestConsecutive(int[] a) {
  //   int n = a.length;
  //   Map<Integer, Integer> map = new HashMap<>();

  //   int ans = 0;
  //   for (int i = 0; i < n; i++) {
  //     int len = map.getOrDefault(a[i] - 1, 0) + 1;
  //     ans = Math.max(ans, len);
  //     map.put(a[i], len);
  //   }

  //   return ans;
  // }

  public static int longestConsecutive(int[] a) {
    Arrays.sort(a);

    int n = a.length, i = 0, prev = 0, len = 0, ans = 0;
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

  public static int longestConsecutive1(int[] a) {
    int n = a.length;
    if (n <= 0) return 0;

    Arrays.sort(a);
    int len = 1, prev = a[0], ans = 1;
    for (int i = 0; i < n; i++) {
      if (a[i] > prev + 1) {
        len = 1;
      } else if (a[i] == prev + 1) {
        len++;
      }
      ans = Math.max(ans, len);
      prev = a[i];
    }
    return ans;
  }

  public static void main(String[] args) {
    // int[] a = {100, 4, 200, 1, 3, 2};
    // int[] a = {1};
    int[] a = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    System.out.println(longestConsecutive1(a));
    System.out.println(longestConsecutive(a));
  }
}
