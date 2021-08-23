package io.github.jeanhwea.leetcode.probset.ch10_backtrack;

import java.util.*;

/**
 * 全排列 II
 *
 * @author Jinghui Hu
 * @since 2021-08-23, JDK1.8
 */
@SuppressWarnings("all")
public class Solution047 {

  private static List<List<Integer>> ans;
  private static List<Integer> choose;
  private static boolean[] seen;
  private static int[] a;
  private static int n;

  private static void backtrack(int k) {
    if (k == n) {
      ans.add(new ArrayList<>(choose));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (seen[i] || (i > 0 && a[i] == a[i - 1] && !seen[i - 1])) {
        continue;
      }
      choose.add(a[i]);
      seen[i] = true;
      backtrack(k + 1);
      seen[i] = false;
      choose.remove(k);
    }
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    a = nums;
    n = nums.length;
    seen = new boolean[n];
    ans = new LinkedList<>();
    choose = new LinkedList<>();
    backtrack(0);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 2};
    System.out.println(permuteUnique(nums));
  }
}
