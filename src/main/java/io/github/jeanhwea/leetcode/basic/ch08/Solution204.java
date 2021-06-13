package io.github.jeanhwea.leetcode.basic.ch08;

import java.util.*;

/**
 * 计数质数
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution204 {

  public static int countPrimes(int n) {
    if (n <= 2) return 0;

    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);

    int p = 2;
    int count = 1;
    while (true) {
      int i = 2;
      while (p * i < n) {
        isPrime[p * i] = false;
        i++;
      }

      p++;
      while (p < n) {
        if (isPrime[p]) {
          count++;
          break;
        } else p++;
      }

      if (p >= n) break;
    }

    return count;
  }

  public static void main(String args[]) {
    System.out.println(countPrimes(2));
    System.out.println(countPrimes(10));
  }
}
