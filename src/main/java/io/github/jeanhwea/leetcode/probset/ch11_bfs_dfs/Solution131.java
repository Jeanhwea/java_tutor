package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 分割回文串
 *
 * @author Jinghui Hu
 * @since 2021-08-28, JDK1.8
 */
@SuppressWarnings("all")
public class Solution131 {

  // dp[i][j] 表示 s 是否为回文串
  private static boolean[][] dp;
  private static char[] s;
  private static int n;

  private static List<String> choose;
  private static List<List<String>> ans;

  public static List<List<String>> partition(String str) {
    s = str.toCharArray();
    n = str.length();

    // 动规计算出回文串
    dp = new boolean[n][n];
    for (int len = 1; len <= n; len++) {
      for (int i = 0; i <= n - len; i++) {
        int j = i + len - 1;
        if (len == 1) {
          dp[i][j] = true;
        } else if (len == 2) {
          dp[i][j] = s[i] == s[j];
        } else {
          dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1];
        }
      }
    }
    // System.out.println(Arrays.deepToString(dp));

    // dfs 搜索给出结论
    ans = new LinkedList<>();
    choose = new LinkedList<>();
    dfs(0);
    return ans;
  }

  private static void dfs(int k) {
    if (k == n) {
      ans.add(new ArrayList<>(choose));
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = k; i < n; i++) {
      sb.append(s[i]);
      if (dp[k][i]) {
        choose.add(sb.toString());
        dfs(i + 1);
        choose.remove(choose.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    String s = "aab";
    System.out.println(partition(s));
  }
}
