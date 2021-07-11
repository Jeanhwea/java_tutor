package io.github.jeanhwea.leetcode.probset.ch03;

import java.util.*;

/**
 * 正则表达式匹配
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution010 {

  public static boolean isMatch(String s, String p) {
    int n = s.length(), m = p.length();
    // dp[i][j] 表示字串 s[0..i-1] 和字串 p[0..j-1] 是否匹配
    boolean[][] dp = new boolean[n + 1][m + 1];

    // 准备初值
    dp[0][0] = true;
    for (int j = 1; j <= m; j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 2];
      }
    }

    // 状态转换
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (p.charAt(j - 1) == '*') {
          if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
          } else {
            dp[i][j] = dp[i][j - 2];
          }
        } else {
          if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            dp[i][j] = false;
          }
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    System.out.println(isMatch("aa", "a*"));
  }
}
