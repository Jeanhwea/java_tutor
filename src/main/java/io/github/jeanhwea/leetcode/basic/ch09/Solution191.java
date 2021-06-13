package io.github.jeanhwea.leetcode.basic.ch09;

import java.util.*;

/**
 * 位1的个数
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution191 {

  public static int hammingWeight(int n) {
    int count = 0;
    int mask = 0x1;
    for (int i = 0; i < 32; i++) {
      int k = n & (mask << i);
      if (k != 0) count++;
    }
    return count;
  }

  public static void main(String args[]) {
    int n = 0b1011;
    // n = -2;
    System.out.println(hammingWeight(n));
  }
}
