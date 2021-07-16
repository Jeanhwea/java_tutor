package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 有效的数独
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution036 {

  public static boolean isValidSudoku(char[][] a) {
    int[][] seen = new int[3][9];

    for (int i = 0; i < 9; i++) {
      for (int k = 0; k < 3; k++) {
        Arrays.fill(seen[k], 0);
      }
      for (int j = 0; j < 9; j++) {
        int x = i % 3 * 3 + j % 3, y = i / 3 * 3 + j / 3;
        // System.out.printf("x,y=%d,%d\n", x, y);
        char[] ch = new char[] {a[j][i], a[i][j], a[x][y]};
        for (int k = 0; k < 3; k++) {
          if (ch[k] == '.') continue;
          if (seen[k][ch[k] - '1'] == 1) {
            return false;
          } else {
            seen[k][ch[k] - '1'] = 1;
          }
        }
      }
    }
    return true;
  }

  public static boolean isValidSudoku0(char[][] a) {
    Set<Character>[] sets = new HashSet[3];

    for (int i = 0; i < 9; i++) {
      for (int k = 0; k < 3; k++) {
        sets[k] = new HashSet<>();
      }
      for (int j = 0; j < 9; j++) {
        int x = i % 3 * 3 + j % 3, y = i / 3 * 3 + j / 3;
        // System.out.printf("x,y=%d,%d\n", x, y);
        char[] ch = new char[] {a[j][i], a[i][j], a[x][y]};
        for (int k = 0; k < 3; k++) {
          if (ch[k] != '.' && sets[k].contains(ch[k])) {
            return false;
          } else {
            sets[k].add(ch[k]);
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] a = {
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
    System.out.println(Arrays.deepToString(a).replace("], ", "],\n "));
    System.out.println("========================================");
    System.out.println(isValidSudoku(a));
  }
}
