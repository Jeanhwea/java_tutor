package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 图
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class DataStructure05 {

  public static void main(String args[]) {
    int n = 6;
    int[][] edges = new int[n][n];
    edges[0][1] = edges[0][2] = 1;
    edges[1][2] = edges[1][3] = 1;
    edges[2][3] = edges[2][4] = 1;
    edges[3][4] = edges[3][5] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        edges[j][i] = i == j ? 1 : edges[i][j];
      }
    }
    display(edges);
  }

  private static void display(int[][] a) {
    System.out.println(Arrays.deepToString(a).replace("], [", "],\n ["));
  }
}
