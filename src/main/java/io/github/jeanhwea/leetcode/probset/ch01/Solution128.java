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

  // 使用一个集合去重并记录数据
  public static int longestConsecutive(int[] a) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) set.add(a[i]);

    int ans = 0;
    for (int e : set) {
      if (set.contains(e - 1)) continue;

      int len = 0;
      while (set.contains(e + len)) len++;
      ans = Math.max(ans, len);
    }

    return ans;
  }

  // 排序后查找
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
