package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution141 {

  public static boolean hasCycle(ListNode head) {
    ListNode p = head, q = head;
    while (q != null) {
      if (q.next == null) return false;
      p = p.next;
      q = q.next.next;
      if (p == q) return true;
    }
    return false;
  }

  public static boolean hasCycle0(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode p = head, q = head.next;
    while (p != null && q != null && q.next != null) {
      if (p == q) return true;
      p = p.next;
      q = q.next.next;
    }

    return false;
  }

  public static void main(String[] args) {
    // pass
  }
}
