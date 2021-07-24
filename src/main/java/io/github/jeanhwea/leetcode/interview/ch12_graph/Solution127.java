package io.github.jeanhwea.leetcode.interview.ch12_graph;

import java.util.*;

/**
 * 单词接龙
 *
 * @author Jinghui Hu
 * @since 2021-06-26, JDK1.8
 */
@SuppressWarnings("all")
public class Solution127 {

  // BFS + 建图优化
  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int n = 0;
    Map<String, Integer> wordId = new HashMap<>();
    Map<Integer, List<Integer>> edges = new HashMap<>();

    Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    if (!wordSet.contains(endWord)) return 0;

    for (String w : wordSet) {
      int x = n;
      edges.put(n, new ArrayList<>());
      wordId.put(w, n++);

      char[] a = w.toCharArray();
      for (int i = 0; i < a.length; i++) {
        char ch = a[i];
        a[i] = '*';
        String w1 = new String(a);
        a[i] = ch;

        if (!wordId.containsKey(w1)) {
          edges.put(n, new ArrayList<>());
          wordId.put(w1, n++);
        }
        int y = wordId.get(w1);

        edges.get(x).add(y);
        edges.get(y).add(x);
      }
    }

    int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[beginId] = 0;

    Deque<Integer> queue = new LinkedList<>();
    queue.offer(beginId);
    while (!queue.isEmpty()) {
      int x = queue.poll();
      if (x == endId) {
        return dist[x] / 2 + 1;
      }
      for (Integer y : edges.get(x)) {
        if (dist[y] == Integer.MAX_VALUE) {
          dist[y] = dist[x] + 1;
          queue.offer(y);
        }
      }
    }

    return 0;
  }

  // Dijkstra 最短路径解法
  public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
    Map<String, Integer> vertex = new HashMap<>();
    int count = 0;
    vertex.put(beginWord, count++);
    for (String w : wordList) vertex.putIfAbsent(w, count++);
    if (!vertex.containsKey(endWord)) return 0;

    Map<Integer, String> vertex1 = new HashMap<>();
    for (Map.Entry<String, Integer> e : vertex.entrySet()) {
      vertex1.put(e.getValue(), e.getKey());
    }

    Map<String, List<String>> edges = new HashMap<>();
    for (String w1 : vertex.keySet()) {
      List<String> next = new LinkedList<>();
      for (String w2 : vertex.keySet()) {
        if (w1.length() != w2.length() || w1.equals(w2)) continue;
        int diffCount = 0;
        for (int i = 0; i < w1.length(); i++) {
          if (w1.charAt(i) != w2.charAt(i)) diffCount++;
          if (diffCount > 1) break;
        }
        if (diffCount == 1) next.add(w2);
      }
      edges.put(w1, next);
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
    Map<String, Integer> dist = new HashMap<>(), seen = new HashMap<>();
    pq.offer(new int[] {0, 1});
    while (!pq.isEmpty()) {
      int[] e = pq.poll();
      String cw = vertex1.get(e[0]);
      int mi = e[1];
      if (seen.containsKey(cw)) continue;
      seen.put(cw, 1);
      List<String> next = edges.get(cw);
      if (next == null) continue;
      for (String nw : next) {
        int d = Math.min(dist.getOrDefault(nw, Integer.MAX_VALUE), mi + 1);
        dist.put(nw, d);
        pq.offer(new int[] {vertex.get(nw), d});
      }
    }

    return dist.getOrDefault(endWord, 0);
  }

  public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    Map<String, Integer> tb = new HashMap<>();
    int n = 0;
    tb.put(beginWord, n++);
    for (String word : wordList) tb.putIfAbsent(word, n++);
    if (tb.get(endWord) == null) return 0;

    int end = tb.get(endWord);

    int[][] edges = new int[n][n];
    for (String w1 : tb.keySet()) {
      for (String w2 : tb.keySet()) {
        if (w1.length() != w2.length() || w1.equals(w2)) continue;
        int diffCount = 0;
        for (int i = 0; i < w1.length(); i++) {
          if (w1.charAt(i) != w2.charAt(i)) diffCount++;
          if (diffCount > 1) break;
        }
        if (diffCount == 1) {
          int x = tb.get(w1), y = tb.get(w2);
          edges[x][y] = edges[y][x] = 1;
        }
      }
    }

    // System.out.println(tb);
    // System.out.println(Arrays.deepToString(edges));
    int[] seen = new int[n];
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    pq.offer(new int[] {0, 0});
    dist[0] = 0;
    while (!pq.isEmpty()) {
      int[] e = pq.poll();
      int x = e[0], mi = e[1];
      if (seen[x] == 1) continue;
      seen[x] = 1;

      // System.out.println(Arrays.toString(e));
      for (int y = 0; y < n; y++) {
        if (edges[x][y] == 1 && seen[y] == 0) {
          dist[y] = Math.min(dist[y], mi + 1);
          pq.offer(new int[] {y, dist[y]});
        }
      }
    }
    // System.out.println(Arrays.toString(dist));

    int ans = dist[end] == Integer.MAX_VALUE ? 0 : dist[end] + 1;
    return ans;
  }

  public static void main(String[] args) {
    String beginWord = "hit", endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println(ladderLength(beginWord, endWord, wordList));

    // String beginWord = "a", endWord = "c";
    // List<String> wordList = Arrays.asList("a", "b", "c");
    // System.out.println(ladderLength(beginWord, endWord, wordList));

    // String beginWord = "hot", endWord = "dog";
    // List<String> wordList = Arrays.asList("hot", "dog");
    // System.out.println(ladderLength(beginWord, endWord, wordList));
  }
}
