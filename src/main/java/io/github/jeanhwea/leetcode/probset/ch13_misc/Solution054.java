package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 螺旋矩阵
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution054 {

  public static List<Integer> spiralOrder(int[][] a) {
    List<Integer> ans = new LinkedList<>();
    if (a.length <= 0 || a[0].length <= 0) return ans;
    int n = a.length, m = a[0].length, count = n * m, i = 0, j = -1, k = 0;
    int[] di = new int[] {0, 1, 0, -1}, dj = new int[] {1, 0, -1, 0};
    boolean[][] seen = new boolean[n][m];
    while (count > 0) {
      i += di[k];
      j += dj[k];
      if (i < 0 || i >= n || j < 0 || j >= m || seen[i][j]) {
        i -= di[k];
        j -= dj[k];
        k = (k + 1) % 4;
        continue;
      }
      ans.add(a[i][j]);
      seen[i][j] = true;
      count--;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] a = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
    };
    // int[][] a = {{9}};
    System.out.println(spiralOrder(a));
  }
}
