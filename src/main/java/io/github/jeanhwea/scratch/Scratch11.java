package io.github.jeanhwea.scratch;

import java.util.*;

public class Scratch11 {

  public static Stack<Integer> stackSort(Stack<Integer> s) {
    Stack<Integer> t = new Stack<>();
    while (!s.isEmpty()) {
      int top = s.pop();
      while (!t.isEmpty() && t.peek() > top) {
        s.push(t.pop());
      }
      t.push(top);
    }
    return t;
  }

  public static void main(String args[]) {
    Stack<Integer> a = new Stack<>();
    a.push(4);
    a.push(2);
    a.push(1);
    a.push(3);
    System.out.println(Arrays.toString(a.toArray()));

    System.out.println("========================================");
    Stack<Integer> b = stackSort(a);
    System.out.println(Arrays.toString(b.toArray()));
  }
}
