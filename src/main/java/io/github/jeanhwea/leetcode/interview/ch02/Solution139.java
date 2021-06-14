package io.github.jeanhwea.leetcode.interview.ch02;

import java.util.*;

/**
 * 单词拆分
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class Solution139 {

  // 动态规划， dp[i] 表示字符串 s 的前 i 个字串能否单词拆分
  public static boolean workBreak(String s, List<String> wordDict) {
    int n = s.length();
    Set<String> dict = new HashSet<>(wordDict);

    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] == 1 && dict.contains(s.substring(j, i))) {
          dp[i] = 1;
        }
      }
    }

    return dp[n] == 1;
  }

  public static void main(String args[]) {
    String s = "abca";
    List<String> dict = Arrays.asList("ab", "bc");
    // System.out.println(workBreak(s, dict));
    System.out.println(workBreak("leetcode", Arrays.asList("leet", "code")));
  }
}
