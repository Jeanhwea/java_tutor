package io.github.jeanhwea.leetcode.interview.ch02;

/**
 * 搜索二维矩阵 II
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution240 {

  // 从左下往右上搜索法
  public static boolean searchMatrix(int[][] a, int target) {
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
  public static boolean searchMatrix0(int[][] a, int target) {
    int n = a.length, m = a[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == target) return true;
        else if (a[i][j] > target) break;
      }
    }

    return false;
  }

  // 官方题解：对角线二分法查找
  private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
    int lo = start;
    int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;

    while (hi >= lo) {
      int mid = (lo + hi) / 2;
      if (vertical) { // searching a column
        if (matrix[start][mid] < target) {
          lo = mid + 1;
        } else if (matrix[start][mid] > target) {
          hi = mid - 1;
        } else {
          return true;
        }
      } else { // searching a row
        if (matrix[mid][start] < target) {
          lo = mid + 1;
        } else if (matrix[mid][start] > target) {
          hi = mid - 1;
        } else {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean searchMatrix1(int[][] matrix, int target) {
    // an empty matrix obviously does not contain `target`
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    // iterate over matrix diagonals
    int shorterDim = Math.min(matrix.length, matrix[0].length);
    for (int i = 0; i < shorterDim; i++) {
      boolean verticalFound = binarySearch(matrix, target, i, true);
      boolean horizontalFound = binarySearch(matrix, target, i, false);
      if (verticalFound || horizontalFound) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 4, 7, 11, 15},
      {2, 5, 8, 12, 19},
      {3, 6, 9, 16, 22},
      {10, 13, 14, 17, 24},
      {18, 21, 23, 26, 30}
    };
    int target = 12;
    System.out.println(searchMatrix1(matrix, target));
  }
}
