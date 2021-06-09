package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static boolean isAnagram(String s, String t) {
    int n = s.length(), m = t.length(), total = 26;
    if (n != m) return false;

    int[] a = new int[total], b = new int[total];
    for (int i = 0; i < n; i++) {
      int ai = s.charAt(i) - 'a', bi = t.charAt(i) - 'a';
      a[ai] = a[ai] + 1;
      b[bi] = b[bi] + 1;
    }

    for (int i = 0; i < total; i++) {
      if (a[i] != b[i]) return false;
    }

    return true;
  }

  public static void main(String args[]) {
    String s = "nl", t = "cx";
    System.out.println(isAnagram(s, t));
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
