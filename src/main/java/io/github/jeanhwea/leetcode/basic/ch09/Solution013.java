package io.github.jeanhwea.leetcode.basic.ch09;

import java.util.*;

/**
 * 罗马数字转整数
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution013 {

  public static int romanToInt(String s) {
    Map<String, Integer> tb =
        new HashMap<String, Integer>() {
          {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
          }
        };
    int sum = 0, n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i), peek = i < n - 1 ? s.charAt(i + 1) : ' ';
      String token = String.valueOf(ch);
      if (ch == 'I' && (peek == 'V' || peek == 'X')) {
        token += peek;
        i++;
      }
      if (ch == 'X' && (peek == 'L' || peek == 'C')) {
        token += peek;
        i++;
      }
      if (ch == 'C' && (peek == 'D' || peek == 'M')) {
        token += peek;
        i++;
      }
      sum += tb.getOrDefault(token, 0);
    }

    return sum;
  }

  public static void main(String args[]) {
    String rn = "MCMXCIV";
    System.out.println(rn);
    System.out.println(romanToInt(rn));
  }
}
