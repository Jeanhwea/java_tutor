package io.github.jeanhwea.leetcode.basic.ch09;

/**
 * 3的幂
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution326 {

  public static boolean isPowerOfThree(int n) {
    if (n < 1) return false;
    while (n % 3 == 0) n /= 3;
    return n == 1;
  }

  public static void main(String[] args) {
    for (int i = -10; i < 30; i++) {
      System.out.printf("%d = %s\n", i, isPowerOfThree(i));
    }
  }
}
