package io.github.jeanhwea.leetcode.basic;

import java.util.*;

/**
 * 两个数组交集 II
 *
 * @author Jinghui Hu
 * @since 2021-06-08, JDK1.8
 */
public class Solution350 {

  public static int[] intersect(int[] a, int[] b) {
    int n = a.length, m = b.length, i = 0, j = 0;
    Arrays.sort(a);
    Arrays.sort(b);

    int[] c = new int[Math.min(n, m)];
    int ci = 0;

    while (i < n && j < m) {
      if (a[i] < b[j]) i++;
      else if (a[i] > b[j]) j++;
      else {
        c[ci++] = a[i];
        i++;
        j++;
      }
    }

    return Arrays.copyOfRange(c, 0, ci);
  }

  public static int[] intersect1(int[] a, int[] b) {
    int n = a.length, m = b.length;
    Map<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int count = mp.getOrDefault(a[i], 0) + 1;
      mp.put(a[i], count);
    }

    int[] c = new int[m];
    int ci = 0;
    for (int i = 0; i < m; i++) {
      int count = mp.getOrDefault(b[i], 0);
      if (count > 0) {
        c[ci++] = b[i];
        mp.put(b[i], count - 1);
      }
    }

    return Arrays.copyOfRange(c, 0, ci);
  }

  public static void main(String args[]) {
    // int[] a = new int[] {4, 9, 5};
    // int[] b = new int[] {9, 4, 9, 8, 4};
    int[] a = new int[] {2, 2};
    int[] b = new int[] {1, 2, 2, 1};
    display(a);
    display(b);
    System.out.println("========================================");
    int[] c = intersect(a, b);
    display(c);
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static int[] genArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = (int) (Math.random() * 30);
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
