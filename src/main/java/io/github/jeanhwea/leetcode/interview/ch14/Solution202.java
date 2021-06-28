package io.github.jeanhwea.leetcode.interview.ch14;

import java.util.*;

/**
 * 快乐数
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution202 {

  public static boolean isHappy(int n) {
    int r, s;
    Set<Integer> set = new HashSet<>();
    while (n != 1) {
      if (set.contains(n)) return false;
      else set.add(n);
      s = 0;
      while (n > 0) {
        r = n % 10;
        s += r * r;
        n /= 10;
      }
      n = s;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isHappy(2));
    System.out.println(isHappy(19));
  }
}
