package io.github.jeanhwea.leetcode.basic.ch10;

/**
 * 汉明距离
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution461 {

  public static int hammingDistance0(int x, int y) {
    int mask = 1, count = 0;
    for (int i = 0; i < 32; i++) {
      int k = (x & (mask << i)) ^ (y & (mask << i));
      if (k != 0) count++;
    }
    return count;
  }

  public static int hammingDistance(int x, int y) {
    int s = x ^ y;
    int count = 0;
    while (s != 0) {
      s &= s - 1;
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    int x = 1, y = 4;
    System.out.println(hammingDistance(x, y));
  }
}
