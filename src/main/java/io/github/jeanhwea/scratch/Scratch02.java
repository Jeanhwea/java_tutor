package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 简单计算器，通过两个栈来实现：操作数栈和操作符栈
 *
 * @author Jinghui Hu
 * @since 2021-06-06, JDK1.8
 */
public class Scratch02 {

  public static void calc(String[] tokens) {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();

    for (int i = 0; i < tokens.length; i++) {
      String t = tokens[i];
      if (t.equals("(")) {
        // pass
      } else if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
        ops.push(t);
      } else if (t.equals(")")) {
        Double val = vals.pop();
        String op = ops.pop();
        Double top = vals.pop();
        if (op.equals("+")) {
          val = top + val;
        } else if (op.equals("-")) {
          val = top - val;
        } else if (op.equals("*")) {
          val = top * val;
        } else if (op.equals("/")) {
          val = top / val;
        }
        vals.push(val);
      } else {
        vals.push(Double.parseDouble(t));
      }
    }

    System.out.println(vals.pop());
  }

  public static void dipArr(int[] a, String name) {
    System.out.println("========================================");
    System.out.println(String.format("%s\t|", name));
    System.out.println("----------------------------------------");
    for (int i = 0; i < a.length; i++) {
      System.out.println(String.format("%d\t|\t%d", i, a[i]));
    }
    System.out.println("----------------------------------------");
  }

  public static void main(String args[]) {
    String exp = "( ( 4 * 3 ) + ( 15 / 5 ) )";
    String[] tokens = exp.split(" ");

    calc(tokens);
  }
}
