package io.github.jeanhwea.leetcode.probset.ch12_dnc;

import java.util.*;

/**
 * Pow(x, n)
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution050 {

  public static double myPow(double x, int n) {
    long N = n;
    return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
  }

  public static double quickMul(double x, long n) {
    double ans = 1.0;
    double y = x;
    while (n > 0) {
      if (n % 2 == 1) ans *= y;
      y *= y;
      n /= 2;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(myPow(2.0, -2147483648));
  }
}
