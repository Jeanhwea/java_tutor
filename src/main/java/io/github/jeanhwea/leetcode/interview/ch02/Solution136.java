package io.github.jeanhwea.leetcode.interview.ch02;

import java.util.*;

/**
 * 只出现一次的数字
 *
 * @author Jinghui Hu
 * @since 2021-06-08, JDK1.8
 */
public class Solution136 {

  public static int singleNumber0(int[] a) {
    int n = a.length;
    Set<Integer> st = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (st.contains(a[i])) st.remove(a[i]);
      else st.add(a[i]);
    }

    return (int) st.toArray()[0];
  }

  public static int singleNumber(int[] a) {
    int n = a.length, ans = 0;
    for (int i = 0; i < n; i++) {
      ans ^= a[i];
    }
    return ans;
  }

  public static void main(String args[]) {
    int[] a = new int[] {1, 2, 3, 1, 3};
    System.out.println(Arrays.toString(a));
    System.out.println("========================================");
    int res = singleNumber(a);
    System.out.println(res);
  }
}
