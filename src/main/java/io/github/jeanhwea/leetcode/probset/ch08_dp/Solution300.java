package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 最长递增子序列
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution300 {

  public static int lengthOfLIS(int[] nums) {
    int n = nums.length;
    // dp[i] 表示 nums[0..i-1] 的 LIS
    int[] dp = new int[n + 1];
    int maxIndex = 0;
    Arrays.fill(dp, 1);

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        if (nums[i - 1] > nums[j - 1] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
        }
      }
      if (dp[i] > dp[maxIndex]) maxIndex = i;
    }

    return dp[maxIndex];
  }

  public static void main(String[] args) {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(lengthOfLIS(nums));
  }
}
