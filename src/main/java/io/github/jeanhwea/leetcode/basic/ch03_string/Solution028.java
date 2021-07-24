package io.github.jeanhwea.leetcode.basic.ch03_string;

import java.util.*;

/**
 * 实现 strStr()
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
@SuppressWarnings("all")
public class Solution028 {

  /**
   * 暴露搜索法
   *
   * @author Jinghui Hu
   * @since 2021-06-10, JDK1.8
   */
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

  /**
   * KMP 算法
   *
   * @author Jinghui Hu
   * @since 2021-06-10, JDK1.8
   */
  public static int strStr(String s, String t) {
    int[] next = getNext(t);
    int n = s.length(), m = t.length(), i = 0, j = 0;

    // System.out.println(Arrays.toString(next));
    while (i < n) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else if (j > 0) {
        j = next[j];
      } else {
        i++;
      }
    }

    if (j >= m) return i - j;
    return -1;
  }

  // 暴力使用前缀计算 next 数组
  public static int[] getNext0(String p) {
    int n = p.length();
    int[] next = new int[n];
    Arrays.fill(next, 0);

    // next[0] = 0;
    for (int i = 2; i < n; i++) {
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

  public static int[] getNext(String p) {
    int n = p.length();
    int[] next = new int[n];
    Arrays.fill(next, 0);

    int i = 2, j = 0;
    while (i < n) {
      if (p.charAt(i - 1) == p.charAt(j)) {
        next[i] = ++j;
        i++;
      } else if (j > 0) {
        j = next[j];
      } else {
        i++;
      }
    }

    return next;
  }

  public static void main(String[] args) {
    // System.out.println(strStr("aabc", ""));
    // System.out.println(strStr("aabc", "ab"));
    // System.out.println(strStr("aabc", "c"));
    // System.out.println(strStr("aabc", "a"));

    String s = "abababacb";
    String t = "ababacb";
    // String s = "aaaaa";
    // String t = "bba";

    // System.out.println(strStr0(s, t));
    // System.out.println(strStr(s, t));
    // System.out.println(strStr("cba", "a"));
    // System.out.println(strStr("a", "a"));

    // System.out.println(strStr0("aabaaabaaac", "aabaaac"));
    // System.out.println(strStr("aabaaabaaac", "aabaaac"));

    // String t1 = "abaabc";
    // String t1 = "abaabcaaaba";
    // String t1 = "aaa";
    String t1 = "aabaaac";
    System.out.println(Arrays.toString(getNext0(t1)));
    System.out.println(Arrays.toString(getNext(t1)));
  }
}
