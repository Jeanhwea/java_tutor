package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 组合总和
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution039 {

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    // Arrays.sort(candidates);
    a = candidates;
    n = candidates.length;
    choose = new LinkedList<>();
    ans = new LinkedList<>();
    dfs(0, target);
    return ans;
  }

  private static int[] a;
  private static int n;
  private static List<Integer> choose;
  private static List<List<Integer>> ans;

  // 计算从 a[k...] 的和满足和为 target
  private static void dfs(int k, int target) {
    if (target == 0) {
      ans.add(new ArrayList<Integer>(choose));
    } else if (target > 0) {
      for (int i = k; i < n; i++) {
        choose.add(a[i]);
        dfs(i, target - a[i]);
        choose.remove(choose.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    // int[] candidates = new int[] {2, 3, 6, 7};
    // int target = 7;
    int[] candidates = new int[] {2, 3, 5};
    int target = 8;
    System.out.println(combinationSum(candidates, target));
  }
}
