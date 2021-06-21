package io.github.jeanhwea.cheatsheet;


import java.util.*;

/**
 * 栈
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class DS02Stack {

  ////////////////////////////////////////////////////////////////////////////////
  // 出栈
  public static Integer pop(ListNode stack) {
    ListNode p = stack.next;
    if (p == null) return null;
    stack.next = p.next;
    return p.val;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 入栈
  public static void push(ListNode stack, int val) {
    ListNode p = new ListNode(val);
    p.next = stack.next;
    stack.next = p;
  }

  public static ListNode makeStack(int[] a) {
    ListNode list = ListNode.makeList(a);
    ListNode stack = new ListNode();
    stack.next = list;
    return stack;
  }

  public static void display(ListNode stack) {
    ListNode.display(stack.next);
  }

  public static void main(String[] args) {
    ListNode stack0 = null;
    ListNode stack1 = makeStack(new int[] {1});
    ListNode stack2 = makeStack(new int[] {1, 2});
    ListNode stack3 = makeStack(new int[] {1, 2, 3, 4, 5, 6, 7});

    push(stack2, 4);
    push(stack2, 8);
    for (int i = 0; i < 3; i++) {
      display(stack2);
      int top = pop(stack2);
      System.out.println(top);
    }
  }
}
