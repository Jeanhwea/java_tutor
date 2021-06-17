package io.github.jeanhwea.leetcode.interview.ch05;

import java.util.*;

/**
 * 乘积最大子数组
 *
 * @author Jinghui Hu
 * @since 2021-06-15, JDK1.8
 */
public class Solution152 {

  // 暴露搜索
  public static int maxProduct0(int[] a) {
    int n = a.length, ans = a[0];
    for (int i = 0; i < n; i++) {
      int val = 1;
      for (int j = i; j < n; j++) {
        val *= a[j];
        if (val > ans) ans = val;
      }
    }
    return ans;
  }

  // 动态规划
  public static int maxProduct(int[] a) {
    int n = a.length;
    int[][] dp = new int[n][2];
    dp[0][0] = dp[0][1] = a[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(Math.max(a[i], dp[i - 1][0] * a[i]), dp[i - 1][1] * a[i]);
      dp[i][1] = Math.min(Math.min(a[i], dp[i - 1][0] * a[i]), dp[i - 1][1] * a[i]);
    }

    // System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));

    int max = dp[0][0];
    for (int i = 0; i < n; i++) {
      if (dp[i][0] > max) max = dp[i][0];
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {4, -9, -1, 2, 3, -1, 4};
    // int[] nums = {0, 2};
    System.out.println(Arrays.toString(nums));
    System.out.println("========================================");
    System.out.println(maxProduct0(nums));
    System.out.println(maxProduct(nums));
  }
}
