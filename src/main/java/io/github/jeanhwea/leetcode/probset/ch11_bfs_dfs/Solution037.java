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
    dfs(board);
  }

  // 回溯法搜索解
  private static boolean dfs(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (int k = 0; k < 9; k++) {
            board[i][j] = (char) ('1' + k);
            if (isValid(board, i, j) && dfs(board)) return true;
            board[i][j] = '.';
          }
          return false;
        }
      }
    }
    return true;
  }

  // 检查位置 (x,y) 是否合法
  private static boolean isValid(char[][] board, int x, int y) {
    for (int i = 0; i < 9; i++) {
      if (i != x && board[i][y] == board[x][y]) return false;
    }
    for (int j = 0; j < 9; j++) {
      if (j != y && board[x][j] == board[x][y]) return false;
    }
    for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++) {
      for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++) {
        if ((i != x || j != y) && board[i][j] == board[x][y]) return false;
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
    System.out.println(Arrays.deepToString(board).replace("], [", "],\n ["));
  }
}
