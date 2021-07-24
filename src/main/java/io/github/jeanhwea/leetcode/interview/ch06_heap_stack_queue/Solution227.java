package io.github.jeanhwea.leetcode.interview.ch06_heap_stack_queue;

import java.util.*;

/**
 * 基本计算器 II
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
public class Solution227 {

  public static int calculate(String s) {
    int n = s.length(), i = 0;
    Deque<Integer> val = new LinkedList<>();
    Deque<Character> op = new LinkedList<>();
    String token = "";
    while (i < n) {
      if (s.charAt(i) == ' ') {
        i++;
        continue;
      } else if (Character.isDigit(s.charAt(i))) {
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
          num = 10 * num + s.charAt(i++) - '0';
        }
        if (val.isEmpty()) {
          val.push(num);
        } else {
          char ch = op.peek();
          switch (ch) {
            case '*':
              op.pop();
              val.push(val.pop() * num);
              break;
            case '/':
              op.pop();
              val.push(val.pop() / num);
              break;
            case '-':
              op.pop();
              val.push(-num);
              break;
            default:
              val.push(num);
          }
        }
      } else {
        op.push(s.charAt(i++));
      }
    }

    int ans = 0;
    while (!val.isEmpty()) ans += val.pop();
    return ans;
  }

  public static int calculate0(String s) {
    s = s.replaceAll("(\\+|-|\\*|/)", " $1 ").replaceAll("  ", " ").trim();
    String[] tokens = s.split(" ");
    Deque<String> op = new LinkedList<>();
    Deque<Integer> val = new LinkedList<>();
    // System.out.println(Arrays.toString(tokens));
    for (int i = 0; i < tokens.length; i++) {
      String t = tokens[i];
      if ("+".equals(t) || "-".equals(t) || "*".equals(t) || "/".equals(t)) {
        op.push(t);
      } else {
        int val2 = Integer.parseInt(t);
        if (op.isEmpty()) {
          val.push(val2);
        } else {
          String op1 = op.peek();
          if ("*".equals(op1) || "/".equals(op1)) {
            int val1 = val.pop();
            val1 = "*".equals(op.pop()) ? val1 * val2 : val1 / val2;
            val.push(val1);
          } else {
            val.push(val2);
          }
        }
      }
    }

    int ans = 0;
    while (!op.isEmpty()) {
      int val1 = val.pop();
      String op1 = op.pop();
      ans += "+".equals(op1) ? val1 : -val1;
    }
    ans += val.pop();

    return ans;
  }

  public static void main(String[] args) {
    String s = "  31 + 2*4/8  ";
    int res = calculate(s);
    System.out.println(res);
  }
}
