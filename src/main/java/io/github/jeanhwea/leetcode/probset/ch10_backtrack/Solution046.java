package io.github.jeanhwea.leetcode.probset.ch10_backtrack;

import java.util.*;

/**
 * 全排列
 *
 * @author Jinghui Hu
 * @since 2021-08-02, JDK1.8
 */
@SuppressWarnings("all")
public class Solution046 {

  private static int n;
  private static int[] a;
  private static List<Integer> choose;
  private static List<List<Integer>> ans;

  public static List<List<Integer>> permute(int[] nums) {
    n = nums.length;
    a = nums;
    choose = new LinkedList<>();
    ans = new LinkedList<>();
    perm(0);
    return ans;
  }

  public static void perm(int k) {
    if (k == n) {
      ans.add(new ArrayList<>(choose));
      return;
    }
    for (int i = k; i < n; i++) {
      choose.add(a[i]);
      swap(i, k);
      perm(k + 1);
      swap(i, k);
      choose.remove(choose.size() - 1);
    }
  }

  private static void swap(int i, int j) {
    int k = a[i];
    a[i] = a[j];
    a[j] = k;
  }

  public static void main(String[] args) {
    List<List<Integer>> res = permute(new int[] {1, 2, 3});
    System.out.println(res);
  }
}
