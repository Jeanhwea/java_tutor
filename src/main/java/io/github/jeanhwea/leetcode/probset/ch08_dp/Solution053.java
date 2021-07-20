package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 最大子序和
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution053 {

  public static int maxSubArray(int[] a) {
    int n = a.length;
    int ans = a[0], sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum < 0 ? a[i] : a[i] + sum;
      ans = Math.max(ans, sum);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    // int[] nums = {-2};
    System.out.println(maxSubArray(nums));
  }
}
