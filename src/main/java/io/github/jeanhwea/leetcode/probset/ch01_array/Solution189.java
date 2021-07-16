package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 旋转数组
 *
 * @author Jinghui Hu
 * @since 2021-06-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution189 {

  // 临时中转数组
  public static void rotate1(int[] a, int k) {
    int n = a.length;
    int[] b = Arrays.copyOf(a, n);

    for (int i = 0; i < n; i++) {
      a[(i + k) % n] = b[i];
    }
  }

  // 三次反转法
  public static void rotate2(int[] a, int k) {
    int n = a.length;
    k %= n;

    // [---->-->] => [<--<----]
    for (int i = 0; i < n / 2; i++) {
      swap(a, i, n - i - 1);
    }

    // [<--<----] => [--><----]
    for (int i = 0; i < k / 2; i++) {
      swap(a, i, k - i - 1);
    }

    // [--><----] => [-->---->]
    for (int i = k; i < n - (n - k) / 2; i++) {
      swap(a, i, n + k - i - 1);
    }
  }

  public static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  // 源往目的复制方法
  public static void rotate(int[] a, int k) {
    int n = a.length, start = 0, count = 0;
    k %= n;

    while (true) {
      int i = start, j = start, temp = a[start];
      do {
        j = i;
        i = (n - k + j) % n;
        a[j] = a[i];
        count++;
      } while (i != start);
      a[j] = temp;

      if (count < n) start++;
      else break;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6};
    rotate(a, 3);
    System.out.println(Arrays.toString(a));
  }
}
