package io.github.jeanhwea.leetcode.interview.ch11;

import java.util.*;

/**
 * 完全平方数
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
public class Solution279 {

  public static int numSquares(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        int count = dp[i - j * j] + 1;
        if (count < min) min = count;
      }
      dp[i] = min;
    }

    // System.out.println(Arrays.toString(dp));
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numSquares(12));
  }
}
