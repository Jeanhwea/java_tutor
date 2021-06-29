package io.github.jeanhwea.leetcode.basic.ch07;

/**
 * 最大子序和
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution053 {

  public static int maxSubArray(int[] a) {
    int n = a.length;
    int[] dp = new int[n + 1];
    dp[1] = a[0];

    int ans = a[0];
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1] + a[i - 1], a[i - 1]);
      ans = Math.max(dp[i], ans);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int res = maxSubArray(a);
    System.out.println(res);
  }
}
