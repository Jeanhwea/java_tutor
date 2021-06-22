package io.github.jeanhwea.leetcode.misc;

import java.util.*;

/**
 * 岛屿的最大面积
 *
 * @author Jinghui Hu
 * @since 2021-06-22, JDK1.8
 */
public class Solution695 {

  public static int maxAreaOfIsland(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          grid[i][j] = 0;
          int ans1 = dfs(grid, i, j, 1);
          ans = Math.max(ans, ans1);
        }
      }
    }
    return ans;
  }

  public static int dfs(int[][] grid, int x, int y, int ret) {
    int n = grid.length, m = grid[0].length;
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    for (int i = 0; i < 4; i++) {
      int x0 = x + dx[i], y0 = y + dy[i];
      if (x0 < 0 || x0 >= n || y0 < 0 || y0 >= m) continue;

      if (grid[x0][y0] == 1) {
        grid[x0][y0] = 0;
        ret = dfs(grid, x0, y0, ret + 1);
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    int[][] grid = {
      {0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    System.out.println(maxAreaOfIsland(grid));
  }
}
