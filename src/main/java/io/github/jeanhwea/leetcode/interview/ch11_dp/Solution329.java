package io.github.jeanhwea.leetcode.interview.ch11_dp;

import java.util.*;

/**
 * 矩阵中的最长递增路径
 *
 * @author Jinghui Hu
 * @since 2021-06-25, JDK1.8
 */
@SuppressWarnings("all")
public class Solution329 {

  // 拓扑排序+动态规划
  public static int longestIncreasingPath(int[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0) return 0;
    int n = a.length, m = a[0].length;
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    int[][] outdegree = new int[n][m];
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        for (int i = 0; i < 4; i++) {
          int x1 = x + dx[i], y1 = y + dy[i];
          if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
          if (a[x][y] < a[x1][y1]) {
            outdegree[x][y]++;
          }
        }
      }
    }

    // System.out.println(Arrays.deepToString(outdegree));
    // System.out.println(Arrays.deepToString(dp));

    Deque<int[]> queue = new LinkedList<>();
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        if (outdegree[x][y] <= 0) {
          queue.add(new int[] {x, y});
        }
      }
    }

    int ans = 0;
    while (!queue.isEmpty()) {
      ans++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] pos = queue.poll();
        int x = pos[0], y = pos[1];
        for (int j = 0; j < 4; j++) {
          int x1 = x + dx[j], y1 = y + dy[j];
          if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
          if (a[x][y] > a[x1][y1]) {
            outdegree[x1][y1]--;
            if (outdegree[x1][y1] <= 0) queue.offer(new int[] {x1, y1});
          }
        }
      }
    }

    return ans;
  }

  // 记忆化深度优先搜索
  public static int longestIncreasingPath1(int[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0) return 0;
    int n = a.length, m = a[0].length;
    int[][] memo = new int[n][m];

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ans = Math.max(ans, dfs(a, i, j, memo));
      }
    }

    return ans;
  }

  public static int dfs(int[][] a, int x, int y, int[][] memo) {
    if (memo[x][y] != 0) return memo[x][y];
    memo[x][y] = 1;

    int n = a.length, m = a[0].length;

    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    for (int i = 0; i < 4; i++) {
      int x1 = x + dx[i], y1 = y + dy[i];
      if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
      if (a[x][y] < a[x1][y1]) {
        memo[x][y] = Math.max(memo[x][y], dfs(a, x1, y1, memo) + 1);
      }
    }

    return memo[x][y];
  }

  public static void main(String[] args) {
    // int[][] a = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    int[][] a = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
    System.out.println(longestIncreasingPath(a));
  }
}
