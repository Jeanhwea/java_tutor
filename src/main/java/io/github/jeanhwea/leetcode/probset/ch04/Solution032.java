package io.github.jeanhwea.leetcode.probset.ch04;

import java.util.*;

/**
 * 最长有效括号
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution032 {

  // TODO:
  public static int longestValidParentheses(String s) {
    Deque<Character> stack = new LinkedList<>();
    int n = s.length(), i = 0, ans = 0, len = 0;
    boolean flag = true;
    while (i < n) {
      char ch = s.charAt(i++);
      if (ch == '(') {
        flag = false;
        stack.push(ch);
      } else {
        if (stack.isEmpty() || stack.peek() == ')') {
          if (flag) ans = Math.max(ans, len);
          len = 0;
          stack.pop();
          flag = true;
        } else if (stack.peek() == '(') {
          System.out.println(len);
          len += 2;
          stack.pop();
        }
      }
    }
    ans = Math.max(ans, len);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("(())(()"));
  }
}
