package io.github.jeanhwea.leetcode.interview.ch13;

import java.util.*;

/**
 * 阶乘后的零
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution172 {

  // 只需计算因子 5 的个数即可
  public static int trailingZeroes0(int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      int r = i + 1;
      while (r % 5 == 0) {
        count++;
        r /= 5;
      }
    }
    return count;
  }

  // 快速计算法
  public static int trailingZeroes(int n) {
    int count = 0;
    while (n > 0) {
      n /= 5;
      count += n;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(trailingZeroes(15));
  }
}
