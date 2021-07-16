package io.github.jeanhwea.leetcode.probset.ch04_stack_heap;

import java.util.*;

/**
 * 逆波兰表达式求值
 *
 * @author Jinghui Hu
 * @since 2021-07-12, JDK1.8
 */
@SuppressWarnings("all")
public class Solution150 {

  public static int evalRPN(String[] tokens) {
    int n = tokens.length, val1 = 0, val2 = 0;
    Deque<Integer> val = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      String token = tokens[i];
      switch (token) {
        case "+":
          val2 = val.pop();
          val1 = val.pop();
          val.push(val1 + val2);
          break;
        case "-":
          val2 = val.pop();
          val1 = val.pop();
          val.push(val1 - val2);
          break;
        case "*":
          val2 = val.pop();
          val1 = val.pop();
          val.push(val1 * val2);
          break;
        case "/":
          val2 = val.pop();
          val1 = val.pop();
          val.push(val1 / val2);
          break;
        default:
          val.push(Integer.parseInt(token));
          break;
      }
    }
    return val.pop();
  }

  public static void main(String[] args) {
    String[] tokens = {"2", "3", "+", "3", "*"};
    System.out.println(evalRPN(tokens));
  }
}
