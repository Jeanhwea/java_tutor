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
    int depth = 1;
    wordDepth.put(beginWord, depth);
    wordSet.remove(beginWord);
    Deque<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String currWord = queue.poll();
        if (wordSet.contains(currWord)) continue;
        char[] arr = currWord.toCharArray();
        for (int j = 0; j < arr.length; j++) {
          char origin = arr[j];
          for (char ch = 'a'; ch <= 'z'; ch++) {
            arr[j] = ch;
            String nextWord = String.valueOf(arr);
            if (!wordSet.contains(nextWord)) continue;
            searchTree.putIfAbsent(currWord, new LinkedList<>());
            searchTree.get(currWord).add(nextWord);
            wordDepth.putIfAbsent(nextWord, depth + 1);
            wordSet.remove(nextWord);
            queue.offer(nextWord);
          }
          arr[j] = origin;
        }
      }
      depth++;
    }
    System.out.println(wordDepth);
    System.out.println(searchTree);
    return true;
  }

  // 添加深度优先搜索 DFS
  private static List<List<String>> ans;
  private static Deque<String> choose;

  private static void dfs(String beginWord, String curr) {
    if (curr.equals(beginWord)) {
      ans.add(new ArrayList<>(choose));
      return;
    }
    for (String next : searchTree.get(curr)) {
      choose.addFirst(next);
      dfs(beginWord, next);
      choose.removeFirst();
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
    if (!found) return ans;

    // choose = new ArrayDeque<>();
    // choose.addFirst(endWord);
    // dfs(beginWord, endWord);
    return ans;
  }

  public static void main(String[] args) {
    String beginWord = "hit", endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println(findLadders(beginWord, endWord, wordList));
  }
}
