package io.github.jeanhwea.leetcode.basic;

import java.util.*;

/**
 * 实现 strStr()
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
public class Solution028 {

  public static int strStr(String s, String t) {
    if (t.isEmpty()) return 0;

    int n = s.length(), m = t.length();
    for (int i = 0; i < n - m + 1; i++) {
      boolean found = true;
      for (int j = 0; j < m; j++) {
        if (s.charAt(i + j) != t.charAt(j)) {
          found = false;
          break;
        }
      }
      if (found) return i;
    }

    return -1;
  }

  public static void main(String args[]) {
    System.out.println(strStr("aabc", ""));
    System.out.println(strStr("aabc", "ab"));
    System.out.println(strStr("aabc", "c"));
    System.out.println(strStr("aabc", "a"));
  }
}
