package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 直线上最多的点数
 *
 * @author Jinghui Hu
 * @since 2021-09-04, JDK1.8
 */
@SuppressWarnings("all")
public class Solution149 {

  public static int maxPoints(int[][] points) {
    int n = points.length;
    if (n <= 2) return n;

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int[] p1 = points[i];
      Map<Integer, Integer> slopeMap = new HashMap<>();
      for (int j = i + 1; j < n; j++) {
        int[] p2 = points[j];
        int[] slope = null;
        if (p1[0] == p2[0]) {
          slope = new int[] {1, 0};
        } else if (p1[1] == p2[1]) {
          slope = new int[] {0, 1};
        } else {
          int dy = p1[1] - p2[1], dx = p1[0] - p2[0];
          if (dy < 0) {
            dx = -dx;
            dy = -dy;
          }
          int d = gcd(Math.abs(dx), Math.abs(dy));
          if (d > 1) {
            dx /= d;
            dy /= d;
          }
          slope = new int[] {dy, dx};
        }
        // System.out.printf(
        //     "p1=(%d,%d),p2=(%d,%d): slope=(%d,%d)\n",
        //     p1[0], p1[1], p2[0], p2[1], slope[0], slope[1]);
        int key = slope[0] + 293121 * slope[1];
        slopeMap.put(key, slopeMap.getOrDefault(key, 0) + 1);
      }
      for (Integer value : slopeMap.values()) {
        ans = Math.max(ans, value + 1);
      }
    }

    return ans;
  }

  private static int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }

  public static void main(String[] args) {
    // int[][] points01 = new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    int[][] points01 = new int[][] {{9, -25}, {-4, 1}, {-1, 5}, {-7, 7}};
    System.out.println(maxPoints(points01));
  }
}
