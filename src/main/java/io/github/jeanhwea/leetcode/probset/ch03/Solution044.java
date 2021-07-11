package io.github.jeanhwea.leetcode.probset.ch03;

import java.util.*;

/**
 * 通配符匹配
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution044 {

  // 动态规划
  public static boolean isMatch(String s, String p) {
    int n = s.length(), m = p.length();
    // dp[i][j] 表示 字串s[0..i-1] 和 字串p[0..j-1] 是否匹配
    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 1;
    for (int j = 1; j <= m; j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = 1;
      } else break;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] = (dp[i][j - 1] == 1 || dp[i - 1][j] == 1) ? 1 : 0;
        }
      }
    }

    return dp[n][m] == 1;
  }

  public static void main(String[] args) {
    System.out.println(isMatch("aa", "a*"));
  }
}
