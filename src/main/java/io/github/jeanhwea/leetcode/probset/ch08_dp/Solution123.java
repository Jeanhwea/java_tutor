package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 买卖股票的最佳时机 III
 *
 * @author Jinghui Hu
 * @since 2021-07-31, JDK1.8
 */
@SuppressWarnings("all")
public class Solution123 {

  public static int maxProfit(int[] a) {
    int n = a.length;
    // dp[天数][当前是否持股][卖出的次数]
    int[][][] dp = new int[n][2][3];
    dp[0][1][0] = -a[0];
    dp[0][1][1] = dp[0][1][2] = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      dp[i][0][0] = 0;
      dp[i][0][1] = Math.max(dp[i - 1][1][0] + a[i], dp[i - 1][0][1]);
      dp[i][0][2] = Math.max(dp[i - 1][1][1] + a[i], dp[i - 1][0][2]);
      dp[i][1][0] = Math.max(dp[i - 1][0][0] - a[i], dp[i - 1][1][0]);
      dp[i][1][1] = Math.max(dp[i - 1][0][1] - a[i], dp[i - 1][1][1]);
      dp[i][1][2] = Integer.MIN_VALUE;
    }
    // System.out.println(Arrays.deepToString(dp));
    return Math.max(dp[n - 1][0][1], dp[n - 1][0][2]);
  }

  public static void main(String[] args) {
    // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
    int[] prices = {1, 2, 3, 4, 5};
    System.out.println(maxProfit(prices));
  }
}
