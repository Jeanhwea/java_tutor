package io.github.jeanhwea.leetcode.interview.ch11;

import java.util.*;

/**
 * 矩阵中的最长递增路径
 *
 * @author Jinghui Hu
 * @since 2021-06-25, JDK1.8
 */
public class Solution329 {

  // 拓扑排序+动态规划
  public static int longestIncreasingPath(int[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0) return 0;
    int n = a.length, m = a[0].length;
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    int[][] outdegree = new int[n][m];
    int[][] dp = new int[n][m];
    for (int x0 = 0; x0 < n; x0++) {
      for (int y0 = 0; y0 < m; y0++) {
        for (int k = 0; k < 4; k++) {
          int x = x0 + dx[k], y = y0 + dy[k];
          if (x < 0 || x >= n || y < 0 || y >= m) continue;
          if (a[x][y] < a[x0][y0]) {
            outdegree[x][y]++;
          }
        }
      }
    }

    // System.out.println(Arrays.deepToString(outdegree));
    // System.out.println(Arrays.deepToString(dp));

    Deque<int[]> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (outdegree[i][j] <= 0) {
          dp[i][j] = 1;
          queue.add(new int[] {i, j});
        }
      }
    }

    int ans = 0;
    while (!queue.isEmpty()) {
      int[] pos = queue.poll();
      int x0 = pos[0], y0 = pos[1];
      // System.out.printf("(x0,y0)=(%d,%d)\n", x0, y0);
      for (int k = 0; k < 4; k++) {
        int x = x0 + dx[k], y = y0 + dy[k];
        if (x < 0 || x >= n || y < 0 || y >= m) continue;
        if (a[x0][y0] < a[x][y]) {
          dp[x0][y0] = Math.max(dp[x0][y0], dp[x][y] + 1);
          outdegree[x][y]--;
        }

        if (outdegree[x][y] == 0 || dp[x][y] <= 0) {
          queue.offer(new int[] {x, y});
        }
      }
      ans = Math.max(ans, dp[x0][y0]);
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
    int[][] a = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    System.out.println(longestIncreasingPath(a));
  }
}
