package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * 复制带随机指针的链表
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution138 {

  private static class Node {
    int val;
    Node next, random;

    Node(int val) {
      this.val = val;
    }
  }

  public static Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node dummy = new Node(-1);

    Node p = head, q = dummy;
    while (p != null) {
      q.next = map.getOrDefault(p, new Node(p.val));
      map.putIfAbsent(p, q.next);
      if (p.random != null) {
        q.next.random = map.getOrDefault(p.random, new Node(p.random.val));
        map.putIfAbsent(p.random, q.next.random);
      }
      p = p.next;
      q = q.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    //
  }
}
