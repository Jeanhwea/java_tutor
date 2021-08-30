package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 解数独
 *
 * @author Jinghui Hu
 * @since 2021-08-30, JDK1.8
 */
@SuppressWarnings("all")
public class Solution037 {

  public static void solveSudoku(char[][] board) {
    n = board.length;
    choose = board;
    seen = new boolean[n][n];
    ans = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        seen[i][j] = '.' == board[i][j];
      }
    }
    dfs(0, 0);
  }

  private static boolean[][] seen;
  private static char[][] choose;
  private static int n;
  private static boolean ans;

  private static void dfs(int x, int y) {
    if (x == n && y == n) {
      ans = true;
      System.out.println(Arrays.deepToString(choose));
      return;
    }
    // System.out.printf("x=%d, y=%d\n", x, y);

    if (x < 0 || x >= n || y < 0 || y >= n || !isValidSudoku(choose)) return;

    for (char ch = '1'; ch <= '9'; ch++) {
      if (seen[x][y]) {
        if (x < n - 1) {
          dfs(x + 1, y);
        } else {
          dfs(0, y + 1);
        }
      } else {
        choose[x][y] = ch;
        seen[x][y] = true;
        if (x < n - 1) {
          dfs(x + 1, y);
        } else {
          dfs(0, y + 1);
        }
        seen[x][y] = false;
        choose[x][y] = '.';
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static boolean isValidSudoku(char[][] board) {
    Map<Character, Integer>[] mp1 = new HashMap[9], mp2 = new HashMap[9], mp3 = new HashMap[9];
    for (int i = 0; i < 9; i++) {
      mp1[i] = new HashMap<>();
      mp2[i] = new HashMap<>();
      mp3[i] = new HashMap<>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char ch = board[i][j];
        if (ch == '.') continue;
        int k = (i / 3) * 3 + j / 3;

        mp1[i].put(ch, mp1[i].getOrDefault(ch, 0) + 1);
        mp2[j].put(ch, mp2[j].getOrDefault(ch, 0) + 1);
        mp3[k].put(ch, mp3[k].getOrDefault(ch, 0) + 1);

        if (mp1[i].get(ch) > 1 || mp2[j].get(ch) > 1 || mp3[k].get(ch) > 1) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    solveSudoku(board);
  }
}
