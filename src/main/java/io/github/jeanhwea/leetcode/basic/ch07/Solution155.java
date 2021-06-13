package io.github.jeanhwea.leetcode.basic.ch07;

import java.util.*;

/**
 * 最小栈
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution155 {

  public static void main(String args[]) {}

  public Solution155() {}

  Stack<Integer> stack = new Stack<>();
  Stack<Integer> minStack = new Stack<>();

  public void push(int val) {
    stack.push(val);
    int minVal = (minStack.isEmpty() || val < minStack.peek()) ? val : minStack.peek();
    minStack.push(minVal);
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
