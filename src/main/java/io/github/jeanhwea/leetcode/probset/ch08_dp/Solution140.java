package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 单词拆分 II
 *
 * @author Jinghui Hu
 * @since 2021-08-04, JDK1.8
 */
@SuppressWarnings("all")
public class Solution140 {

  public static List<String> wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        if (wordDict.contains(s.substring(1, i + 1))) {
          dp[i] += dp[j];
        }
      }
    }
  }

  public static void main(String[] args) {
    // pass
  }
}
