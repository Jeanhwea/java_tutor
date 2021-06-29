package io.github.jeanhwea.leetcode.interview.ch12;

import java.util.*;

/**
 * 岛屿数量
 *
 * @author Jinghui Hu
 * @since 2021-06-22, JDK1.8
 */
@SuppressWarnings("all")
public class Solution200 {

  public static int numIslands(char[][] grid) {
    int n = grid.length, m = grid[0].length;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1') {
          ans++;
          grid[i][j] = '0';
          dfs(grid, i, j, n, m);
        }
      }
    }
    return ans;
  }

  public static void dfs(char[][] grid, int x, int y, int n, int m) {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    for (int i = 0; i < 4; i++) {
      int x1 = x + dx[i], y1 = y + dy[i];
      if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && grid[x1][y1] == '1') {
        grid[x1][y1] = '0';
        dfs(grid, x1, y1, n, m);
      }
    }
  }

  public static void main(String[] args) {
    char[][] grid = {
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '1', '1'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '0', '0'}
    };
    System.out.println(numIslands(grid));
  }
}
