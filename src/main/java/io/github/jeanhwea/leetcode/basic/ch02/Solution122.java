package io.github.jeanhwea.leetcode.basic.ch02;

/**
 * 股票交易最大收益 II
 *
 * @author Jinghui Hu
 * @since 2021-06-07, JDK1.8
 */
public class Solution122 {

  public static int maxProfit0(int[] a) {
    int n = a.length, mi = 0, s = 0;
    for (int i = 0; i < n; i++) {
      int peek = (i < n - 1) ? a[i + 1] : -1;
      if (peek < a[i]) {
        s += a[i] - a[mi];
        mi = i + 1;
      }
    }
    return s;
  }

  public static int maxProfit1(int[] a) {
    int n = a.length, s = 0;
    for (int i = 0; i < n; i++) {
      if (i < n - 1 && a[i + 1] > a[i]) {
        s += a[i + 1] - a[i];
      }
    }
    return s;
  }

  public static int maxProfit(int[] a) {
    int n = a.length;
    // dp[i][0] 表示第 i 天没有股票的利润
    // dp[i][1] 表示第 i 天持有股票的利润
    int[][] dp = new int[n][2];

    dp[0][0] = 0;
    dp[0][1] = -a[0];

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + a[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - a[i]);
    }

    // for (int i = 0; i < n; i++) {
    //   System.out.println(Arrays.toString(dp[i]));
    // }

    return dp[n - 1][0];
  }

  public static void main(String args[]) {
    int[] a = {2, 5, 4, 6};
    System.out.println(maxProfit(a));
  }
}
