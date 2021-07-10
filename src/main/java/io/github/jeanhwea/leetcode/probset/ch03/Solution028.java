package io.github.jeanhwea.leetcode.probset.ch03;

import java.util.*;

/**
 * 实现 strStr
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution028 {

  public static int[] getNext(String p) {
    int n = p.length();
    int[] next = new int[n];
    int i = 2, len = 0;
    while (i < n) {
      if (p.charAt(i - 1) == p.charAt(len)) {
        next[i++] = ++len;
      } else if (len > 0) {
        len = next[len];
      } else {
        i++;
      }
    }
    // System.out.println(Arrays.toString(next));
    return next;
  }

  public static int strStr(String s, String p) {
    int n = s.length(), m = p.length();
    if (m <= 0) return 0;
    int[] next = getNext(p);
    int i = 0, j = 0;
    while (i < n) {
      if (s.charAt(i) == p.charAt(j)) {
        i++;
        j++;
      } else if (j > 0) {
        j = next[j];
      } else {
        i++;
      }
      if (j == m) return i - m;
    }
    return -1;
  }

  public static void main(String[] args) {
    // String s = "cababcbabca", p = "ababcx";
    String s = "mississippi", p = "issip";
    // String s = "aaa", p = "aaa";
    System.out.println(strStr(s, p));
  }
}
