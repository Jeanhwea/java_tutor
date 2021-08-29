package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * N 皇后
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution051 {

  private static char[][] board;
  private static int n;
  private static List<List<String>> ans;

  public static List<List<String>> solveNQueens(int num) {
    n = num;
    board = new char[n][n];
    ans = new LinkedList<>();
    for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
    dfs(0);
    return ans;
  }

  private static void dfs(int k) {
    if (k == n) {
      // System.out.println(Arrays.deepToString(board).replaceAll("],", "],\n"));
      List<String> solution = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
          sb.append(board[i][j]);
        }
        solution.add(sb.toString());
      }
      ans.add(solution);
      return;
    }
    for (int i = 0; i < n; i++) {
      if (!isValidPos(k, i)) continue;
      board[k][i] = 'Q';
      dfs(k + 1);
      board[k][i] = '.';
    }
  }

  private static boolean isValidPos(int x, int y) {
    for (int i = 0; i < x; i++) {
      if (board[i][y] == 'Q') return false;
      int x1 = x - i - 1, y1 = y - i - 1, x2 = x - i - 1, y2 = y + i + 1;
      if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && board[x1][y1] == 'Q') {
        return false;
      }
      if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && board[x2][y2] == 'Q') {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int n = 4;
    System.out.println(solveNQueens(n));
  }
}
