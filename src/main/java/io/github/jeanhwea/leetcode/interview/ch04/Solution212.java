package io.github.jeanhwea.leetcode.interview.ch04;

import java.util.*;

/**
 * 单词搜索 II
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution212 {

  private static Trie trie;
  // private static Set<String> dict;
  private static List<String> ans;
  private static int[][] seen;
  private static StringBuffer c;
  private static char[][] a;
  private static int n, m;
  private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

  public static List<String> findWords(char[][] board, String[] words) {
    trie = new Trie();
    for (int i = 0; i < words.length; i++) trie.insert(words[i]);
    ans = new LinkedList<>();
    a = board;
    n = board.length;
    m = board[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        seen = new int[n][m];
        c = new StringBuffer();
        dfs(i, j);
      }
    }

    return ans;
  }

  private static void dfs(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= m) return;
    if (seen[x][y] == 1) return;

    char ch = a[x][y];
    String w = c.toString() + ch;
    if (trie.search(w) && !ans.contains(w)) ans.add(w);
    if (!trie.startsWith(w)) return;

    for (int i = 0; i < 4; i++) {
      int x1 = x + dx[i], y1 = y + dy[i];
      c.append(ch);
      seen[x][y] = 1;
      dfs(x1, y1);
      c.deleteCharAt(c.length() - 1);
      seen[x][y] = 0;
    }
  }

  public static class Trie {

    private boolean isLeaf;
    private Trie[] children;

    public Trie() {
      this.isLeaf = false;
      this.children = new Trie[26];
    }

    public void insert(String word) {
      Trie p = this;
      int n = word.length();
      for (int i = 0; i < n; i++) {
        int k = word.charAt(i) - 'a';
        if (p.children[k] == null) {
          p.children[k] = new Trie();
        }
        p = p.children[k];
      }
      p.isLeaf = true;
    }

    public boolean search(String word) {
      Trie p = searchPrefix(word);
      return p != null && p.isLeaf;
    }

    public boolean startsWith(String prefix) {
      Trie p = searchPrefix(prefix);
      return p != null;
    }

    private Trie searchPrefix(String prefix) {
      Trie p = this;
      int n = prefix.length();
      for (int i = 0; i < n; i++) {
        int k = prefix.charAt(i) - 'a';
        if (p.children[k] == null) return null;
        p = p.children[k];
      }
      return p;
    }
  }

  public static void main(String[] args) {
    char[][] board = {
      {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
    };
    String[] words = {"oath", "pea", "eat", "rain"};

    // char[][] board = {{'a'}};
    // String[] words = {"a"};

    // char[][] board = {{'a', 'b'}, {'c', 'd'}};
    // String[] words = {"abcd"};

    List<String> res = findWords(board, words);
    System.out.println(res);
  }
}
