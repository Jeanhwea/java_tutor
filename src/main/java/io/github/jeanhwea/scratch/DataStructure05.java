package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 图
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class DataStructure05 {

  // 广度优先搜索 Breadth First Search
  public static void bfs(int[][] edges, int n, int start) {
    List<Integer> tree = new LinkedList<>();
    Queue<Integer> vertex = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    vertex.offer(start);
    visited.add(start);
    tree.add(start);
    while (!vertex.isEmpty()) {
      int v = vertex.poll();
      for (int i = 0; i < n; i++) {
        if (!visited.contains(i) && edges[v][i] == 1) {
          visited.add(i);
          vertex.offer(i);
          tree.add(i);
        }
      }
    }
    System.out.println(Arrays.toString(tree.toArray()));
  }

  // 深度优先搜索 Depth First Search
  public static void dfs(int[][] edges, int n, int start) {
    List<Integer> tree = new LinkedList<>();
    Stack<Integer> vertex = new Stack<>();
    Set<Integer> visited = new HashSet<>();
    vertex.push(start);
    visited.add(start);
    tree.add(start);
    while (!vertex.isEmpty()) {
      int v = vertex.pop();
      for (int i = 0; i < n; i++) {
        if (!visited.contains(i) && edges[v][i] == 1) {
          vertex.push(i);
          visited.add(i);
          tree.add(i);
        }
      }
    }
    System.out.println(Arrays.toString(tree.toArray()));
  }

  public static void main(String args[]) {
    int[][] edges = makeGraph();
    bfs(edges, 6, 0);
    bfs(edges, 6, 1);
    bfs(edges, 6, 2);
    System.out.println("========================================");
    dfs(edges, 6, 0);
    dfs(edges, 6, 1);
    dfs(edges, 6, 2);
    dfs(edges, 6, 5);
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
