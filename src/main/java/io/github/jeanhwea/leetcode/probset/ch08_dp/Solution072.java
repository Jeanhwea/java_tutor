package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 编辑距离
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution072 {

  public static int minDistance(String word1, String word2) {
    int n = word1.length(), m = word2.length();

    // dp[i][j] 表示 word1[0...i-1] 和 word2[0...j-1] 的编辑距离
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) dp[i][0] = i;
    for (int i = 0; i <= m; i++) dp[0][i] = i;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int minValue = Math.min(dp[i][j - 1], dp[i - 1][j]);
          minValue = Math.min(minValue, dp[i - 1][j - 1]);
          dp[i][j] = 1 + minValue;
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    // String word1 = "horse", word2 = "ros";
    String word1 = "sea", word2 = "ate";
    System.out.println(minDistance(word1, word2));
  }
}
