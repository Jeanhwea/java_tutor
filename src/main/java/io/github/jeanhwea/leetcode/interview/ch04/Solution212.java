package io.github.jeanhwea.leetcode.interview.ch04;

import java.util.*;

/**
 * 单词搜索 II
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
public class Solution212 {

  private static Set<String> dict;
  private static List<String> ans;
  private static int[][] seen;
  private static List<Character> choose;
  private static int n, m;
  private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

  public static List<String> findWords(char[][] board, String[] words) {
    dict = new HashSet<>();
    for (int i = 0; i < words.length; i++) dict.add(words[i]);
    ans = new LinkedList<>();
    n = board.length;
    m = board[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        seen = new int[n][m];
        choose = new LinkedList<>();
        dfs(board, i, j);
      }
    }

    return ans;
  }

  private static void dfs(char[][] board, int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= m) return;
    if (seen[x][y] == 1) return;

    char ch = board[x][y];
    String w = "";
    for (int i = 0; i < choose.size(); i++) {
      w += choose.get(i);
    }
    w += ch;
    if (dict.contains(w) && !ans.contains(w)) ans.add(w);

    for (int i = 0; i < 4; i++) {
      int x1 = x + dx[i], y1 = y + dy[i];
      choose.add(ch);
      seen[x][y] = 1;
      dfs(board, x1, y1);
      choose.remove(choose.size() - 1);
      seen[x][y] = 0;
    }
  }

  public static void main(String[] args) {
    // char[][] board = {
    //   {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
    // };
    // String[] words = {"oath", "pea", "eat", "rain"};

    // char[][] board = {{'a'}};
    // String[] words = {"a"};

    char[][] board = {{'a', 'b'}, {'c', 'd'}};
    String[] words = {"abcd"};

    List<String> res = findWords(board, words);
    System.out.println(res);
  }
}
