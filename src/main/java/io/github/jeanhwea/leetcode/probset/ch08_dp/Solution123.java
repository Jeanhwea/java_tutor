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
    // 记录第 i 天的状态
    //   buy1  第一次买入
    //   sell1 第一次卖出
    //   buy2  第二次买入
    //   sell2 第二次卖出
    int buy1 = -a[0], sell1 = 0, buy2 = -a[0], sell2 = 0;
    for (int i = 1; i < n; i++) {
      buy1 = Math.max(buy1, -a[i]);
      sell1 = Math.max(sell1, buy1 + a[i]);
      buy2 = Math.max(buy2, sell1 - a[i]);
      sell2 = Math.max(sell2, buy2 + a[i]);
    }
    return sell2;
  }

  public static int maxProfit0(int[] a) {
    int n = a.length;
    // dp[天数][当前是否持股][卖出的次数]
    int[][][] dp = new int[n + 1][2][3];
    dp[0][1][0] = dp[0][1][1] = dp[0][1][2] = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      dp[i][0][0] = 0;
      dp[i][0][1] = Math.max(dp[i - 1][1][0] + a[i - 1], dp[i - 1][0][1]);
      dp[i][0][2] = Math.max(dp[i - 1][1][1] + a[i - 1], dp[i - 1][0][2]);
      dp[i][1][0] = Math.max(dp[i - 1][0][0] - a[i - 1], dp[i - 1][1][0]);
      dp[i][1][1] = Math.max(dp[i - 1][0][1] - a[i - 1], dp[i - 1][1][1]);
      dp[i][1][2] = Integer.MIN_VALUE;
    }
    // System.out.println(Arrays.deepToString(dp));
    return Math.max(dp[n][0][1], dp[n][0][2]);
  }

  public static void main(String[] args) {
    int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
    // int[] prices = {1, 2, 3, 4, 5};
    System.out.println(maxProfit(prices));
  }
}
