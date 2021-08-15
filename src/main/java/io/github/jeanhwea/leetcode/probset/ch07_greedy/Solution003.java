package io.github.jeanhwea.leetcode.probset.ch07_greedy;

import java.util.*;

/**
 * 无重复字符的最长子串
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution003 {

  // 滑动窗口解法
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0, beg = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) { // 去掉重复字符及之前的字符
        int k = map.get(ch);
        for (int j = beg; j <= k; j++) {
          map.remove(s.charAt(j));
        }
        beg = k + 1;
      }
      map.put(ch, i);
      ans = Math.max(ans, i - beg + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "pwwkew";
    // String s = "bbbbb";
    System.out.println(lengthOfLongestSubstring(s));
  }
}
