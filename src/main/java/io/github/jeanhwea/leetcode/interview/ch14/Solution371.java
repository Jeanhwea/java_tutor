package io.github.jeanhwea.leetcode.interview.ch14;

import java.util.*;

/**
 * 两整数之和
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
@SuppressWarnings("all")
public class Solution371 {

  /**
   * 组成原理加法实现原理：低位 = a & b; 高位 = a ^ b
   *
   * @author Jinghui Hu
   * @since 2021-06-27, JDK1.8
   */
  public static int getSum(int a, int b) {
    int c; // carry
    do {
      c = (a & b) << 1;
      a = a ^ b;
      b = c;
    } while (c != 0);

    return a;
  }

  public static void main(String[] args) {
    System.out.println(getSum(1, 2));
    System.out.println(getSum(-1, 2));
  }
}
