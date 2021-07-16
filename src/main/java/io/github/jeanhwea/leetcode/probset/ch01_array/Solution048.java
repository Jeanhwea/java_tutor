package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 旋转图像
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution048 {

  public static void rotate(int[][] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int t = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = t;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int t = a[i][j];
        a[i][j] = a[i][n - j - 1];
        a[i][n - j - 1] = t;
      }
    }
  }

  public static void main(String[] args) {
    int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotate(a);
    System.out.println(Arrays.deepToString(a).replace("], [", "],\n ["));
  }
}
