package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static void threeSum(int[] a, int target) {
    int n = a.length;
    List<Integer> choose = new LinkedList<>();
    Set<List<Integer>> ans = new HashSet<>();
    dfs(a, 0, target, choose, 0, ans);
    System.out.println(ans);
  }

  public static void dfs(
      int[] a, int k, int target, List<Integer> choose, int currSum, Set<List<Integer>> ans) {
    int n = a.length;
    if (choose.size() == 3 && currSum == target) {
      ans.add(new ArrayList<>(choose));
      return;
    }

    // purge
    if (currSum > 10 || k >= n) return;

    // if not choose a[k]
    dfs(a, k + 1, target, choose, currSum, ans);

    // if choose a[k]
    choose.add(a[k]);
    currSum += a[k];
    dfs(a, k + 1, target, choose, currSum, ans);
    choose.remove(choose.size() - 1);
    currSum -= a[k];
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 0, 4, 2, 3, 9, 3, 0, 7, 6};
    threeSum(a, 10);
  }
}
