package io.github.jeanhwea.leetcode.basic.ch03;

/**
 * 整数反转
 *
 * @author Jinghui Hu
 * @since 2021-06-07, JDK1.8
 */
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
    System.out.println(reverse(1239999991));
    System.out.println(reverse(1239999992));
  }
}
