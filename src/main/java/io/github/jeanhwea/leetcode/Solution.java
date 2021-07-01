package io.github.jeanhwea.leetcode;

import java.util.*;

@SuppressWarnings("all")
public class Solution {

  public static void main(String[] args) {
    int[][] a = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
    };
    printMatrix(a);
  }

  public static void printMatrix(int[][] a) {
    int n = a.length, m = a[0].length;

    for (int i = 0; i < n; i++) {
      int x = n, y = i;
      while (y >= 0 && x >= 0) {
        System.out.println(a[y--][x--]);
      }
    }

    for (int i = m - 1; i >= 0; i--) {
      int x = i - 1, y = n - 1;
      while (y >= 0 && x >= 0) {
        System.out.println(a[y--][x--]);
      }
    }
  }
}
