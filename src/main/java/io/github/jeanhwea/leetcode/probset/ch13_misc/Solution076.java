package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 最小覆盖子串
 *
 * @author Jinghui Hu
 * @since 2021-09-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution076 {

  // 滑动窗口
  public static String minWindow(String s, String t) {
    int[] tCount = new int[128];
    // 记录字符串 t 中每个字符的数量
    for (char ch : t.toCharArray()) tCount[ch]++;
    int distST = t.length(); // 字符串 t 的数量
    int left = 0, right = 0;
    int winLen = Integer.MAX_VALUE; // 覆盖 t 的最小长度
    int leftBound = 0; // 覆盖字符串 t 开始的位置
    while (right < s.length()) {
      if (tCount[s.charAt(right++)]-- > 0) distST--;
      while (distST == 0) { // 如果全部覆盖
        if (right - left < winLen) {
          winLen = right - left;
          leftBound = left;
        }
        // 如果全部覆盖，尝试缩小左边界
        if (tCount[s.charAt(left++)]++ == 0) distST++;
      }
    }
    // 如果找到合适的窗口就截取，否则就返回空
    if (winLen != Integer.MAX_VALUE) {
      return s.substring(leftBound, leftBound + winLen);
    }
    return "";
  }

  public static void main(String[] args) {
    // String s = "ADOBECODEBANC", t = "ABC";
    // String s = "a", t = "a";
    // String s = "aa", t = "aa";
    String s = "bba", t = "ab";
    System.out.println(minWindow(s, t));
  }
}
