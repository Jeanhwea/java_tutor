package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 括号生成
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution022 {

  public static List<String> generateParenthesis(int num) {
    n = num;
    choose = new StringBuilder();
    ans = new LinkedList<>();
    dfs(0, 0);
    return ans;
  }

  private static int n;
  private static StringBuilder choose;
  private static List<String> ans;

  private static void dfs(int open, int close) {
    if (choose.length() == n * 2) {
      ans.add(choose.toString());
      return;
    }
    if (open < n) {
      choose.append('(');
      dfs(open + 1, close);
      choose.deleteCharAt(choose.length() - 1);
    }
    if (close < open) {
      choose.append(')');
      dfs(open, close + 1);
      choose.deleteCharAt(choose.length() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(generateParenthesis(3));
  }
}
