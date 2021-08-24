package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 螺旋矩阵
 *
 * @author Jinghui Hu
 * @since 2021-07-02, JDK1.8
 */
@SuppressWarnings("all")
public class Solution054 {

  public static List<Integer> spiralOrder1(int[][] a) {
    List<Integer> ans = new LinkedList<>();

    int n = a.length, m = a[0].length, count = n * m;
    int left = 0, right = m - 1, top = 0, bottom = n - 1;

    int x = 0, y = 0;
    while (true) {
      top++;
      while (x <= right) ans.add(a[y][x++]);
      x--;
      y++;
      if (ans.size() == count) break;

      right--;
      while (y <= bottom) ans.add(a[y++][x]);
      x--;
      y--;
      if (ans.size() == count) break;

      bottom--;
      while (x >= left) ans.add(a[y][x--]);
      x++;
      y--;
      if (ans.size() == count) break;

      left++;
      while (y >= top) ans.add(a[y--][x]);
      x++;
      y++;
      if (ans.size() == count) break;
    }

    return ans;
  }

  public static List<Integer> spiralOrder(int[][] a) {
    List<Integer> ans = new LinkedList<>();
    if (a.length <= 0 || a[0].length <= 0) return ans;
    int n = a.length, m = a[0].length, count = n * m, i = 0, j = -1, k = 0;
    int[] di = new int[] {0, 1, 0, -1}, dj = new int[] {1, 0, -1, 0};
    boolean[][] seen = new boolean[n][m];
    while (count > 0) {
      i += di[k % 4];
      j += dj[k % 4];
      if (i < 0 || i >= n || j < 0 || j >= m || seen[i][j]) {
        i -= di[k % 4];
        j -= dj[k % 4];
        k++;
        continue;
      }
      ans.add(a[i][j]);
      seen[i][j] = true;
      count--;
    }
    return ans;
  }

  public static void main(String[] args) {
    // int[][] a = {
    //   {1, 2, 3, 4},
    //   {5, 6, 7, 8},
    //   {9, 10, 11, 12}
    // };
    int[][] a = {{9}};
    System.out.println(spiralOrder(a));
  }
}
