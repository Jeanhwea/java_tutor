package io.github.jeanhwea.leetcode.basic.ch03;

/**
 * 反转字符串
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
public class Solution344 {

  public static void reverseString(char[] s) {
    int n = s.length;
    for (int i = 0; i < n / 2; i++) {
      char t = s[i];
      s[i] = s[n - i - 1];
      s[n - i - 1] = t;
    }
  }

  public static void main(String[] args) {
    char[] a = {'h', 'e', 'l', 'l', 'o'};
    System.out.println(a);
    System.out.println("========================================");
    reverseString(a);
    System.out.println(a);
  }
}
