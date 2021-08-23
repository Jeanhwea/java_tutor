package io.github.jeanhwea.leetcode.probset.ch10_backtrack;

import java.util.*;

/**
 * 子集 II
 *
 * @author Jinghui Hu
 * @since 2021-08-23, JDK1.8
 */
@SuppressWarnings("all")
public class Solution090 {

  private static List<List<Integer>> ans;
  private static List<Integer> choose;
  private static int[] a;
  private static int n;

  private static void backtrack(boolean choosePre, int k) {
    if (k == n) {
      ans.add(new ArrayList<>(choose));
      return;
    }

    backtrack(false, k + 1);

    // 如果排好序的前一个和当前相等，需要去重
    if (!choosePre && k > 0 && a[k - 1] == a[k]) return;

    choose.add(a[k]);
    backtrack(true, k + 1);
    choose.remove(choose.size() - 1);
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    a = nums;
    n = nums.length;
    ans = new LinkedList<>();
    choose = new LinkedList<>();
    backtrack(false, 0);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 2};
    System.out.println(subsetsWithDup(nums));
  }
}
