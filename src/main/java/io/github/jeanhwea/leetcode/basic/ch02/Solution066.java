package io.github.jeanhwea.leetcode.basic.ch02;

import java.util.*;

/**
 * 加一
 *
 * @author Jinghui Hu
 * @since 2021-06-08, JDK1.8
 */
public class Solution066 {

  public static int[] plusOne(int[] a) {
    int n = a.length, c = 1;
    int[] b = new int[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      b[i + 1] = (a[i] + c) % 10;
      c = (a[i] + c) / 10;
    }
    b[0] = c;
    return Arrays.copyOfRange(b, c > 0 ? 0 : 1, n + 1);
  }

  public static void main(String args[]) {
    int[] a = {0};
    System.out.println(Arrays.toString(a));
    System.out.println("========================================");
    int[] b = plusOne(a);
    System.out.println(Arrays.toString(b));
  }
}
