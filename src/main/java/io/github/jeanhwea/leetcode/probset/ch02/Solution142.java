package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * 环形链表 II
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution142 {

  public static ListNode detectCycle(ListNode head) {

    return null;
  }

  public static ListNode detectCycle0(ListNode head) {
    Map<ListNode, Integer> seen = new HashMap<>();
    ListNode p = head;
    while (p != null) {
      if (seen.containsKey(p)) return p;
      seen.put(p, 1);
      p = p.next;
    }
    return null;
  }

  public static void main(String[] args) {
    // pass
  }
}
