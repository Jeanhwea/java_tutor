package io.github.jeanhwea.leetcode.probset.ch07_greedy;

/**
 * 买卖股票的最佳时机
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution121 {

  public static int maxProfit(int[] a) {
    int n = a.length, ans = 0, buy = 0;

    buy = a[0];
    for (int i = 1; i < n; i++) {
      if (a[i] < buy) buy = a[i];
      ans = Math.max(ans, a[i] - buy);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));
  }
}
