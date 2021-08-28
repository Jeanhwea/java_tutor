package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 被围绕的区域
 *
 * @author Jinghui Hu
 * @since 2021-08-28, JDK1.8
 */
@SuppressWarnings("all")
public class Solution130 {

  public static void solve(char[][] board) {
    if (board.length <= 0 || board[0].length <= 0) return;
    n = board.length;
    m = board[0].length;
    a = board;

    // 从边界深搜, 将与边界连通的 X 改成 #
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        boolean isEdge = i == 0 || i == n - 1 || j == 0 || j == m - 1;
        if (isEdge) {
          dfs(i, j);
        }
      }
    }

    // 二次遍历, 将 O 改成 X, # 改成 O
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == '#') {
          a[i][j] = 'O';
        } else if (a[i][j] == 'O') {
          a[i][j] = 'X';
        }
      }
    }
  }

  private static int[] dx = {1, -1, 0, 0};
  private static int[] dy = {0, 0, 1, -1};
  private static int n, m;
  private static char[][] a;

  private static void dfs(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= m) return;
    if (a[x][y] != 'O') return;
    a[x][y] = '#';
    for (int i = 0; i < 4; i++) {
      dfs(x + dx[i], y + dy[i]);
    }
  }

  public static void main(String[] args) {
    char[][] board = {
      {'X', 'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X', 'X'},
      {'X', 'X', 'O', 'X', 'X'},
      {'X', 'O', 'X', 'X', 'X'}
    };
    solve(board);
  }
}
