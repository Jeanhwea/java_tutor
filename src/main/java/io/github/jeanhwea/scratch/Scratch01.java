package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 全排列
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class Scratch01 {

  public static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void perm0(int[] a, int p, int q) {
    if (p >= q) {
      System.out.println(Arrays.toString(a));
      return;
    }
    for (int i = p; i <= q; i++) {
      swap(a, i, p);
      perm0(a, p + 1, q);
      swap(a, i, p);
    }
  }

  public static void perm(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = i + 1;
    }
    perm0(a, 0, n - 1);
  }

  public static void main(String[] args) {
    perm(4);
  }
}
