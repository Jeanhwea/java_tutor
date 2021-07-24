package io.github.jeanhwea.leetcode.interview.ch04_string;

/**
 * 实现 Trie（前缀树）
 *
 * @author Jinghui Hu
 * @since 2021-06-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution208 {

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
    Trie trie1 = new Trie();
    System.out.println(trie1.search("a"));

    // trie1.insert("ab");
    // System.out.println(trie1.search("ab"));
    // System.out.println(trie1.search("a"));
    // System.out.println(trie1.startsWith("a"));

    // trie1.insert("a");
    // System.out.println(trie1.search("a"));
  }
}
