package io.github.jeanhwea.leetcode.basic.ch04;

import java.util.*;

/**
 * 环形链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution141 {

  public static boolean hasCycle(ListNode head) {
    Set<ListNode> visited = new HashSet<>();
    ListNode p = head;
    while (p != null) {
      if (visited.contains(p)) {
        return true;
      } else {
        visited.add(p);
      }
      p = p.next;
    }
    return false;
  }

  public static boolean hasCycle1(ListNode head) {
    ListNode p = null, q = null;

    if (head == null || head.next == null) return false;
    p = head;
    q = head.next;

    while (true) {
      if (p == q) return true;
      if (p.next == null || q.next == null || q.next.next == null) break;
      p = p.next;
      q = q.next.next;
    }

    return false;
  }

  public static void main(String[] args) {}
}
