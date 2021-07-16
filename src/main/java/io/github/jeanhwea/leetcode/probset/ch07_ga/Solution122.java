package io.github.jeanhwea.leetcode.probset.ch07_ga;

import java.util.*;

/**
 * 买卖股票的最佳时机 II
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution122 {

  public static int maxProfit(int[] a) {
    int n = a.length, ans = 0;
    for (int i = 1; i < n; i++) {
      if (a[i] > a[i - 1]) {
        ans += a[i] - a[i - 1];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));
  }
}
