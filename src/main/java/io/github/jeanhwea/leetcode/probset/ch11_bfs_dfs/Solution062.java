package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 不同路径
 *
 * @author Jinghui Hu
 * @since 2021-08-28, JDK1.8
 */
@SuppressWarnings("all")
public class Solution062 {

  public static int uniquePaths(int n, int m) {
    // dp[i][j] 表示走到棋盘 i 行 j 列的不同路径数量
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[n - 1][m - 1];
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 7));
  }
}
