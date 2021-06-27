package io.github.jeanhwea.leetcode.interview.ch12;

import java.util.*;

/**
 * 课程表 II
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution210 {

  private static boolean valid;
  private static int[] state;
  private static List<ArrayList<Integer>> adj;
  private static Deque<Integer> ans;

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    valid = true;
    state = new int[numCourses];
    ans = new LinkedList<>();
    adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

    for (int i = 0; i < prerequisites.length; i++) {
      int[] e = prerequisites[i];
      adj.get(e[1]).add(e[0]);
    }

    for (int i = 0; i < numCourses && valid; i++) {
      if (state[i] == 0) dfs(i);
    }

    if (valid) {
      int[] ret = new int[ans.size()];
      int i = 0;
      while (!ans.isEmpty()) ret[i++] = ans.pop();
      return ret;
    }

    return new int[] {};
  }

  private static void dfs(int u) {
    // System.out.println(u);
    state[u] = 1;
    for (int v : adj.get(u)) {
      if (state[v] == 0) {
        state[u] = 1;
        dfs(v);
        if (!valid) return;
      } else if (state[v] == 1) {
        valid = false;
        return;
      }
    }
    state[u] = 2;
    ans.push(u);
    // System.out.println(ans);
  }

  public static void main(String[] args) {
    int numCourses = 4;
    int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    int[] ord = findOrder(numCourses, prerequisites);
    System.out.println(Arrays.toString(ord));
  }
}
