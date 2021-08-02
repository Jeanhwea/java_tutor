package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 不同的子序列
 *
 * @author Jinghui Hu
 * @since 2021-08-02, JDK1.8
 */
@SuppressWarnings("all")
public class Solution115 {

  public static int numDistinct(String s, String t) {
    int n = s.length(), m = t.length();
    if (m < n) return 0;
    // dp[i][j] 表示 s[i:] 的子序列在 t[j:] 出现的个数
    int[][] dp = new int[n + 1][m + 1];
  }

  public static void main(String[] args) {
    String s = "rabbbit", t = "rabbit";
    System.out.println(numDistinct(s, t));
  }
}
