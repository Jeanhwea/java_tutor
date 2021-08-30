package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 回文数
 *
 * @author Jinghui Hu
 * @since 2021-08-30, JDK1.8
 */
@SuppressWarnings("all")
public class Solution009 {

  public static boolean isPalindrome(int x) {
    if (x < 0) return false;
    int y = 0;
    while (x > y) {
      y = y * 10 + x % 10;
      x /= 10;
    }
    return x == y || x == y / 10;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(0));
    System.out.println(isPalindrome(11));
    System.out.println(isPalindrome(12));
    System.out.println(isPalindrome(121));
    System.out.println(isPalindrome(1001));
  }
}
