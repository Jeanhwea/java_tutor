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
    private Trie[] children;

    public Trie() {
      this.isLeaf = false;
      this.children = new Trie[26];
    }

    public void insert(String word) {
      Trie p = this;
      int n = word.length();
      for (int i = 0; i < n; i++) {
        char ch = word.charAt(i);
        if (p.children[ch - 'a'] == null) {
          p.children[ch - 'a'] = new Trie();
        }
        p = p.children[ch - 'a'];
      }
      p.isLeaf = true;
    }

    public boolean search(String word) {
      Trie p = this;
      int n = word.length(), i = 0;
      while (i < n) {
        char ch = word.charAt(i++);
        p = p.children[ch - 'a'];
        if (p == null) break;
      }
      return p != null && p.isLeaf && (i == n);
    }

    public boolean startsWith(String prefix) {
      Trie p = this;
      int n = prefix.length(), i = 0;
      while (i < n) {
        char ch = prefix.charAt(i++);
        p = p.children[ch - 'a'];
        if (p == null) break;
      }

      return (i == n);
    }
  }

  public static void main(String args[]) {
    Trie trie1 = new Trie();
    trie1.search("a");
    // trie1.insert("ab");
    // System.out.println(trie1.search("ab"));
    // System.out.println(trie1.search("a"));
    // System.out.println(trie1.startsWith("a"));

    // trie1.insert("a");
    // System.out.println(trie1.search("a"));
  }
}
