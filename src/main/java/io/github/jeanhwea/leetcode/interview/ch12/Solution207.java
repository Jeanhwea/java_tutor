package io.github.jeanhwea.leetcode.interview.ch12;

import java.util.*;

/**
 * 课程表
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution207 {

  private static boolean valid;
  private static List<ArrayList<Integer>> adj;
  private static int[] state;

  // 深度优先搜索 DFS
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    valid = true;
    adj = new ArrayList<>();
    state = new int[numCourses];
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

    for (int i = 0; i < prerequisites.length; i++) {
      int[] e = prerequisites[i];
      adj.get(e[1]).add(e[0]);
    }

    int[] state = new int[numCourses];
    for (int i = 0; i < numCourses && valid; i++) {
      if (state[i] == 0) dfs(i);
    }
    return valid;
  }

  // state 0:未搜索 1:搜索中 2:已完成
  private static void dfs(int u) {
    state[u] = 1;
    for (int v : adj.get(u)) {
      if (state[v] == 0) {
        dfs(v);
        if (!valid) return;
      } else if (state[v] == 1) {
        valid = false;
        return;
      }
    }
    state[u] = 2;
  }

  // 广度优先搜索 BFS
  public static boolean canFinish2(int numCourses, int[][] prerequisites) {
    int[] indeg = new int[numCourses];
    List<ArrayList<Integer>> edges = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) edges.add(new ArrayList<>());

    for (int i = 0; i < prerequisites.length; i++) {
      int[] e = prerequisites[i];
      edges.get(e[1]).add(e[0]);
      indeg[e[0]]++;
    }

    Deque<Integer> que = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indeg[i] == 0) que.add(i);
    }

    int seenCount = 0;
    while (!que.isEmpty()) {
      int u = que.poll();
      ++seenCount;
      for (int v : edges.get(u)) {
        indeg[v]--;
        if (indeg[v] == 0) que.offer(v);
      }
    }

    return seenCount == numCourses;
  }

  public static void main(String[] args) {
    // int numCourses = 2;
    // int[][] prerequisites = {{1, 0}};
    int numCourses = 1;
    int[][] prerequisites = {};
    System.out.println(canFinish(numCourses, prerequisites));
    System.out.println(canFinish2(numCourses, prerequisites));
  }
}
