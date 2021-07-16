package io.github.jeanhwea.leetcode.probset.ch03_string;

import java.util.*;

/**
 * 罗马数字转整数
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution013 {

  private static Map<String, Integer> map =
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

  public static int romanToInt(String s) {
    int ans = 0, i = 0, n = s.length();
    while (i < n) {
      String token =
          i < n - 1 && map.containsKey(s.substring(i, i + 2))
              ? token = s.substring(i, i + 2)
              : s.substring(i, i + 1);
      ans += map.getOrDefault(token, 0);
      i += token.length();
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("IV"));
  }
}
