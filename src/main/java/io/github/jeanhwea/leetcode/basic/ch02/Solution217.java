package io.github.jeanhwea.leetcode.basic.ch02;

import java.util.*;

/**
 * 存在重复元素
 *
 * @author Jinghui Hu
 * @since 2021-06-08, JDK1.8
 */
@SuppressWarnings("all")
public class Solution217 {

  public static boolean containsDuplicate(int[] a) {
    int n = a.length;
    Set<Integer> st = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (st.contains(a[i])) return true;
      else st.add(a[i]);
    }
    return false;
  }

  public static boolean containsDuplicate1(int[] a) {
    int n = a.length;
    Arrays.sort(a);
    for (int i = 0; i < n - 1; i++) {
      if (a[i] == a[i + 1]) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = genArray(6);
    display(a);
    System.out.println("========================================");
    System.out.println(containsDuplicate(a));
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
