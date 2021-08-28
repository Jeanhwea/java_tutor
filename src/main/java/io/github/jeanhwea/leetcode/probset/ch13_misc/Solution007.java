package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 整数反转
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution007 {

  public static int reverse(int n) {
    long s = 0, c = n > 0 ? n : -n;
    while (c > 0) {
      s = 10 * s + c % 10;
      if (s > Integer.MAX_VALUE) return 0;
      c = c / 10;
    }
    return (int) (n > 0 ? s : -s);
  }

  public static void main(String[] args) {
    System.out.println(reverse(1234));
  }
}
