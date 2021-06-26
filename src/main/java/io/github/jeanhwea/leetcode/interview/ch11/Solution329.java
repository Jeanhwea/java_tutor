package io.github.jeanhwea.leetcode.interview.ch11;

import java.util.*;

/**
 * 矩阵中的最长递增路径
 *
 * @author Jinghui Hu
 * @since 2021-06-25, JDK1.8
 */
public class Solution329 {

  // 记忆化深度优先搜索
  public static int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int n = matrix.length, m = matrix[0].length;
    int[][] memo = new int[n][m];

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ans = Math.max(ans, dfs(matrix, i, j, memo));
      }
    }

    return ans;
  }

  public static int dfs(int[][] matrix, int x, int y, int[][] memo) {
    if (memo[x][y] != 0) return memo[x][y];
    memo[x][y] = 1;

    int n = matrix.length, m = matrix[0].length;

    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    for (int i = 0; i < 4; i++) {
      int x1 = x + dx[i], y1 = y + dy[i];
      if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
      if (matrix[x][y] < matrix[x1][y1]) {
        memo[x][y] = Math.max(memo[x][y], dfs(matrix, x1, y1, memo) + 1);
      }
    }

    return memo[x][y];
  }

  public static void main(String[] args) {
    int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    System.out.println(longestIncreasingPath(matrix));
  }
}
