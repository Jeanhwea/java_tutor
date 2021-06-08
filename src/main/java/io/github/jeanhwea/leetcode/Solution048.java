package io.github.jeanhwea.leetcode;

import java.util.*;

/**
 * 旋转图像
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
public class Solution048 {

  public static void rotate0(int[][] a) {
    int n = a.length;
    int[][] b = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        b[i][j] = a[n - j - 1][i];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = b[i][j];
      }
    }
  }

  public static void rotate(int[][] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int t = a[j][i];
        a[j][i] = a[n - j - 1][i];
        a[n - j - 1][i] = t;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int t = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = t;
      }
    }
  }

  public static void main(String args[]) {
    int[][] a = {{1, 2}, {3, 4}};
    System.out.println(Arrays.deepToString(a).replace("], [", "],\n ["));
    System.out.println("========================================");
    rotate(a);
    System.out.println(Arrays.deepToString(a).replace("], [", "],\n ["));

    System.out.println("");
    int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(Arrays.deepToString(b).replace("], [", "],\n ["));
    System.out.println("========================================");
    rotate(b);
    System.out.println(Arrays.deepToString(b).replace("], [", "],\n ["));
  }
}
