package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 矩阵置零
 *
 * @author Jinghui Hu
 * @since 2021-07-08, JDK1.8
 */
@SuppressWarnings("all")
public class Solution073 {

  public static void setZeroes(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    boolean flagRow = false, flagCol = false;
    for (int i = 0; i < m; i++) {
      if (matrix[0][i] == 0) flagRow = true;
    }
    for (int j = 0; j < n; j++) {
      if (matrix[j][0] == 0) flagCol = true;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[j][i] == 0) {
          matrix[0][i] = matrix[j][0] = 0;
        }
      }
    }

    for (int i = 1; i < m; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < n; j++) matrix[j][i] = 0;
      }
    }
    for (int j = 1; j < n; j++) {
      if (matrix[j][0] == 0) {
        for (int i = 1; i < m; i++) matrix[j][i] = 0;
      }
    }

    if (flagRow) {
      for (int i = 0; i < m; i++) {
        matrix[0][i] = 0;
      }
    }
    if (flagCol) {
      for (int j = 0; j < n; j++) {
        matrix[j][0] = 0;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    setZeroes(matrix);
  }
}
