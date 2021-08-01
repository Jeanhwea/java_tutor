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
  private static List<Integer> choose;
  private static List<List<Integer>> ans;

  public static List<List<Integer>> permute(int[] nums) {
    n = nums.length;
    choose = new LinkedList<>();
    for (int i = 0; i < n; i++) choose.add(nums[i]);
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
      Collections.swap(choose, i, k);
      perm(k + 1);
      Collections.swap(choose, i, k);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> res = permute(new int[] {1, 2, 3});
    System.out.println(res);
  }
}
