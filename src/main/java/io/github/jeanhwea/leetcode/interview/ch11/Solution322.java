package io.github.jeanhwea.leetcode.interview.ch11;

import java.util.*;

/**
 * 零钱兑换
 *
 * @author Jinghui Hu
 * @since 2021-06-25, JDK1.8
 */
@SuppressWarnings("all")
public class Solution322 {

  public static int coinChange(int[] a, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < a.length; j++) {
        if (a[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
        }
      }
    }

    // System.out.println(Arrays.toString(dp));

    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    // int[] coins = {2};
    System.out.println(coinChange(coins, 11));
  }
}
