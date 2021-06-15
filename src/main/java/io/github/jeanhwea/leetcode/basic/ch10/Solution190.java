package io.github.jeanhwea.leetcode.basic.ch10;

/**
 * 颠倒二进制位
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution190 {

  public static int reverseBits0(int n) {
    int mask = 1;
    for (int i = 0; i < 16; i++) {
      int p = n & (mask << i), q = n & (mask << (31 - i));
      if (q == 0) {
        n &= (mask << i) ^ -1;
      } else {
        n |= mask << i;
      }
      if (p == 0) {
        n &= (mask << (31 - i)) ^ -1;
      } else {
        n |= mask << (31 - i);
      }
    }
    return n;
  }

  public static int reverseBits(int n) {
    int mask = 1, ans = 0;
    for (int i = 0; i < 32 && n != 0; i++) {
      ans |= (n & mask) << (31 - i);
      n >>>= 1;
    }
    return ans;
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
    int m = reverseBits(n);
    display(m);
  }
}
