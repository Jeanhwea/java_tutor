package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 最小路径和
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution064 {

  public static int minPathSum(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;
    int n = grid.length, m = grid[0].length;
    // dp[i][j] 表示当前落在 grid[i][j] 时所需要的最小路径和
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i <= 0) {
          if (j <= 0) {
            dp[i][j] = grid[i][j];
          } else {
            dp[i][j] = dp[i][j - 1] + grid[i][j];
          }
        } else {
          if (j <= 0) {
            dp[i][j] = dp[i - 1][j] + grid[i][j];
          } else {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
          }
        }
      }
    }
    return dp[n - 1][m - 1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minPathSum(grid));
  }
}
