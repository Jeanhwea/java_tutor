package io.github.jeanhwea.leetcode.interview.ch06;

import java.util.*;

/**
 * 逆波兰表达式求值
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
public class Solution150 {

  public static int evalRPN(String[] tokens) {
    List<String> opList = Arrays.asList("+", "-", "*", "/");
    Deque<Integer> val = new LinkedList<>();
    for (int i = 0; i < tokens.length; i++) {
      String t = tokens[i];
      if (opList.contains(t)) {
        int val2 = val.pop(), val1 = val.pop();
        switch (t) {
          case "+":
            val.push(val1 + val2);
            break;
          case "-":
            val.push(val1 - val2);
            break;
          case "*":
            val.push(val1 * val2);
            break;
          case "/":
            val.push(val1 / val2);
            break;
        }
      } else {
        val.push(Integer.parseInt(t));
      }
    }

    return val.pop();
  }

  public static void main(String[] args) {
    String[] tokens = {"2", "3", "+", "3", "*"};
    System.out.println(evalRPN(tokens));
  }
}
