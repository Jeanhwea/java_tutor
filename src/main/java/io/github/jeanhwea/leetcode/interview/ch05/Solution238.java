package io.github.jeanhwea.leetcode.interview.ch05;

import java.util.*;

/**
 * 除自身以外数组的乘积
 *
 * @author Jinghui Hu
 * @since 2021-06-18, JDK1.8
 */
@SuppressWarnings("all")
public class Solution238 {

  public static int[] productExceptSelf(int[] a) {
    int n = a.length;
    int[] b = new int[n];
    Arrays.fill(b, 1);

    for (int i = 1; i < n; i++) {
      b[i] = b[i - 1] * a[i - 1];
    }
    // System.out.println(Arrays.toString(b));

    int prod = 1;
    for (int i = n - 2; i >= 0; i--) {
      prod *= a[i + 1];
      b[i] *= prod;
    }

    return b;
  }

  public static void main(String[] args) {
    // int[] a = {1, 2, 3, 4};
    int[] a = {-1, 1, 0, -3, 3};
    System.out.println(Arrays.toString(a));
    System.out.println("========================================");
    System.out.println(Arrays.toString(productExceptSelf(a)));
  }
}
