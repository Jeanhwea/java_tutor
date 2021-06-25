package io.github.jeanhwea.leetcode.interview.ch11;

import java.util.*;

/**
 * 最长递增子序列
 *
 * @author Jinghui Hu
 * @since 2021-06-25, JDK1.8
 */
public class Solution300 {

  public static int lengthOfLIS(int[] a) {
    Deque<Integer> choose = new LinkedList<>();
    Deque<List<Integer>> ans = new LinkedList<>();
    dfs(a, 0, choose, ans);
    System.out.println(ans);
    return currAns;
  }

  private static int currAns = 0;

  public static void dfs(int[] a, int k, Deque<Integer> choose, Deque<List<Integer>> ans) {
    // System.out.printf("currAns=%d, choose=%s\n", currAns, choose);
    int n = a.length;
    if (choose.size() > currAns) {
      currAns = choose.size();
      ans.clear();
      ans.push(new ArrayList<>(choose));
    }

    if (k >= n) return;

    if (choose.isEmpty() || choose.peekLast() < a[k]) {
      choose.offerLast(a[k]);
      dfs(a, k + 1, choose, ans);
      choose.pollLast();
    }

    dfs(a, k + 1, choose, ans);
  }

  public static int lengthOfLIS1(int[] a) {
    int ans = 1, n = a.length;
    int[] dp = new int[n];

    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      int max1 = 1;
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) {
          max1 = Math.max(max1, dp[j] + 1);
        }
      }
      dp[i] = max1;
      ans = Math.max(ans, max1);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
    // int[] a = {0, 1, 0, 3, 2, 3};
    // int[] a = {7, 7, 7, 7, 7, 7};
    System.out.println(lengthOfLIS(a));
  }
}
