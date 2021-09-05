package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 串联所有单词的子串
 *
 * @author Jinghui Hu
 * @since 2021-09-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution030 {

  // 暴力搜索法
  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new LinkedList<>();
    int wc = words.length, wl = words[0].length();
    for (int i = 0; i < s.length(); i++) {
      List<String> wordList = new ArrayList<>();
      for (String w : words) wordList.add(w);
      int j = i + wc * wl;
      if (j > s.length()) break;
      for (int k = 0; k < wc; k++) {
        String part = s.substring(i + wl * k, i + wl * (k + 1));
        if (!wordList.contains(part)) break;
        wordList.remove(part);
      }
      if (wordList.isEmpty()) ans.add(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    // String s = "barfoofoobarthefoobarman";
    // String[] words = {"bar", "foo", "the"};
    String s = "barfoothefoobarman";
    String[] words = {"bar", "foo"};
    System.out.println(findSubstring(s, words));
  }
}
