package io.github.jeanhwea.leetcode.interview.ch01;

import java.util.*;

/**
 * 搜索二维矩阵 II
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class Solution240 {

  // 二分搜索
  public static boolean searchMatric(int[][] a, int target) {
    int n = a.length, m = a[0].length;

    int i = 0, j = n;
    while (i <= j) {
      int mid1 = i + (j - i) / 2;

      int p = 0, q = m;
      while (p < q) {
        int mid2 = p + (q - p) / 2;
        if (a[mid1][mid2] == target) return true;
        else if (a[mid1][mid2] > target) q = mid2;
        else q = mid2 + 1;
      }

      if (a[mid1][p] == target) return true;
      else if (a[mid1][p] > target) j = mid1 - 1;
      else i = mid1 + 1;
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
    int target = 5;
    System.out.println(searchMatric(matrix, target));
  }
}
