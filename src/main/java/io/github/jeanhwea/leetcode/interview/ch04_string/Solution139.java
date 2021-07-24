package io.github.jeanhwea.leetcode.interview.ch04_string;

import java.util.*;

/**
 * 单词拆分
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution139 {

  // 动态规划， dp[i] 表示字符串 s 的前 i 个字串能否单词拆分
  public static boolean wordBreak0(String s, List<String> wordDict) {
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

  // 回溯法
  public static boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);

    List<List<String>> sentences = new LinkedList<>();
    List<String> choose = new LinkedList<>();
    backtrack(s, 0, choose, sentences, dict);

    return !sentences.isEmpty();
  }

  public static void backtrack(
      String s, int k, List<String> choose, List<List<String>> sentences, Set<String> dict) {
    int n = s.length();
    if (k == n) {
      // System.out.println(choose);
      sentences.add(new ArrayList<String>(choose));
      return;
    }

    for (int i = k; i < n; i++) {
      String word = s.substring(k, i + 1);
      if (dict.contains(word)) {
        choose.add(s.substring(k, i + 1));
        backtrack(s, i + 1, choose, sentences, dict);
        choose.remove(choose.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    String s = "abca";
    List<String> dict = Arrays.asList("ab", "bc");
    // System.out.println(wordBreak(s, dict));
    System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
  }
}
