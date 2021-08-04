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

  // 动态规划
  public static List<String> wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    // 记录第 i 个字符结尾的字串包含的分割句子
    Map<Integer, List<List<String>>> cache = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        String currWord = s.substring(j, i);
        if ((j == 0 || cache.containsKey(j)) && wordDict.contains(currWord)) {
          List<List<String>> prevList = cache.getOrDefault(j, Collections.emptyList());
          List<List<String>> currList = cache.getOrDefault(i, new LinkedList<>());
          if (prevList.isEmpty()) {
            List<String> newList = new LinkedList<String>();
            newList.add(currWord);
            currList.add(newList);
          } else {
            for (List<String> list : prevList) {
              List<String> newList = new LinkedList<String>(list);
              newList.add(currWord);
              currList.add(newList);
            }
          }
          cache.putIfAbsent(i, currList);
        }
      }
    }

    // System.out.println(cache);
    List<String> ans = new LinkedList<>();
    for (List<String> strings : cache.getOrDefault(n, new LinkedList<>())) {
      ans.add(String.join(" ", strings));
    }

    return ans;
  }

  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
    System.out.println(wordBreak(s, wordDict));
  }
}
