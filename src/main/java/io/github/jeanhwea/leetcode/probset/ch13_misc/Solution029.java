package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 两数相除
 *
 * @author Jinghui Hu
 * @since 2021-09-04, JDK1.8
 */
@SuppressWarnings("all")
public class Solution029 {

  // 按位计算，从最高位依次递减到低位来得到最终结果值
  public static int divide(int dividend, int divisor) {
    if (dividend == 0) return 0;
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    int sign = (dividend ^ divisor) >= 0 ? 1 : -1;
    long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
    int ans = 0;
    for (int i = 31; i >= 0; i--) {
      // System.out.printf("a=%d,b=%d\n", a, b);
      if ((a >> i) >= b) {
        ans += 1 << i;
        a -= (b << i);
      }
    }
    return sign > 0 ? ans : -ans;
  }

  public static void main(String[] args) {
    // System.out.println(divide(107, 3));
    System.out.println(divide(1, 1));
  }
}
