package io.github.jeanhwea.leetcode.interview.ch04;

/**
 * 实现 Trie（前缀树）
 *
 * @author Jinghui Hu
 * @since 2021-06-16, JDK1.8
 */
public class Solution208 {

  public static class Trie {

    private boolean isLeaf;
    private char[] children;

    public Trie() {
      this.isLeaf = true;
      this.children = new char[26];
    }

    public void insert(String word) {
      int n = word.length();
      for (int i = 0; i < n; i++) {
        char ch = word.charAt(i);
      }
    }

    public boolean search(String word) {
      return false;
    }

    public boolean startsWith(String prefix) {
      return false;
    }
  }

  public static void main(String args[]) {
    Trie trie1 = new Trie();
  }
}
