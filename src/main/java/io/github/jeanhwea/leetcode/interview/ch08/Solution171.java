package io.github.jeanhwea.leetcode.interview.ch08;

import java.util.*;

/**
 * Excel表列序号
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
public class Solution171 {

  public static int titleToNumber(String s) {
    int n = s.length();
    int ans = 0, base = 'Z' - 'A';
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      ans += ans * base + (ch - 'A' + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "ZY";
    System.out.println(titleToNumber(s));
  }
}
