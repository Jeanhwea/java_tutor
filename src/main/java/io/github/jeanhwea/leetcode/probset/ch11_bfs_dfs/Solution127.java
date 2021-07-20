package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 单词接龙
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution127 {

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

    // PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    int beginId = wordId.get(beginWord), endId = wordId.get(endWord);

    Deque<Integer> queue = new LinkedList<>();
    queue.offer(beginId);
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[beginId] = 0;

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
