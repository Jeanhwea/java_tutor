package io.github.jeanhwea.leetcode.interview.ch13;

import java.util.*;

/**
 * 分数到小数
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution166 {

  public static String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";

    StringBuilder sb = new StringBuilder();
    if (numerator > 0 ^ denominator > 0) sb.append("-");

    // 整数部分
    long n = Math.abs(Long.valueOf(numerator)), d = Math.abs(Long.valueOf(denominator));
    sb.append(String.valueOf(n / d));
    long r = n % d;
    if (r == 0) {
      return sb.toString();
    }

    // 小数部分
    sb.append(".");
    Map<Long, Integer> map = new HashMap<>();
    while (r != 0) {
      if (map.containsKey(r)) {
        sb.insert(map.get(r), "(");
        sb.append(")");
        break;
      }
      map.put(r, sb.length());
      r *= 10;
      sb.append(String.valueOf(r / d));
      r %= d;
    }
    // System.out.println(map);

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(fractionToDecimal(100, 19));
    System.out.println(fractionToDecimal(1, 3));
  }
}
