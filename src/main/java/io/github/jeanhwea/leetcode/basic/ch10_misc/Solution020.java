package io.github.jeanhwea.leetcode.basic.ch10_misc;

import java.util.*;

/**
 * 有效的括号
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution020 {

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.isEmpty() || stack.pop() != '(') return false;
      } else if (ch == ']') {
        if (stack.isEmpty() || stack.pop() != '[') return false;
      } else if (ch == '}') {
        if (stack.isEmpty() || stack.pop() != '{') return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s = "()[]{}";
    System.out.println(isValid(s));
  }
}
