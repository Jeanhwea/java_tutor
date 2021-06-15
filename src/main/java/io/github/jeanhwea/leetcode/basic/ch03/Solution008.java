package io.github.jeanhwea.leetcode.basic.ch03;

import java.util.*;

/**
 * 字符串转换整数(atoi)
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
public class Solution008 {

  public static int myAtoi(String s) {
    int n = s.length(), sign = 1, i = 0;
    long ans = 0;
    boolean start = false;

    while (i < n && s.charAt(i) == ' ') i++;
    if (i == n) return 0;

    char ch = s.charAt(i);
    if (ch == '+') {
      sign = 1;
      i++;
    } else if (ch == '-') {
      sign = -1;
      i++;
    } else if (!Character.isDigit(ch)) return 0;

    while (i < n) {
      ch = s.charAt(i++);
      if (Character.isDigit(ch)) {
        ans = 10 * ans + (ch - '0');
        if (sign > 0 && ans > Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        } else if (sign < 0 && -ans < Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
        }
      } else break;
    }

    return (int) ans * sign;
  }

  public static void main(String args[]) {
    System.out.println(myAtoi("-9834"));
    System.out.println(myAtoi("9834"));
    System.out.println(myAtoi("-9.834"));
    System.out.println(myAtoi("wor -9834"));
    System.out.println(myAtoi("9876543210"));
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static int[] genArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = (int) (Math.random() * 50);
    }
    return a;
  }

  public static void display(int[] a) {
    System.out.println(Arrays.toString(a));
  }

  public static void display(Collection<Integer> a) {
    System.out.println(Arrays.toString(a.toArray()));
  }
}
