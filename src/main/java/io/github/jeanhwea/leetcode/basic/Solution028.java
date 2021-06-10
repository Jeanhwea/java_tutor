package io.github.jeanhwea.leetcode.basic;

import java.util.*;

/**
 * 实现 strStr()
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
public class Solution028 {

  public static int strStr0(String s, String t) {
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

  public static int[] calcNext(String p) {
    int n = p.length();
    int[] next = new int[n];

    next[0] = -1;
    for (int i = 1; i < n - 1; i++) {
      for (int j = i - 1; j > 0; j--) {
        String s1 = p.substring(0, j), s2 = p.substring(i - j, i);
        if (s1.equals(s2)) {
          next[i] = j;
          break;
        }
      }
    }

    return next;
  }

  public static int strStr(String s, String t) {
    if ("".equals(t)) return 0;

    int[] next = calcNext(t);
    int n = s.length(), m = t.length(), i = 0, j = 0;
    // System.out.println(Arrays.toString(next));

    while (i <= n && j <= m) {
      if (j == m) return i - m;
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else if (next[j] >= 0) {
        j = next[j];
      } else {
        i++;
        j = 0;
      }
    }

    return -1;
  }

  public static void main(String args[]) {
    // System.out.println(strStr("aabc", ""));
    // System.out.println(strStr("aabc", "ab"));
    System.out.println(strStr("aabc", "c"));
    System.out.println(strStr("aabc", "a"));

    String s = "abababacb";
    String t = "ababacb";

    // System.out.println(strStr0(s, t));
    System.out.println(strStr(s, t));

    // int[] next = calcNext(s);
    // System.out.println(Arrays.toString(next));

  }
}
