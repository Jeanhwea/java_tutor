package io.github.jeanhwea.leetcode.interview.ch01;

import java.util.*;

/**
 * 搜索二维矩阵 II
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class Solution240 {

  // 从左下往右上搜索法
  public static boolean searchMatric(int[][] a, int target) {
    int n = a.length, m = a[0].length;

    int i = n - 1, j = 0;
    while (i >= 0 && j < m) {
      // System.out.printf("a[%d][%d]=%d\n", i, j, a[i][j]);
      if (a[i][j] == target) return true;
      else if (a[i][j] > target) i--;
      else j++;
    }

    return false;
  }

  // 暴力搜索
  public static boolean searchMatric0(int[][] a, int target) {
    int n = a.length, m = a[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == target) return true;
        else if (a[i][j] > target) break;
      }
    }

    return false;
  }

  public static void main(String args[]) {
    int[][] matrix = {
      {1, 4, 7, 11, 15},
      {2, 5, 8, 12, 19},
      {3, 6, 9, 16, 22},
      {10, 13, 14, 17, 24},
      {18, 21, 23, 26, 30}
    };
    int target = 12;
    System.out.println(searchMatric(matrix, target));
  }
}
