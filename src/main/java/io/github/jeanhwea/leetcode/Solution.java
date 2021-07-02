package io.github.jeanhwea.leetcode;

import java.util.*;

@SuppressWarnings("all")
public class Solution {

  public static void main(String[] args) {
    int[][] a = {
      {1, 3, 5},
      {2, 4, 6},
      {6, 2, 1},
      {0, 8, 4}
    };
    System.out.println(visitMatrix(a));
  }

  public static List<Integer> visitMatrix(int[][] a) {
    List<Integer> ans = new LinkedList<>();

    int n = a.length, m = a[0].length;
    int left = 0, right = m - 1, top = 0, bottom = n - 1;

    int x = 0, y = 0;
    while (left < right || top < bottom) {
      top++;
      while (x <= right) System.out.println(a[y][x++]);
      x--;
      y++;

      right--;
      while (y <= bottom) System.out.println(a[y++][x]);
      x--;
      y--;

      bottom--;
      while (x >= left) System.out.println(a[y][x--]);
      x++;
      y--;

      left++;
      while (y >= top) System.out.println(a[y--][x]);
      x++;
      y++;
    }

    return ans;
  }

  public static List<Integer> visitMatrix1(int[][] a) {
    List<Integer> ans = new LinkedList<>();

    int n = a.length, m = a[0].length;

    for (int i = 0; i < n; i++) {
      int x = 0, y = i;
      while (x < m && y >= 0) {
        System.out.println(a[y--][x++]);
      }
    }

    for (int i = 1; i < m; i++) {
      int x = i, y = n - 1;
      while (x < m && y >= 0) {
        ans.add(a[y--][x++]);
      }
    }

    return ans;
  }
}
