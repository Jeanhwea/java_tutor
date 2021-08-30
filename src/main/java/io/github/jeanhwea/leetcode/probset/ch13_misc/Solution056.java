package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 合并区间
 *
 * @author Jinghui Hu
 * @since 2021-08-30, JDK1.8
 */
@SuppressWarnings("all")
public class Solution056 {

  public static int[][] merge(int[][] intervals) {
    if (intervals.length <= 0) return new int[0][2];
    Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
    List<int[]> tempList = new ArrayList<>();
    int left = intervals[0][0], right = intervals[0][1];
    for (int[] itv : intervals) {
      if (itv[0] > right) {
        tempList.add(new int[] {left, right});
        left = itv[0];
        right = itv[1];
      } else {
        left = Math.min(left, itv[0]);
        right = Math.max(right, itv[1]);
      }
    }
    tempList.add(new int[] {left, right});
    int[][] ans = new int[tempList.size()][2];
    for (int i = 0; i < tempList.size(); i++) {
      ans[i] = tempList.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    // int[][] intervals = {{1, 4}, {4, 5}};
    // int[][] intervals = {};
    int[][] ans = merge(intervals);
    for (int i = 0; i < ans.length; i++) {
      System.out.printf("[%d,%d]\n", ans[i][0], ans[i][1]);
    }
  }
}
