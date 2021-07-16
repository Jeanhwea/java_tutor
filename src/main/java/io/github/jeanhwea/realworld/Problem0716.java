package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 最长递增子序列
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0716 {

  public static List<Integer> longestIncreasingSubsequence(int[] a) {
    int n = a.length;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        if (a[i - 1] > a[j - 1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    System.out.println(dp[n]);
    return null;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 8, 6, 4};
    System.out.println(longestIncreasingSubsequence(a));
  }
}
