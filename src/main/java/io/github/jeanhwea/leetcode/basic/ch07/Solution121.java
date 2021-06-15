package io.github.jeanhwea.leetcode.basic.ch07;

/**
 * 买卖股票的最佳时机
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution121 {

  public static int maxProfie(int[] a) {
    int n = a.length;
    int[] dp = new int[n];
    int mp = a[0];
    dp[0] = 0;
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1], a[i] - mp);
      mp = Math.min(mp, a[i]);
    }

    return dp[n - 1];
  }

  public static void main(String args[]) {
    int[] a = new int[] {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfie(a));
  }
}
