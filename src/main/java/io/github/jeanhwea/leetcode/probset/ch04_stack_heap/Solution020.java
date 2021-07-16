package io.github.jeanhwea.leetcode.probset.ch04_stack_heap;

import java.util.*;

/**
 * 有效的括号
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution020 {

  public static boolean isValid(String s) {
    Deque<Character> stack = new LinkedList<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      switch (ch) {
        case '(':
        case '[':
        case '{':
          stack.push(ch);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') return false;
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[') return false;
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{') return false;
          break;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("(){}"));
  }
}
