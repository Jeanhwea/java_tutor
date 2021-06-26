package io.github.jeanhwea.leetcode.interview.ch13;

import java.util.*;

/**
 * 直线上最多的点数
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution149 {

  // 暴露解法
  public static int maxPoints(int[][] points) {
    int n = points.length, ans = 1;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int count = 2;
        for (int k = 0; k < n; k++) {
          if (k != i && k != j && check(points[i], points[j], points[k])) {
            count++;
          }
        }
        ans = Math.max(ans, count);
      }
    }
    return ans;
  }

  public static boolean check(int[] x, int[] y, int[] z) {
    return ((x[0] - y[0]) * (x[1] - z[1])) == ((x[0] - z[0]) * (x[1] - y[1]));
  }

  public static void main(String[] args) {
    // int[][] points = {{1, 1}, {2, 2}, {3, 3}};
    int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    System.out.println(maxPoints(points));
  }
}
