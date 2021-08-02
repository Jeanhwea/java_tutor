package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 交错字符串
 *
 * @author Jinghui Hu
 * @since 2021-08-02, JDK1.8
 */
@SuppressWarnings("all")
public class Solution097 {

  public static boolean isInterleave(String s1, String s2, String s3) {
    int n = s1.length(), m = s2.length(), t = s3.length();
    if (n + m != t) return false;

    // dp[s1第i个字符][s2第j个字符]: s1的前缀 和 s2的前缀 可以交错组成 s3的前缀
    boolean[][] dp = new boolean[n + 1][m + 1];
    dp[0][0] = true;

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        int k = i + j;
        if (i > 0) {
          dp[i][j] |= dp[i - 1][j] && s3.charAt(k - 1) == s1.charAt(i - 1);
        }
        if (j > 0) {
          dp[i][j] |= dp[i][j - 1] && s3.charAt(k - 1) == s2.charAt(j - 1);
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
    System.out.println(isInterleave(s1, s2, s3));
  }
}
