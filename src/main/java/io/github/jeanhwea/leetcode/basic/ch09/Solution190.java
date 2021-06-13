package io.github.jeanhwea.leetcode.basic.ch09;

import java.util.*;

/**
 * 颠倒二进制位
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution190 {

  public static int reverseBits(int n) {
    int mask1 = 1;
    for (int i = 0; i < 16; i++) {
      int p = n & (mask1 << i), q = n & (mask1 << (31 - i));
      if (q == 0) {
        n &= (mask1 << i) ^ -1;
      } else {
        n |= mask1 << i;
      }
      if (p == 0) {
        n &= (mask1 << (31 - i)) ^ -1;
      } else {
        n |= mask1 << (31 - i);
      }
    }
    return n;
  }

  public static void display(int n) {
    int mask = 1;
    String out = "";
    for (int i = 0; i < 32; i++) {
      int k = n & (mask << (31 - i));
      out += k == 0 ? "0" : "1";
    }
    System.out.println(out);
  }

  public static void main(String args[]) {
    int n = -3;
    // display(1^-1);
    display(n);
    System.out.println("");
    int m = reverseBits(n);
    display(m);
  }
}
