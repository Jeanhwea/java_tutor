package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 单词搜索
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution079 {

  public static boolean exist(char[][] board, String word) {
    if (board.length <= 0 || board[0].length <= 0) return false;
    a = board;
    n = board.length;
    m = board[0].length;
    seen = new boolean[n][m];
    w = word.toCharArray();
    len = w.length;
    ans = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dfs(i, j, 0);
        if (ans) return ans;
      }
    }
    return ans;
  }

  private static char[][] a;
  private static boolean[][] seen;
  private static int n, m;
  private static char[] w;
  private static int len;
  private static boolean ans;

  private static void dfs(int x, int y, int k) {
    if (k == len) {
      ans = true;
      return;
    }
    if (x < 0 || x >= n || y < 0 || y >= m || seen[x][y] || a[x][y] != w[k]) return;

    seen[x][y] = true;
    dfs(x + 1, y, k + 1);
    dfs(x - 1, y, k + 1);
    dfs(x, y + 1, k + 1);
    dfs(x, y - 1, k + 1);
    seen[x][y] = false;
  }

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word = "ABCCED";
    // String word = "ABCB";
    System.out.println(exist(board, word));
  }
}
