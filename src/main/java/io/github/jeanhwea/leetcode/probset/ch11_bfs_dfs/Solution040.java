package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 组合总和 II
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution040 {

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    numCount = new ArrayList<>();
    Arrays.sort(candidates);
    for (int i = 0; i < candidates.length; i++) {
      int lastIndex = numCount.size() - 1;
      if (numCount.isEmpty() || numCount.get(lastIndex)[0] != candidates[i]) {
        numCount.add(new int[] {candidates[i], 1});
      } else {
        numCount.get(lastIndex)[1]++;
      }
    }
    // for (int[] pair : numCount) System.out.println(Arrays.toString(pair));
    n = numCount.size();
    choose = new LinkedList<>();
    ans = new LinkedList<>();
    dfs(0, target);
    return ans;
  }

  private static int n;
  private static List<int[]> numCount;
  private static List<Integer> choose;
  private static List<List<Integer>> ans;

  private static void dfs(int k, int target) {
    if (k == n) {
      if (target == 0) ans.add(new ArrayList<Integer>(choose));
      return;
    }

    dfs(k + 1, target);

    int val = numCount.get(k)[0];
    int most = Math.min(target / val, numCount.get(k)[1]);
    for (int i = 1; i <= most; i++) {
      choose.add(val);
      dfs(k + 1, target - i * val);
    }
    for (int i = 0; i < most; i++) {
      choose.remove(choose.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    System.out.println(combinationSum2(candidates, target));
  }
}
