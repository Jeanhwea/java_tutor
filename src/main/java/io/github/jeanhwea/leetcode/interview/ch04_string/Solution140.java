package io.github.jeanhwea.leetcode.interview.ch04_string;

import java.util.*;

/**
 * 单词拆分 II
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution140 {

  public static List<String> wordBreak(String s, List<String> wordDict) {
    Map<Integer, List<List<String>>> map = new HashMap<>();
    List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
    List<String> breakList = new LinkedList<>();
    for (List<String> wordBreak : wordBreaks) {
      breakList.add(String.join(" ", wordBreak));
    }
    return breakList;
  }

  public static List<List<String>> backtrack(
      String s, int n, Set<String> dict, int k, Map<Integer, List<List<String>>> map) {
    if (!map.containsKey(k)) {
      List<List<String>> wordBreaks = new LinkedList<>();
      if (k == n) {
        wordBreaks.add(new LinkedList<>());
      }
      for (int i = k + 1; i <= n; i++) {
        String word = s.substring(k, i);
        if (dict.contains(word)) {
          List<List<String>> nextWordBreaks = backtrack(s, n, dict, i, map);
          for (List<String> nextWordBreak : nextWordBreaks) {
            LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
            wordBreak.offerFirst(word);
            wordBreaks.add(wordBreak);
          }
        }
      }
      map.put(k, wordBreaks);
    }
    return map.get(k);
  }

  public static void main(String[] args) {
    String s = "abcabcaabaxasdf";
    List<String> dict = Arrays.asList("a", "ab", "bc");
    List<String> sentences = wordBreak(s, dict);
    System.out.println(sentences);
  }
}
