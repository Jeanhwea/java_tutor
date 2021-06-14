package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 图
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class DataStructure05 {

  public static void bfs(int[][] edges, int n) {
    Queue<Integer> vertex = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    vertex.offer(0);
    while (!vertex.isEmpty()) {
      int v = vertex.poll();
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          if (edges[i][j] == 1 && !visited.contains(i)) {
            visited.add(j);
            vertex.offer(j);
            System.out.println(j);
          }
        }
      }
    }
  }

  public static void main(String args[]) {
    int[][] edges = makeGraph();
    bfs(edges, 6);
    // display(edges);
  }

  private static void display(int[][] a) {
    System.out.println(Arrays.deepToString(a).replace("], [", "],\n ["));
  }

  private static int[][] makeGraph() {
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
    return edges;
  }
}
