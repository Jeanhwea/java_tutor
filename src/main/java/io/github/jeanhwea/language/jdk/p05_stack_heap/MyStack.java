package io.github.jeanhwea.language.jdk.p05_stack_heap;

import java.util.*;

/**
 * 栈
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class MyStack {

  // 链表节点定义
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

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

  public static void main(String[] args) {
    ListNode stack0 = null;
    ListNode stack1 = makeStack(new int[] {1});
    ListNode stack2 = makeStack(new int[] {1, 2});
    ListNode stack3 = makeStack(new int[] {1, 2, 3, 4, 5, 6, 7});

    push(stack2, 4);
    push(stack2, 8);
    for (int i = 0; i < 3; i++) {
      dispStack(stack2);
      int top = pop(stack2);
      System.out.println(top);
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static ListNode makeStack(int[] a) {
    ListNode head = null, tail = null;
    for (int i = 0; i < a.length; i++) {
      ListNode node = new ListNode(a[i]);
      if (head == null) {
        head = node;
      } else {
        node.next = head;
        head = node;
      }
    }
    return head;
  }

  public static void dispStack(ListNode head) {
    if (head == null) {
      System.out.println("null");
      return;
    }

    List<Integer> vals = new LinkedList<Integer>();
    ListNode tail = head;
    while (tail != null) {
      vals.add(tail.val);
      tail = tail.next;
    }
    System.out.println(Arrays.toString(vals.toArray()));
  }
}
