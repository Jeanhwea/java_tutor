package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 三角形最小路径和
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution120 {

  public static int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();

    // dp[i][j] 表示第 i 层的第 j 个元素选取时的最小路径和
    int[][] dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        int currVal = triangle.get(i - 1).get(j - 1);
        if (j == 1) {
          dp[i][j] = dp[i - 1][j] + currVal;
        } else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + currVal;
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + currVal;
        }
      }
    }

    // System.out.println(Arrays.deepToString(dp));

    int ans = Integer.MAX_VALUE;
    for (int j = 1; j <= n; j++) {
      ans = Math.min(ans, dp[n][j]);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

    List<List<Integer>> triangle1 = new LinkedList<>();
    for (int i = 0; i < triangle.length; i++) {
      List<Integer> element = new LinkedList<>();
      for (int j = 0; j < triangle[i].length; j++) {
        element.add(triangle[i][j]);
      }
      triangle1.add(element);
    }

    System.out.println(minimumTotal(triangle1));
  }
}
