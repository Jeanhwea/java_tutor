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

  private static int wordCount = 0;
  private static Map<String, Integer> wordIdCache;
  private static Map<Integer, List<Integer>> edges;

  // 单词字符串到单词 id 的映射
  private static int getWordId(String word) {
    Integer wordId = wordIdCache.get(word);
    if (null == wordId) {
      wordId = wordCount++;
      wordIdCache.put(word, wordId);
      edges.put(wordId, new LinkedList<>());
    }
    return wordId;
  }

  // 遍历字典, 构建单词到中间词的图
  private static void buildGraph(Set<String> wordSet) {
    wordIdCache = new HashMap<>();
    edges = new HashMap<>();
    wordCount = 0;
    for (String wordX : wordSet) {
      int x = getWordId(wordX);
      char[] arr = wordX.toCharArray();
      for (int i = 0; i < wordX.length(); i++) {
        char ch = arr[i];
        arr[i] = '_';
        String wordY = new String(arr);
        arr[i] = ch;
        int y = getWordId(wordY);
        edges.get(x).add(y);
        edges.get(y).add(x);
      }
    }
    // System.out.println(wordIdCache);
    // System.out.println(edges);
  }

  // 查找最短路径, Dijkstra 最短路径算法
  private static int findShortestPath(int beginId, int endId) {
    int n = wordCount;

    PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[beginId] = 0;

    queue.offer(new int[] {beginId, dist[beginId]});
    while (!queue.isEmpty()) {
      int[] front = queue.poll();
      int currId = front[0], currDist = front[1];
      if (currId == endId) {
        return dist[currId] / 2 + 1;
      }
      for (int nextId : edges.get(currId)) {
        if (currDist + 1 < dist[nextId]) {
          dist[nextId] = currDist + 1;
          queue.offer(new int[] {nextId, dist[nextId]});
        }
      }
    }

    return 0;
  }

  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    if (!wordSet.contains(endWord)) return 0;

    buildGraph(wordSet);

    int beginId = getWordId(beginWord), endId = getWordId(endWord);

    return findShortestPath(beginId, endId);
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
