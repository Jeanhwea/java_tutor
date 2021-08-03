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

  ////////////////////////////////////////////////////////////////////////////////
  // 动规解法
  ////////////////////////////////////////////////////////////////////////////////
  public static int numDistinct(String s, String t) {
    int n = s.length(), m = t.length();
    // dp[i][j] 表示 s[0:i-1] 的前缀组成 t[0:j-1]前缀 最多个数
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) dp[i][0] = 1;
    for (int j = 1; j <= m; j++) {
      for (int i = 1; i <= n; i++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    // System.out.println(Arrays.deepToString(dp).replace("], [", "],\n ["));
    return dp[n][m];
  }

  ////////////////////////////////////////////////////////////////////////////////
  // DFS 解法
  ////////////////////////////////////////////////////////////////////////////////
  private static int ans;
  private static int n;
  private static StringBuffer sb;
  private static String s, t;

  public static int numDistinct0(String source, String target) {
    ans = 0;
    n = source.length();
    s = source;
    t = target;
    sb = new StringBuffer();
    dfs(0);
    return ans;
  }

  public static void dfs(int k) {
    if (k == n) {
      if (t.equals(sb.toString())) ans++;
      return;
    }

    dfs(k + 1);

    sb.append(s.charAt(k));
    dfs(k + 1);
    sb.deleteCharAt(sb.length() - 1);
  }

  public static void main(String[] args) {
    // String s = "babgbag", t = "bag";
    String s = "rabbbit", t = "rabbit";
    System.out.println(numDistinct(s, t));
  }
}
