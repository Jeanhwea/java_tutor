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
    // dp[i] 记录 a[0..i-1] 的 LIS 长度
    int[] dp = new int[n + 1];
    // prev[i] 记录 a[i-1] 的前一个序列下标
    int[] prev = new int[n + 1];

    Arrays.fill(dp, 1);

    int maxIndex = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        if (a[i - 1] > a[j - 1] && dp[i] <= dp[j] + 1) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
        }
      }
      if (dp[i] > dp[maxIndex]) maxIndex = i;
    }

    List<Integer> ans = new LinkedList<>();
    int k = maxIndex;
    for (int i = 0; i < dp[maxIndex]; i++) {
      ans.add(0, a[k - 1]);
      k = prev[k];
    }
    return ans;
  }

  public static void main(String[] args) {
    // int[] a = {1, 2, 4, 6, 5};
    int[] a = {2, 1, 5, 3, 6, 4, 8, 9, 7};
    System.out.println(longestIncreasingSubsequence(a));
  }
}
