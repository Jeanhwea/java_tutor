package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 插入区间
 *
 * @author Jinghui Hu
 * @since 2021-08-30, JDK1.8
 */
@SuppressWarnings("all")
public class Solution057 {

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    int left = newInterval[0], right = newInterval[1];
    List<int[]> tempList = new ArrayList<>();
    boolean added = false; // 记录 [left, right] 是否已经添加到 tempList 中
    for (int[] itv : intervals) {
      if (itv[0] > right) {
        if (!added) {
          tempList.add(new int[] {left, right});
          added = true;
        }
        tempList.add(itv);
      } else if (itv[1] < left) {
        tempList.add(itv);
      } else {
        left = Math.min(left, itv[0]);
        right = Math.max(right, itv[1]);
      }
    }
    if (!added) tempList.add(new int[] {left, right});
    int[][] ans = new int[tempList.size()][2];
    for (int i = 0; i < tempList.size(); i++) {
      ans[i] = tempList.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newInterval = {4, 8};
    int[][] ans = insert(intervals, newInterval);
    for (int i = 0; i < ans.length; i++) {
      System.out.printf("[%d,%d]\n", ans[i][0], ans[i][1]);
    }
  }
}
