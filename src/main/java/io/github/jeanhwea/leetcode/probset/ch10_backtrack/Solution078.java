package io.github.jeanhwea.leetcode.probset.ch10_backtrack;

import java.util.*;

/**
 * 子集
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution078 {

  private static int[] a;
  private static List<List<Integer>> ans;
  private static List<Integer> choose;

  private static void backtrack(int k) {
    if (k == a.length) {
      ans.add(new ArrayList<Integer>(choose));
      return;
    }

    backtrack(k + 1);

    choose.add(a[k]);
    backtrack(k + 1);
    choose.remove(choose.size() - 1);
  }

  public static List<List<Integer>> subsets(int[] nums) {
    a = nums;
    ans = new LinkedList<>();
    choose = new LinkedList<>();

    backtrack(0);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(subsets(nums));
  }
}
