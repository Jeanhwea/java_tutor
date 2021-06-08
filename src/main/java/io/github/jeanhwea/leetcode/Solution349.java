package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution349 {

  public static int[] intersect0(int[] a, int[] b) {
    int n = a.length, m = b.length;

    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
    for (int i = 0; i < n; i++) s1.add(a[i]);
    for (int i = 0; i < m; i++) {
      if (s1.contains(b[i]) && !s2.contains(b[i])) {
        s2.add(b[i]);
      }
    }

    int[] res = new int[s2.size()];
    int k = 0;
    for (Integer e : s2) {
      res[k++] = e;
    }
    return res;
  }

  public static int[] intersect(int[] a, int[] b) {
    int n = a.length, m = b.length;
    Arrays.sort(a);
    Arrays.sort(b);

    Set<Integer> c = new HashSet<>();
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (a[i] < b[j]) i++;
      else if (a[i] > b[j]) j++;
      else {
        c.add(a[i]);
        i++;
        j++;
      }
    }

    int[] res = new int[c.size()];
    int k = 0;
    for (Integer e : c) {
      res[k++] = e;
    }
    return res;
  }

  public static void main(String args[]) {
    int[] a = new int[] {4, 9, 5};
    int[] b = new int[] {9, 4, 9, 8, 4};
    // int[] a = new int[] {1};
    // int[] b = new int[] {1, 2};
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
