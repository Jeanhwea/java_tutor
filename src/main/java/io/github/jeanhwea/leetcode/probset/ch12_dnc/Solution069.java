package io.github.jeanhwea.leetcode.probset.ch12_dnc;

import java.util.*;

/**
 * x 的平方根
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution069 {

  // 牛顿迭代法
  public static int mySqrt(int x) {
    if (x == 0) return 0;

    double C = x, x0 = x;
    while (true) {
      double x1 = 0.5 * (x0 + C / x0);
      if (Math.abs(x1 - x0) < 1e-7) break;
      x0 = x1;
    }
    return (int) x0;
  }

  public static void main(String[] args) {
    System.out.println(mySqrt(8888888));
  }
}
