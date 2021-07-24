package io.github.jeanhwea.leetcode.interview.ch04_string;

import java.util.*;

/**
 * 单词搜索 II
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
@SuppressWarnings("all")
public class Solution212 {

  public static class TrieNode {
    Map<Character, TrieNode> children;
    String word = null;

    void insert(String word) {
      TrieNode p = this;
      char[] letters = word.toCharArray();
      for (int i = 0; i < letters.length; i++) {
        char ch = letters[i];
        TrieNode c = p.children.getOrDefault(ch, new TrieNode());
        p.children.putIfAbsent(ch, c);
        p = c;
      }
      p.word = word;
    }

    TrieNode nextPrefix(char ch) {
      return this.children.get(ch);
    }

    public TrieNode() {
      this.children = new HashMap<>();
    }
  }

  private static TrieNode root;
  private static List<String> ans;
  private static int[][] seen;
  private static char[][] a;
  private static int n, m;
  private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

  public static List<String> findWords(char[][] board, String[] words) {
    root = new TrieNode();
    for (String word : words) root.insert(word);

    ans = new LinkedList<>();
    a = board;
    n = board.length;
    m = board[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        seen = new int[n][m];
        dfs(i, j, root);
      }
    }

    return ans;
  }

  private static void dfs(int x, int y, TrieNode root) {
    if (x < 0 || x >= n || y < 0 || y >= m || seen[x][y] == 1) return;
    char ch = a[x][y];
    TrieNode res = root.nextPrefix(ch);
    if (res == null) return;
    if (res.word != null && !ans.contains(res.word)) ans.add(res.word);

    seen[x][y] = 1;
    for (int i = 0; i < 4; i++) {
      int x1 = x + dx[i], y1 = y + dy[i];
      dfs(x1, y1, res);
    }
    seen[x][y] = 0;
  }

  public static void main(String[] args) {
    char[][] board = {
      {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
    };
    String[] words = {"oath", "pea", "eat", "rain"};

    // char[][] board = {{'a'}};
    // String[] words = {"a"};

    // char[][] board = {{'a', 'a'}};
    // String[] words = {"aaa"};

    // char[][] board = {{'a', 'b'}, {'c', 'd'}};
    // String[] words = {"abcd"};

    List<String> res = findWords(board, words);
    System.out.println(res);
  }
}
