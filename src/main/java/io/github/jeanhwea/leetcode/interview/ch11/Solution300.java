package io.github.jeanhwea.leetcode.interview.ch11;

import java.util.*;

/**
 * 最长递增子序列
 *
 * @author Jinghui Hu
 * @since 2021-06-25, JDK1.8
 */
public class Solution300 {

  public static int lengthOfLIS(int[] a) {
    int ans = 1, n = a.length;
    int[] dp = new int[n];

    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      int max1 = 1;
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) {
          max1 = Math.max(max1, dp[j] + 1);
        }
      }
      dp[i] = max1;
      ans = Math.max(ans, max1);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(lengthOfLIS(a));
  }
}
