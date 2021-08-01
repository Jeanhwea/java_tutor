package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 合并两个有序链表
 *
 * @author Jinghui Hu
 * @since 2021-08-01, JDK1.8
 */
@SuppressWarnings("all")
public class Solution021 {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode p = l1, q = l2, dummy = new ListNode(-1), t = dummy;
    while (p != null && q != null) {
      if (p.val < q.val) {
        t = t.next = p;
        p = p.next;
        t.next = null;
      } else {
        t = t.next = q;
        q = q.next;
        t.next = null;
      }
    }
    t.next = p != null ? p : q;
    return dummy.next;
  }

  public static void main(String[] args) {
    // pass
  }
}
