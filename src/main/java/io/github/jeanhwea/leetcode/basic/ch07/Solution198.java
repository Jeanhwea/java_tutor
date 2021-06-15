package io.github.jeanhwea.leetcode.basic.ch07;

import java.util.*;

/**
 * 打家劫舍
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution198 {

  public static int rob(int[] a) {
    int n = a.length;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = a[0];
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i - 1]);
    }
    return dp[n];
  }

  public static void main(String args[]) {
    int[] a = {2, 7, 9, 3, 1};
    System.out.println(Arrays.toString(a));
    System.out.println(rob(a));
  }
}
