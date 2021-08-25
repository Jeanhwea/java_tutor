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

  public static List<List<String>> findLadders(
      String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return ans;
    wordSet.remove(beginWord);

    // 第 1 步：广度优先遍历建图
    Map<String, Integer> wordDepth = new HashMap<>();
    wordDepth.put(beginWord, 0);
    Map<String, List<String>> from = new HashMap<>();
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
        // 将每一位替换成 26 个小写英文字母
        for (int j = 0; j < wordLen; j++) {
          char origin = arr[j];
          for (char c = 'a'; c <= 'z'; c++) {
            arr[j] = c;
            String nextWord = String.valueOf(arr);
            if (wordDepth.containsKey(nextWord) && depth == wordDepth.get(nextWord)) {
              from.get(nextWord).add(currWord);
            }
            if (!wordSet.contains(nextWord)) {
              continue;
            }
            // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜
            // 索到已经遍历到，且距离更远的单词，需要将它从 wordSet 中删除
            wordSet.remove(nextWord);
            // 这一层扩展出的单词进入队列
            queue.offer(nextWord);

            // 记录 nextWord 从 currWord 而来
            from.putIfAbsent(nextWord, new ArrayList<>());
            from.get(nextWord).add(currWord);
            // 记录 nextWord 的 depth
            wordDepth.put(nextWord, depth);
            if (nextWord.equals(endWord)) {
              found = true;
            }
          }
          arr[j] = origin;
        }
      }
      depth++;
      if (found) break;
    }

    // 第 2 步：深度优先遍历找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
    if (found) {
      Deque<String> path = new ArrayDeque<>();
      path.add(endWord);
      dfs(from, path, beginWord, endWord, ans);
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
