package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static int calculate(String s) {
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
    String s = "3+2*2";
    int res = calculate(s);
    System.out.println(res);
  }
}
