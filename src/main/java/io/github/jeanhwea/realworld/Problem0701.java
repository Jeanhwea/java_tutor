package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 打印矩阵：按右上角到左下角沿对角线逆序打印
 *
 * @author Jinghui Hu
 * @since 2021-07-01, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0701 {

  public static void main(String[] args) {
    int[][] a = {
      {9, 6, 3, 1},
      {11, 8, 5, 2},
      {12, 10, 7, 4}
    };
    System.out.println(visitMatrix(a));
  }

  public static List<Integer> visitMatrix(int[][] a) {
    List<Integer> ans = new LinkedList<>();

    int n = a.length, m = a[0].length;
    for (int i = 0; i < n; i++) {
      int x = m - 1, y = i;
      while (x >= 0 && y >= 0) ans.add(a[y--][x--]);
    }

    for (int j = m - 2; j >= 0; j--) {
      int x = j, y = n - 1;
      while (x >= 0 && y >= 0) ans.add(a[y--][x--]);
    }

    return ans;
  }
}
