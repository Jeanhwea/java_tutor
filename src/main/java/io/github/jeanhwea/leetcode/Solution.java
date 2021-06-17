package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

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

  public static void kmpSearch(String s, String t) {
    int[] next = getNext(t);
    int n = s.length(), m = t.length(), i = 0, j = 0;

    System.out.println(Arrays.toString(next));
    while (i < n) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else if (j > 0) {
        j = next[j];
      } else {
        i++;
      }

      if (j >= m) {
        // System.out.printf("i=%d, found=%d\n", i, i - m);
        i++;
        j = 0;
      }
    }
  }

  public static void main(String[] args) {
    String s = "aabacaabcaab";
    String t = "aab";
    kmpSearch(s, t);
  }
}
