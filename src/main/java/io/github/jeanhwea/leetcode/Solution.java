package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static boolean containsDuplicate0(int[] a) {
    int n = a.length;
    Set<Integer> tb = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (tb.contains(a[i])) return true;
      else tb.add(a[i]);
    }
    return false;
  }

  public static boolean containsDuplicate(int[] a) {
    int n = a.length;
    Arrays.sort(a);
    for (int i = 0; i < n - 1; i++) {
      if (a[i] == a[i + 1]) return true;
    }
    return false;
  }

  public static void main(String args[]) {
    int arrSize = 6;
    int[] a = new int[arrSize];
    for (int i = 0; i < arrSize; i++) {
      int e = (int) (Math.random() * 30);
      a[i] = e;
    }

    System.out.println(Arrays.toString(a));
    System.out.println("========================================");

    System.out.println(containsDuplicate(a));
  }
}
