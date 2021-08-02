package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 单词拆分
 *
 * @author Jinghui Hu
 * @since 2021-08-02, JDK1.8
 */
@SuppressWarnings("all")
public class Solution139 {

  public static boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    // dp[i]: 表示 s 的前 i 个字符可以拆分成字典中包含的单词
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    //
  }
}
