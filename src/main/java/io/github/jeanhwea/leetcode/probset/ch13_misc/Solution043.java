package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 字符串相乘
 *
 * @author Jinghui Hu
 * @since 2021-09-04, JDK1.8
 */
@SuppressWarnings("all")
public class Solution043 {

  public static String multiply(String num1, String num2) {
    int n = num1.length(), m = num2.length();
    // 特殊情况
    if ("0".equals(num1) || "0".equals(num2)) return "0";
    // 计算过程
    String ans = "";
    for (int k = m - 1; k >= 0; k--) {
      StringBuffer res = new StringBuffer();
      int carry = 0;
      for (int j = 1; j < m - k; j++) res.append('0');
      int d = num2.charAt(k) - '0';
      for (int i = n - 1; i >= 0; i--) {
        int a = num1.charAt(i) - '0';
        int product = a * d + carry;
        res.append((char) (product % 10 + '0'));
        carry = product / 10;
      }
      if (carry > 0) res.append((char) (carry + '0'));
      ans = add(ans, res.reverse().toString());
    }
    return ans;
  }

  private static String add(String num1, String num2) {
    StringBuffer ans = new StringBuffer();
    int carry = 0, n = num1.length(), m = num2.length();
    int i = n - 1, j = m - 1;
    while (i >= 0 || j >= 0) {
      int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
      int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
      int sum = n1 + n2 + carry;
      // System.out.printf("n1=%d,n2=%d,sum=%d\n", n1, n2, sum);
      ans.append((char) ((sum % 10) + '0'));
      carry = sum / 10;
    }
    if (carry > 0) ans.append((char) (carry + '0'));
    return ans.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(multiply("123", "456"));
    System.out.println(multiply("0", "0"));
    System.out.println(multiply("9", "9"));
    // System.out.println(add("923", "459"));
  }
}
