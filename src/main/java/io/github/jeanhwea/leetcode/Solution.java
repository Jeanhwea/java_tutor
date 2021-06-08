package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static void sink(int[] a, int p, int n) {
    int mi = p;
    while (true) {
      int s = 2 * p + 1;
      while (s < n && a[s] < a[mi]) mi = s;
      ++s;
      while (s < n && a[s] < a[mi]) mi = s;
      if (p == mi) break;

      int t = a[mi];
      a[mi] = a[p];
      a[p] = t;
      p = mi;
    }
  }

  public static void main(String args[]) {
    int[] a = genArray(8);
    display(a);
    for (int i = a.length / 2 - 1; i >= 0; i--) {
      sink(a, i, a.length);
    }
    display(a);

    int[] b = new int[a.length];
    for (int i = 0; i < b.length; i++) {
      b[i] = a[0];
      a[0] = a[b.length - i - 1];
      sink(a, 0, b.length - i);
    }
    display(b);
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
