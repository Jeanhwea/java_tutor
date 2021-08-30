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
    // 负数不可能是回文数
    if (x < 0) return false;
    // 除 0 以外, 以 0 结尾的数字不可能是回文数, 因为最高位不可能为 0
    if (x % 10 == 0 && x != 0) return false;
    int rev = 0; // 记录高位
    while (x > rev) {
      rev = rev * 10 + x % 10;
      x /= 10;
    }
    return x == rev || x == rev / 10;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(0));
    System.out.println(isPalindrome(10));
    System.out.println(isPalindrome(12));
    System.out.println(isPalindrome(121));
    System.out.println(isPalindrome(1001));
  }
}
