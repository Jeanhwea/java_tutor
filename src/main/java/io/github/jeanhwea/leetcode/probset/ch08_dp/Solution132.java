package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 分割回文串 II
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution132 {

  // 两次动规求解
  public static int minCut(String str) {
    char[] a = str.toCharArray();
    int n = a.length;

    // dp[i-1][j-1] 表示 str 第 i 个字符到第 j 个字符是否为回文串
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) Arrays.fill(dp[i], true);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        dp[j][i] = (a[j] == a[i]) && dp[j + 1][i - 1];
      }
    }

    // System.out.println(Arrays.deepToString(dp).replaceAll("],", "],\n"));

    // f[i] 表示前缀 str[0..i] 的分割次数
    int[] f = new int[n];
    Arrays.fill(f, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      if (dp[0][i]) {
        f[i] = 0;
      } else {
        for (int j = 0; j < i; j++) {
          if (dp[j + 1][i]) {
            f[i] = Math.min(f[i], f[j] + 1);
          }
        }
      }
    }

    return f[n - 1];
  }

  public static void main(String[] args) {
    // String str1 = "abbab";
    // String str1 = "abcccb";
    String str1 = "cabababcbc";
    System.out.println(minCut(str1));
  }
}
