package io.github.jeanhwea.leetcode.probset.ch03;

import java.util.*;

/**
 * 外观数列
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution038 {

  public static String countAndSay(int n) {
    if (n == 1) return "1";
    String s = countAndSay(n - 1);
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      count++;
      if ((i < s.length() - 1 && ch != s.charAt(i + 1)) || i == s.length() - 1) {
        sb.append(count);
        sb.append(ch);
        count = 0;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(countAndSay(1));
    System.out.println(countAndSay(2));
    System.out.println(countAndSay(3));
    System.out.println(countAndSay(4));
  }
}
