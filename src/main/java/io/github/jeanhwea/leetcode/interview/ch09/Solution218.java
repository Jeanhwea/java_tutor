package io.github.jeanhwea.leetcode.interview.ch09;

import java.util.*;

/**
 * 天际线问题
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
@SuppressWarnings("all")
public class Solution218 {

  public static List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> res = new ArrayList<>();

    // heightRank 缓存当前所有建筑的最高点
    PriorityQueue<int[]> heightRank = new PriorityQueue<>((x, y) -> y[2] - x[2]);
    // 这里必须用 TreeMap，因为 TreeMap 内部实现使用了红黑树， key 是有序的
    Map<Integer, List<int[]>> keyPoints = new TreeMap<>();
    for (int[] e : buildings) {
      keyPoints.putIfAbsent(e[0], new ArrayList<>());
      keyPoints.putIfAbsent(e[1], new ArrayList<>());
      keyPoints.get(e[0]).add(e);
      keyPoints.get(e[1]).add(e);
    }

    for (int k : keyPoints.keySet()) {
      for (int[] e : keyPoints.get(k)) {
        if (e[0] == k) {
          heightRank.offer(e);
        } else {
          heightRank.remove(e);
        }
      }
      if (heightRank.isEmpty()) {
        res.add(Arrays.asList(k, 0));
      } else {
        int maxHeight = heightRank.peek()[2];
        if (res.size() == 0 || res.get(res.size() - 1).get(1) != maxHeight) {
          res.add(Arrays.asList(k, maxHeight));
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    List<List<Integer>> ans = getSkyline(buildings);
    System.out.println(ans);
  }
}
