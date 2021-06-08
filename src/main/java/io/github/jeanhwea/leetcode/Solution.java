package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static int singleNumber(int[] a) {
    int n = a.length, ans = 0;
    for (int i = 0; i < n; i++) {
      ans ^= a[i];
    }
    return ans;
  }

  public static void main(String args[]) {
    // int[] a = genArray(6);
    // display(a);
    // System.out.println("========================================");
    // System.out.println(containsDuplicate(a));

    int[] a = new int[] {1, 2, 3, 1, 3};
    display(a);
    System.out.println("========================================");
    int res = singleNumber(a);
    System.out.println(res);
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
