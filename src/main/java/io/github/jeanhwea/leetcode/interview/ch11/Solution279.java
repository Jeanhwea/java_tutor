package io.github.jeanhwea.leetcode.interview.ch11;

import java.util.*;

/**
 * 完全平方数
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
public class Solution279 {

  public static int numSquares(int n) {
    List<Integer> square = new LinkedList<>();
    int k = 1;
    while (k * k <= n) {
      square.add(k * k);
      k++;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < square.size(); j++) {
        int s = square.get(j);
        if (s > i) break;
        int count = dp[i - s] + 1;
        if (count < min) min = count;
      }
      dp[i] = min;
    }

    // System.out.println(Arrays.toString(dp));
    return dp[n];
  }

  public static void main(String[] args) {
    numSquares(12);
  }
}
