package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 螺旋矩阵 II
 *
 * @author Jinghui Hu
 * @since 2021-09-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution059 {

  public static int[][] generateMatrix(int n) {
    int[][] ans = new int[n][n];
    int[] di = {0, 1, 0, -1}, dj = {1, 0, -1, 0};
    int i = 0, j = 0, k = 0, value = 1, count = n * n;
    while (value <= count) {
      ans[i][j] = value++;
      i += di[k];
      j += dj[k];
      if (i < 0 || i >= n || j < 0 || j >= n || ans[i][j] != 0) {
        i -= di[k];
        j -= dj[k];
        k = (k + 1) % 4;
        i += di[k];
        j += dj[k];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] ans = generateMatrix(3);
    System.out.println(Arrays.deepToString(ans));
  }
}
