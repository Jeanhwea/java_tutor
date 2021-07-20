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

  public static int minCut(String str) {
    char[] a = str.toCharArray();
    int n = a.length;

    // dp[i-1][j-1] 表示 str 第 i 个字符到第 j 个字符是否为回文串
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = true;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        dp[i][j] = a[i] == a[j];
        if (j - i > 1) {
          dp[i][j] &= dp[i + 1][j - 1];
        }
      }
    }

    // System.out.println(Arrays.deepToString(dp));

    int ans = 0;
    return ans;
  }

  public static void main(String[] args) {
    String str1 = "aab";
    System.out.println(minCut(str1));
  }
}
