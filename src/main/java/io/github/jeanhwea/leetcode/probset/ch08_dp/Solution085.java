package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 最大矩形
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution085 {

  public static int maximalRectangle(char[][] matrix) {
    // n*m matrix
    int n = matrix.length;
    if (n == 0) return 0;
    int m = matrix[0].length;
    int[][] left = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '1') {
          left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
        }
      }
    }
    // System.out.println(Arrays.deepToString(left).replaceAll("],", "],\n"));

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '0') continue;
        int width = left[i][j];
        int area = width;
        for (int k = i - 1; k >= 0; k--) {
          width = Math.min(width, left[k][j]);
          area = Math.max(area, (i - k + 1) * width);
        }
        ans = Math.max(ans, area);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    char[][] matrix = {
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}
    };
    System.out.println(maximalRectangle(matrix));
  }
}
