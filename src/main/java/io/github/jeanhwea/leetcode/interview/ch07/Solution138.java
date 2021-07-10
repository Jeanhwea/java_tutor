package io.github.jeanhwea.leetcode.interview.ch07;

import java.util.*;

/**
 * 复制带随机指针的链表
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
public class Solution138 {

  private static class Node {
    int val;
    Node next, random;

    Node() {}

    Node(int val) {
      this.val = val;
    }

    Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }

  public static Node copyRandomList(Node head) {
    Map<Node, Node> tb = new HashMap<>();
    Node p = head, head2 = null, q = null;
    while (p != null) {
      if (head2 == null) {
        head2 = q = new Node(p.val);
      } else {
        q = q.next = new Node(p.val);
      }
      tb.put(p, q);
      p = p.next;
    }

    p = head;
    q = head2;
    while (p != null) {
      q.random = tb.get(p.random);
      p = p.next;
      q = q.next;
    }

    return head2;
  }

  public static void main(String[] args) {
    //
  }
}
