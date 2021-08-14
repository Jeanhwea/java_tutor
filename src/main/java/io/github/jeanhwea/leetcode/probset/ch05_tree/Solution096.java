package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 不同的二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-08-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution096 {

  public static int numTrees(int n) {
    // dp[i] 表示 n = i 时不同二叉树搜索树的种数
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        int k = i - j - 1;
        dp[i] += dp[j] * dp[k];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numTrees(5));
  }
}
