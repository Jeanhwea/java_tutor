package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 排序链表
 *
 * @author Jinghui Hu
 * @since 2021-08-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution148 {

  public static ListNode sortList(ListNode head) {
    return merge(head, null);
  }

  // 归并排序 [beg, end]
  private static ListNode merge(ListNode beg, ListNode end) {
    if (beg == end) return beg;

    ListNode fast = beg, slow = beg;
    while (fast != end && fast.next != end) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode a = merge(slow.next, end);
    slow.next = null;
    ListNode b = merge(beg, slow);

    ListNode dummy = new ListNode(-1), p = dummy;
    while (a != null && b != null) {
      if (a.val < b.val) {
        p.next = a;
        a = a.next;
        p = p.next;
        p.next = null;
      } else {
        p.next = b;
        b = b.next;
        p = p.next;
        p.next = null;
      }
    }
    p.next = a != null ? a : b;

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.makeList(new int[] {1, 3, 8, 9, 11, 4, 5});
    ListNode res = sortList(head);
    ListNode.dispList(res);
  }
}
