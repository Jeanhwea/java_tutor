package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 不同路径 II
 *
 * @author Jinghui Hu
 * @since 2021-08-28, JDK1.8
 */
@SuppressWarnings("all")
public class Solution063 {

  // 原始动规
  public static int uniquePathsWithObstacles0(int[][] obstacleGrid) {
    if (obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) return 0;
    int n = obstacleGrid.length, m = obstacleGrid[0].length;
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (obstacleGrid[i][j] == 1) continue;
        if (i == 0 && j == 0) {
          dp[i][j] = 1;
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1];
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[n - 1][m - 1];
  }

  // 滚动数组优化存储空间
  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) return 0;
    int n = obstacleGrid.length, m = obstacleGrid[0].length;
    int[] dp = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[j] = 0;
          continue;
        }
        if (i == 0 && j == 0) {
          dp[j] = 1;
        } else if (i == 0) {
          dp[j] = dp[j - 1];
        } else if (j == 0) {
          dp[j] = dp[j];
        } else {
          dp[j] = dp[j - 1] + dp[j];
        }
      }
      // System.out.println(Arrays.toString(dp));
    }
    return dp[m - 1];
  }

  public static void main(String[] args) {
    // int[][] obstacleGrid = {
    //   {0, 0, 0},
    //   {0, 1, 0},
    //   {0, 0, 0}
    // };
    int[][] obstacleGrid = {{1}, {0}};
    System.out.println(uniquePathsWithObstacles(obstacleGrid));
  }
}
