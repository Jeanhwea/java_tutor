package io.github.jeanhwea.leetcode.interview.ch04;

import java.util.*;

/**
 * 分割回文串
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution131 {

  public static boolean check(String s) {
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != s.charAt(n - i - 1)) return false;
    }
    return true;
  }

  // 暴力枚举
  public static List<List<String>> partition(String s) {
    int n = s.length();
    List<List<String>> ans = new LinkedList<>();
    if (n <= 1) {
      List<String> list = new LinkedList<>();
      if (n > 0) list.add(s);
      ans.add(list);
      return ans;
    }

    for (int i = 1; i <= n; i++) {
      String pre = s.substring(0, i);
      if (check(pre)) {
        List<List<String>> suf = partition(s.substring(i, n));
        for (List<String> s0 : suf) {
          List<String> list = new LinkedList<>();
          list.add(pre);
          list.addAll(s0);
          ans.add(list);
        }
      }
    }

    return ans;
  }

  // 回溯法
  public static Deque<String> stack = new LinkedList<>();

  public static void backtrack(String s, int k) {
    int n = s.length();
    if (k == n) {
      System.out.println(stack.toString());
      return;
    }
    for (int i = k; i < n; ++i) {
      stack.push(s.substring(k, i + 1));
      backtrack(s, i + 1);
      stack.pop();
    }
  }

  public static void main(String[] args) {
    String s = "abcd";
    backtrack(s, 0);
    // List<List<String>> ans = partition(s);
    // System.out.println(ans.toString());
  }
}
