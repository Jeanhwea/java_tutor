package io.github.jeanhwea.leetcode.basic.ch02;

import java.util.*;

/**
 * 有效的数独
 *
 * @author Jinghui Hu
 * @since 2021-06-08, JDK1.8
 */
@SuppressWarnings("all")
public class Solution036 {

  public static boolean isValidSudoku0(char[][] a) {
    Set<Character> st = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if ('.' == a[i][j]) continue;
        if (st.contains(a[i][j])) {
          return false;
        } else {
          st.add(a[i][j]);
        }
      }
      st.clear();
    }

    for (int j = 0; j < 9; j++) {
      for (int i = 0; i < 9; i++) {
        if ('.' == a[i][j]) continue;
        if (st.contains(a[i][j])) {
          return false;
        } else {
          st.add(a[i][j]);
        }
      }
      st.clear();
    }

    for (int s = 0; s < 3; s++) {
      for (int t = 0; t < 3; t++) {
        for (int i = 3 * s; i < 3 * (s + 1); i++) {
          for (int j = 3 * t; j < 3 * (t + 1); j++) {
            if ('.' == a[i][j]) continue;
            if (st.contains(a[i][j])) {
              return false;
            } else {
              st.add(a[i][j]);
            }
          }
        }
        st.clear();
      }
    }

    return true;
  }

  @SuppressWarnings("unchecked")
  public static boolean isValidSudoku(char[][] a) {
    Map<Character, Integer>[] mp1 = new HashMap[9], mp2 = new HashMap[9], mp3 = new HashMap[9];
    for (int i = 0; i < 9; i++) {
      mp1[i] = new HashMap<>();
      mp2[i] = new HashMap<>();
      mp3[i] = new HashMap<>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c = a[i][j];
        if (c == '.') continue;
        int k = (i / 3) * 3 + j / 3;

        mp1[i].put(c, mp1[i].getOrDefault(c, 0) + 1);
        mp2[j].put(c, mp2[j].getOrDefault(c, 0) + 1);
        mp3[k].put(c, mp3[k].getOrDefault(c, 0) + 1);

        if (mp1[i].get(c) > 1 || mp2[j].get(c) > 1 || mp3[k].get(c) > 1) {
          return false;
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

    System.out.println("");

    char[][] b = {
      {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(Arrays.deepToString(b).replace("], ", "],\n "));
    System.out.println("========================================");
    System.out.println(isValidSudoku(b));
  }
}
