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

  public static int longestValidParentheses(String s) {
    Deque<Integer> stack = new LinkedList<>();
    stack.push(-1);
    int n = s.length(), ans = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          // System.out.printf("i,peek=%d,%d\n", i, stack.peek());
          ans = Math.max(ans, i - stack.peek());
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    // System.out.println(longestValidParentheses("(())(()"));
    System.out.println(longestValidParentheses("()()"));
    // System.out.println(longestValidParentheses("(()"));
  }
}
