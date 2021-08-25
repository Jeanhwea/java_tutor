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

  private static Map<String, Integer> wordDepth;
  private static Map<String, List<String>> searchTree;

  private static boolean buildSearchTree(String beginWord, String endWord, Set<String> wordSet) {
    wordDepth.put(beginWord, 0);
    int depth = 1;
    boolean found = false;
    int wordLen = beginWord.length();
    Deque<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String currWord = queue.poll();
        char[] arr = currWord.toCharArray();
        for (int j = 0; j < wordLen; j++) {
          char origin = arr[j];
          for (char c = 'a'; c <= 'z'; c++) {
            arr[j] = c;
            String nextWord = String.valueOf(arr);
            if (wordDepth.containsKey(nextWord) && depth == wordDepth.get(nextWord)) {
              searchTree.get(nextWord).add(currWord);
            }
            if (!wordSet.contains(nextWord)) continue;
            wordSet.remove(nextWord);
            queue.offer(nextWord);
            searchTree.putIfAbsent(nextWord, new ArrayList<>());
            searchTree.get(nextWord).add(currWord);
            wordDepth.put(nextWord, depth);
            if (nextWord.equals(endWord)) found = true;
          }
          arr[j] = origin;
        }
      }
      depth++;
      if (found) break;
    }
    return found;
  }

  public static List<List<String>> findLadders(
      String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return ans;
    wordSet.remove(beginWord);

    // 第 1 步：广度优先遍历建图
    wordDepth = new HashMap<>();
    searchTree = new HashMap<>();
    boolean found = buildSearchTree(beginWord, endWord, wordSet);

    // 第 2 步：深度优先遍历找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
    if (found) {
      Deque<String> path = new ArrayDeque<>();
      path.add(endWord);
      dfs(searchTree, path, beginWord, endWord, ans);
    }
    return ans;
  }

  private static void dfs(
      Map<String, List<String>> from,
      Deque<String> path,
      String beginWord,
      String curr,
      List<List<String>> ans) {
    if (curr.equals(beginWord)) {
      ans.add(new ArrayList<>(path));
      return;
    }
    for (String precursor : from.get(curr)) {
      path.addFirst(precursor);
      dfs(from, path, beginWord, precursor, ans);
      path.removeFirst();
    }
  }

  public static void main(String[] args) {
    String beginWord = "hit", endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println(findLadders(beginWord, endWord, wordList));
  }
}
