package io.github.jeanhwea.leetcode.basic;

import java.util.*;

/**
 * 外观数组
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Solution038 {

  public static String countAndSay(int k) {
    if (k <= 1) return "1";
    String p = countAndSay(k - 1), s = "";
    int n = p.length(), count = 0;
    for (int i = 0; i < n; i++) {
      char ch = p.charAt(i);
      if (i == n - 1) {
        s += String.valueOf(count + 1) + ch;
      } else {
        char peek = p.charAt(i + 1);
        if (ch == peek) {
          count++;
        } else {
          s += String.valueOf(count + 1) + ch;
          ch = peek;
          count = 0;
        }
      }
    }
    return s;
  }

  public static void main(String args[]) {
    for (int i = 0; i < 10; i++) {
      System.out.println(countAndSay(i));
    }
  }
}
