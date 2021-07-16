package io.github.jeanhwea.leetcode.probset.ch03_string;

/**
 * 字符串转换整数 (atoi)
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution008 {

  public static int myAtoi(String s) {
    long sign = 1;
    int n = s.length(), i = 0;
    while (i < n && s.charAt(i) == ' ') i++;
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
      sign = s.charAt(i) == '-' ? -1 : 1;
      i++;
    }

    long ans = 0;
    while (i < n && Character.isDigit(s.charAt(i))) {
      char ch = s.charAt(i++);
      ans = 10 * ans + (ch - '0');
      if (sign > 0 && ans >= Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (sign < 0 && ans >= -(long) Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
    }

    return (int) (sign * ans);
  }

  public static void main(String[] args) {
    // pass
    System.out.println(myAtoi(" -4sss2"));
  }
}
