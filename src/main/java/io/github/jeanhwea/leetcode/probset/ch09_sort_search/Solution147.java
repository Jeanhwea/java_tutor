package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 对链表进行插入排序
 *
 * @author Jinghui Hu
 * @since 2021-08-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution147 {

  public static ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(-1);
    while (head != null) {
      ListNode p = dummy;
      while (p.next != null && p.next.val < head.val) p = p.next;
      ListNode q = p.next;
      p.next = head;
      head = head.next;
      p.next.next = q;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    // ListNode head = ListNode.makeList(new int[] {4, 2, 1, 3});
    ListNode head = ListNode.makeList(new int[] {4});
    ListNode res = insertionSortList(head);
    ListNode.dispList(res);
  }
}
