package io.github.jeanhwea.leetcode.probset.ch03_string;

/**
 * 二进制求和
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution067 {

  public static String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int carry = 0, n = a.length(), m = b.length(), i = n - 1, j = m - 1;
    while (i >= 0 || j >= 0) {
      int num1 = i >= 0 ? a.charAt(i--) - '0' : 0;
      int num2 = j >= 0 ? b.charAt(j--) - '0' : 0;
      carry += num1 + num2;
      sb.append((char) (carry % 2 + '0'));
      carry /= 2;
    }
    if (carry > 0) sb.append('1');
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    String a = "1010", b = "1011";
    System.out.println(addBinary(a, b));
  }
}
