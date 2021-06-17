package io.github.jeanhwea.leetcode.interview.ch05;

import java.util.*;

/**
 * 递增的三元子序列
 *
 * @author Jinghui Hu
 * @since 2021-06-17, JDK1.8
 */
public class Solution334 {

  // 回溯法暴露搜索所有可能解（超时）
  public static boolean increasingTriplet0(int[] a) {
    List<Integer> choose = new ArrayList<>();
    return backtrack(a, 0, choose);
  }

  public static boolean backtrack(int[] a, int k, List<Integer> choose) {
    // System.out.printf("k=%d, choose=%s\n", k, choose.toString());
    int n = a.length;
    if (k < n) {
      for (int i = k; i < n; i++) {
        if (choose.isEmpty() || a[i] > choose.get(choose.size() - 1)) {
          choose.add(a[i]);
          if (choose.size() >= 3) return true;
          backtrack(a, i + 1, choose);
          choose.remove(choose.size() - 1);
        }
      }
    }

    return false;
  }

  // 记录当前最小的数字和当前第二小的数字
  public static boolean increasingTriplet(int[] a) {
    int n = a.length;
    if (n < 3) return false;

    int s0 = Integer.MAX_VALUE, s1 = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      if (a[i] <= s0) {
        s0 = a[i];
      } else if (a[i] <= s1) {
        s1 = a[i];
      } else return true;
    }
    return false;
  }

  public static void main(String args[]) {
    // int[] a = {1, 2, 3, 4, 5};
    // int[] a = {5, 4, 3, 2, 1};
    // int[] a = {1, 5, 0, 4, 1, 3};
    int[] a = {1, 2, 1, 2, 1, 2};
    System.out.println(increasingTriplet(a));
  }
}
