package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 单词接龙 II
 *
 * @author Jinghui Hu
 * @since 2021-08-25, JDK1.8
 */
@SuppressWarnings("all")
public class Solution126 {

  // 构建搜索树
  private static Map<String, Integer> wordDepth;
  private static Map<String, List<String>> searchTree;

  private static boolean buildSearchTree(String beginWord, String endWord, Set<String> wordSet) {
    return true;
  }

  // 添加深度优先搜索 DFS
  private static List<List<String>> ans;
  private static Deque<String> path;

  private static void dfs(String beginWord, String curr) {
    if (curr.equals(beginWord)) {
      ans.add(new ArrayList<>(path));
      return;
    }
    for (String precursor : searchTree.get(curr)) {
      path.addFirst(precursor);
      dfs(beginWord, precursor);
      path.removeFirst();
    }
  }

  public static List<List<String>> findLadders(
      String beginWord, String endWord, List<String> wordList) {
    ans = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return ans;
    wordSet.remove(beginWord);

    wordDepth = new HashMap<>();
    searchTree = new HashMap<>();
    boolean found = buildSearchTree(beginWord, endWord, wordSet);

    if (found) {
      Deque<String> path = new ArrayDeque<>();
      path.addFirst(endWord);
      dfs(beginWord, endWord);
    }
    return ans;
  }

  public static void main(String[] args) {
    String beginWord = "hit", endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println(findLadders(beginWord, endWord, wordList));
  }
}
